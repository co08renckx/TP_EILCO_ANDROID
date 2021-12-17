package com.example.tp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TMDBService {
    public static final String ENDPOINT = "https://api.themoviedb.org";

    @GET("/3/movie/popular")
    Call<Results> popularRequest(@Query("api_key") String api_key,@Query("language") String language);

    @GET("/3/movie/upcoming")
    Call<Results> upcomingRequest(@Query("api_key") String api_key,@Query("language") String language);
}
