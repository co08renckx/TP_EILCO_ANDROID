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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        passerEn(findViewById(R.id.fragment));
        

    }

    public void actPopular(View v) {
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
        actPopular(v);

        Button btn = (Button) findViewById(R.id.btnFR);
        btn.setBackgroundColor(Color.rgb(150,0,150));
        btn.setTextColor(Color.rgb(0,0,0));

        Button btn2 = (Button) findViewById(R.id.btnEn);
        btn2.setBackgroundColor(Color.rgb(55,0,179));
        btn2.setTextColor(Color.rgb(255,255,255));
    }

    public void passerEn(View v) {
        language="en-En";
        actPopular(v);

        Button btn = (Button) findViewById(R.id.btnEn);
        btn.setBackgroundColor(Color.rgb(150,0,150));
        btn.setTextColor(Color.rgb(0,0,0));

        Button btn2 = (Button) findViewById(R.id.btnFR);
        btn2.setBackgroundColor(Color.rgb(55,0,179));
        btn2.setTextColor(Color.rgb(255,255,255));

    }

}