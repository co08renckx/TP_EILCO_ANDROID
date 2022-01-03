package com.example.tp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DetailsFragment extends Fragment {

    private String api_key = "603c388b932d1dca7a56879a352baef7";
    String language;
    String id;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public DetailsFragment(String id,String lang) {
        this.id=id;
        this.language=lang;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        //creation du service github
        TMDBService service = new Retrofit.Builder()
                .baseUrl(TMDBService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TMDBService.class);

        //appel vers le nom du repo
        service.getDetails(id,api_key,language).enqueue(new Callback<Movies>() {

            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                Movies movie = response.body();
                Movies film = new Movies(movie.getPoster_path(),movie.getId(),movie.getOriginal_title(),movie.getRelease_date(),movie.getOverview());

                Toast.makeText(DetailsFragment.this.getContext(),film.getOriginal_title(), Toast.LENGTH_SHORT).show();

                ImageView poster=view.findViewById(R.id.PosterDetails);
                Glide.with(poster).load(film.getPoster_path()).placeholder(R.drawable.ic_launcher_background).into(poster);

                TextView title=view.findViewById(R.id.Title);
                title.setText(film.getOriginal_title());

                TextView Descrition=view.findViewById(R.id.Description);
                Descrition.setText(film.getOverview());

                TextView Date=view.findViewById(R.id.ReleaseDate);
                Date.setText(film.getRelease_date());

                Button btn = (Button) getActivity().findViewById(R.id.btnFR);
                Button btn2 = (Button) getActivity().findViewById(R.id.btnEn);

            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Toast.makeText(DetailsFragment.this.getContext(),"ca marche pas", Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }

}