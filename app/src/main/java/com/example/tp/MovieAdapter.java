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

        private final ListItemClickListener mOnClickListener;

        private final List<Movies> mMovies;

        interface ListItemClickListener{
            void onListItemClick(int position, List<Movies> movies);
        }

        public MovieAdapter(List<Movies> Movies,ListItemClickListener onClickListener) {
            mMovies = Movies;
            mOnClickListener=onClickListener;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder  (@NonNull ViewGroup parent,int viewType){
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
        }


        @Override
        public int getItemCount () {
            return mMovies.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            public ImageView poster1;

            public ViewHolder  (View itemView) {
                super(itemView);
                poster1 = (ImageView) itemView.findViewById(R.id.Poster1);
                itemView.setOnClickListener(this);

            }
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                mOnClickListener.onListItemClick(position,mMovies);

            }
        }

    public List<Movies> getmMovies() {
        return mMovies;
    }
}

