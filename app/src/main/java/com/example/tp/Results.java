package com.example.tp;

import java.util.List;

public class Results {

    private List<Movies> results;

    //constructeur
    public Results(List<Movies> results){
        this.results=results;
    }

//getters & setters à générer avec android studio

    public List<Movies> getResults() {
        return results;
    }
}
