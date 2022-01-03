package com.example.tp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fragment_listRecherche extends Fragment implements MovieAdapter.ListItemClickListener {
    private String api_key = "603c388b932d1dca7a56879a352baef7";
    String nom;
    String language;
    View view;
    static List<Movies> moviesList = new ArrayList<>();
    private String id_film;
    static int position;

    public fragment_listRecherche() {
        // Required empty public constructor
    }
    public fragment_listRecherche(View v,String lang, String nom) {
        view=v;
        language=lang;
        this.nom=nom;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Toast.makeText(fragment_listRecherche.this.getContext(),nom,Toast.LENGTH_SHORT).show();
        View view = inflater.inflate(R.layout.fragment_list_recherche, container, false);
        //on récupére le recyclerView
        RecyclerView rvRecherche = (RecyclerView) view.findViewById(R.id.rvlistRecherche);

        //type de LayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(),2, LinearLayoutManager.VERTICAL,false);

        //je vide la movieList
        moviesList.clear();

        //creation du service github
        TMDBService service = new Retrofit.Builder()
                .baseUrl(TMDBService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TMDBService.class);
        //appel vers le nom du repo
        service.searchRequest(api_key,language,nom).enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                for (Movies movie : response.body().getResults()) {
                    moviesList.add(new Movies(movie.getPoster_path(),movie.getOriginal_title(),movie.getId()));
                }

                //adapteur et initialisation
                MovieAdapter adapter = new MovieAdapter(moviesList,fragment_listRecherche.this);

                //on indique l'adapter au recycler
                rvRecherche.setAdapter(adapter);

                rvRecherche.setLayoutManager(gridLayoutManager);
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
            }

        });

        return view;
    }


    @Override
    public void onListItemClick(int position) {
        Movies film=moviesList.get(position);
        FragmentManager fm = fragment_listRecherche.this.getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,new DetailsFragment(film.getId(),language));
        fragmentTransaction.commit();
        chgtCouleurBtn();
        setId_film(film.getId());
        HomeActivity.setInd_frag(0);
        setPosition(position);

    }

    public void chgtCouleurBtn(){
        Button btn = (Button) getActivity().findViewById(R.id.btnPopular);
        btn.setBackgroundColor(Color.rgb(55,0,179));
        btn.setTextColor(Color.rgb(255,255,255));

        Button btn2 = (Button) getActivity().findViewById(R.id.btnUpcoming);
        btn2.setBackgroundColor(Color.rgb(55,0,179));
        btn2.setTextColor(Color.rgb(255,255,255));

        Button btn3 = (Button) getActivity().findViewById(R.id.btnSearch);
        btn3.setBackgroundColor(Color.rgb(55,0,179));
        btn3.setTextColor(Color.rgb(255,255,255));


    }

    public String getId_film() {
        return id_film;
    }

    public void setId_film(String id_film) {
        this.id_film = id_film;
    }

    public void setPosition(int position){
        this.position=position;
    }

    public static int getPosition(){
        return position;
    }

    public static List<Movies> getMoviesList() {
        return moviesList;
    }

    public static void setMoviesList(List<Movies> moviesList) {
        PopularFragment.moviesList = moviesList;
    }


}