package com.example.tp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

        private final List<Movies> mMovies;

        public MovieAdapter(List<Movies> Movies) {
            mMovies = Movies;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            View PopularView = inflater.inflate(R.layout.movie_item, parent, false);
            return new ViewHolder(PopularView);
        }

        @Override
        public void onBindViewHolder (@NonNull ViewHolder holder,int position){

            Movies movie = mMovies.get(position);

            ImageView poster1 = holder.poster1;
            Glide.with(poster1).load(movie.getPoster_path()).placeholder(R.drawable.ic_launcher_background).into(poster1);

            TextView title = holder.title;
            title.setText(movie.getOriginal_title());
        }


        @Override
        public int getItemCount () {
            return mMovies.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView poster1;
            public TextView title;

            public ViewHolder(View itemView) {
                super(itemView);

                poster1 = (ImageView) itemView.findViewById(R.id.Poster1);
                title = (TextView) itemView.findViewById(R.id.Title);
            }
        }

    }

