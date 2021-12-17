package com.example.tp;

public class Movies {

    public String poster_path="https://image.tmdb.org/t/p/w500";
    public String id;
    public String title;
    public String release_date;

    public Movies(String path, String id, String title, String release_date){
        this.poster_path=this.getPoster_path()+path;
        this.id=id;
        this.title=title;
        this.release_date=release_date;
    }

    //getter
    public String getPoster_path() {
        return poster_path;
    }

    public String getId() {
        return id;
    }

    public String getOriginal_title() {
        return title;
    }

    public String getRelease_date() {
        return release_date;
    }
}
