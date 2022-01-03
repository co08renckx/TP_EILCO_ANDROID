package com.example.tp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RechercheFragment extends Fragment {
    String language;
    EditText etTitre;

    public RechercheFragment() {
        // Required empty public constructor
    }
    public RechercheFragment(String lang) {
        language=lang;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_recherche, container, false);

       Button btn = (Button) view.findViewById(R.id.btnRecherche);
       etTitre = (EditText) view.findViewById(R.id.etTitrefilm);
      // etTitre.setText("");
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String nom = String.valueOf(etTitre.getText());
              // Toast.makeText(RechercheFragment.this.getContext(),nom,Toast.LENGTH_SHORT).show();
               if(nom.length()!=0){
                   FragmentManager fm = getFragmentManager();
                   FragmentTransaction fragmentTransaction = fm.beginTransaction();
                   fragmentTransaction.replace(R.id.fragment,new fragment_listRecherche(v,language,nom));
                   fragmentTransaction.commit();
               }
               else{
                   Toast.makeText(RechercheFragment.this.getContext(),"Attention champ vide !",Toast.LENGTH_SHORT).show();
               }

           }
       });

        return view;


    }

}