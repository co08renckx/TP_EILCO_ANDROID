package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private String language ="en-US";
    private int ind_frag = 0; //0 pour popular, 1 pour upcoming

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        passerEn(findViewById(R.id.fragment));
    }

    public void actPopular(View v) {
        ind_frag=0;

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

    }

    public void actUpcoming(View v) {
        ind_frag=1;

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
    }

    public void passerFr(View v) {
        language="fr-FR";

        //switch qui regarde le fragment affiché pour le relancer dans la langue
        switch (ind_frag){
            case 1: //on lance upcoming
                actUpcoming(v);
                break;

            case 2: //on lance details
                //actDetails(v);
                break;

            default: //on lance popular
                actPopular(v);
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
            case 1: //on lance upcoming
                actUpcoming(v);
                break;

            case 2: //on lance details
                //actDetails(v);
                break;

            default: //on lance popular
                actPopular(v);
                break;
        }

        Button btn = (Button) findViewById(R.id.btnEn);
        btn.setBackgroundColor(Color.rgb(150,0,150));
        btn.setTextColor(Color.rgb(0,0,0));

        Button btn2 = (Button) findViewById(R.id.btnFR);
        btn2.setBackgroundColor(Color.rgb(55,0,179));
        btn2.setTextColor(Color.rgb(255,255,255));

    }

    /*public void actDetails(View view) {
        ind_frag=2;

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,new DetailsFragment("",language));
        fragmentTransaction.commit();

        Button btn1 = (Button) findViewById(R.id.btnPopular);
        btn1.setBackgroundColor(Color.rgb(55,0,179));
        btn1.setTextColor(Color.rgb(255,255,255));

        Button btn2 = (Button) findViewById(R.id.btnUpcoming);
        btn2.setBackgroundColor(Color.rgb(55,0,179));
        btn2.setTextColor(Color.rgb(255,255,255));
    }*/

}