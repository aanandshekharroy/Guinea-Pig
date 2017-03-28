package com.example.theseus.bingewatch.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.theseus.bingewatch.R;
import com.example.theseus.bingewatch.model.MoviesResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by theseus on 29/3/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private static final String LOG_TAG = MovieAdapter.class.getSimpleName();
    List<MoviesResponse.Movies> moviesList;

    public MovieAdapter(List<MoviesResponse.Movies> movies) {
        moviesList=movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_grid_item,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Log.d(LOG_TAG,"title:"+moviesList.get(position).getTitle());
        holder.movieTitle.setText(moviesList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_title)
        TextView movieTitle;
        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
