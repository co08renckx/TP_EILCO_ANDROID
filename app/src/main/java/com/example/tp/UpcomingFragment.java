package com.example.tp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpcomingFragment extends Fragment {
    String language;

    public UpcomingFragment() {
        // Required empty public constructor
    }
    public UpcomingFragment(String lang){
        language=lang;
    }

    //code non généré par Fragment

    private String api_key = "603c388b932d1dca7a56879a352baef7";
    private List<Movies> moviesList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_upcoming, container, false);

        //on récupére le recyclerView
        RecyclerView rvUpcoming = (RecyclerView) view.findViewById(R.id.rvUpcoming);

        //type de LayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(),2, LinearLayoutManager.VERTICAL,false);

        //creation du service github
        TMDBService service = new Retrofit.Builder()
                .baseUrl(TMDBService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TMDBService.class);

        //appel vers le nom du repo
        service.upcomingRequest(api_key,language).enqueue(new Callback<Results>() {

            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                for (Movies movie : response.body().getResults()) {
                    moviesList.add(new Movies(movie.getPoster_path(),movie.getId(),movie.getOriginal_title(),movie.getRelease_date()));
                }
                //adapteur et initialisation
                MovieAdapter adapter = new MovieAdapter(moviesList);

                //on indique l'adapter au recycler
                rvUpcoming.setAdapter(adapter);

                rvUpcoming.setLayoutManager(gridLayoutManager);
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
            }
        });

        return view;


    }
}