package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private String language ="en-US";
    private static int ind_frag = 1; //1 pour popular, 2 pour upcoming
    private static int fragment_prec = 1;
    private static int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        passerEn(findViewById(R.id.fragment));
    }

    public void actPopular(View v) {
        ind_frag=1;
        fragment_prec=1;

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,new PopularFragment(language));
        fragmentTransaction.commit();

        Button btn = (Button) findViewById(R.id.btnPopular);
        btn.setBackgroundColor(Color.rgb(150,0,150));
        btn.setTextColor(Color.rgb(0,0,0));

        Button btn2 = (Button) findViewById(R.id.btnUpcoming);
        btn2.setBackgroundColor(Color.rgb(55,0,179));
        btn2.setTextColor(Color.rgb(255,255,255));

        Button btn3 = (Button) findViewById(R.id.btnSearch);
        btn3.setBackgroundColor(Color.rgb(55,0,179));
        btn3.setTextColor(Color.rgb(255,255,255));

    }

    public void actUpcoming(View v) {
        ind_frag=2;
        fragment_prec=2;

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,new UpcomingFragment(language));
        fragmentTransaction.commit();

        Button btn = (Button) findViewById(R.id.btnUpcoming);
        btn.setBackgroundColor(Color.rgb(150,0,150));
        btn.setTextColor(Color.rgb(0,0,0));

        Button btn2 = (Button) findViewById(R.id.btnPopular);
        btn2.setBackgroundColor(Color.rgb(55,0,179));
        btn2.setTextColor(Color.rgb(255,255,255));

        Button btn3 = (Button) findViewById(R.id.btnSearch);
        btn3.setBackgroundColor(Color.rgb(55,0,179));
        btn3.setTextColor(Color.rgb(255,255,255));
    }

    public static void setInd_frag(int ind_frag) {
        HomeActivity.ind_frag = ind_frag;
    }

    public void passerFr(View v) {
        language="fr-FR";

        //switch qui regarde le fragment affiché pour le relancer dans la langue
        switch (ind_frag){
            case 1: //on lance popular
                actPopular(v);
                break;

            case 2://on lance upcoming
                actUpcoming(v);
                break;

            case 3://on lance search
                actSearch(v);
                break;

            default: //on lance details

                List<Movies> moviesList;
                if(fragment_prec==1){
                     position= PopularFragment.getPosition();
                     moviesList = PopularFragment.getMoviesList();
                }else{
                    if(fragment_prec==2){
                        position = UpcomingFragment.getPosition();
                        moviesList = UpcomingFragment.getMoviesList();
                    }
                    else{
                        position = fragment_listRecherche.getPosition();
                        moviesList = fragment_listRecherche.getMoviesList();

                    }
                }

                Movies film = moviesList.get(position);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new DetailsFragment(film.getId(),language));
                fragmentTransaction.commit();

                break;
        }

        Button btn = (Button) findViewById(R.id.btnFR);
        btn.setBackgroundColor(Color.rgb(150,0,150));
        btn.setTextColor(Color.rgb(0,0,0));

        Button btn2 = (Button) findViewById(R.id.btnEn);
        btn2.setBackgroundColor(Color.rgb(55,0,179));
        btn2.setTextColor(Color.rgb(255,255,255));
    }

    public void passerEn(View v) {
        language="en-En";

        //switch qui regarde le fragment affiché pour le relancer dans la langue
        switch (ind_frag){
            case 1: //on lance popular
                actPopular(v);

                break;

            case 2://on lance upcoming
                actUpcoming(v);
                break;

            case 3://on lance search
                actSearch(v);
                break;

            default: //on lance details
                List<Movies> moviesList;
                if(fragment_prec==1){
                    position= PopularFragment.getPosition();
                    moviesList = PopularFragment.getMoviesList();
                }else{
                    if(fragment_prec==2){
                        position = UpcomingFragment.getPosition();
                        moviesList = UpcomingFragment.getMoviesList();
                    }
                    else{
                        position = fragment_listRecherche.getPosition();
                        moviesList = fragment_listRecherche.getMoviesList();

                    }
                }
                Movies film = moviesList.get(position);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new DetailsFragment(film.getId(),language));
                fragmentTransaction.commit();
                break;
        }

        Button btn = (Button) findViewById(R.id.btnEn);
        btn.setBackgroundColor(Color.rgb(150,0,150));
        btn.setTextColor(Color.rgb(0,0,0));

        Button btn2 = (Button) findViewById(R.id.btnFR);
        btn2.setBackgroundColor(Color.rgb(55,0,179));
        btn2.setTextColor(Color.rgb(255,255,255));

    }

    public void actSearch(View view) {
        ind_frag=3;
        fragment_prec=3;

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,new RechercheFragment(language));
        fragmentTransaction.commit();

        Button btn = (Button) findViewById(R.id.btnUpcoming);
        btn.setBackgroundColor(Color.rgb(55,0,179));
        btn.setTextColor(Color.rgb(255,255,255));

        Button btn2 = (Button) findViewById(R.id.btnPopular);
        btn2.setBackgroundColor(Color.rgb(55,0,179));
        btn2.setTextColor(Color.rgb(255,255,255));

        Button btn3 = (Button) findViewById(R.id.btnSearch);
        btn3.setBackgroundColor(Color.rgb(150,0,150));
        btn3.setTextColor(Color.rgb(0,0,0));
    }
}