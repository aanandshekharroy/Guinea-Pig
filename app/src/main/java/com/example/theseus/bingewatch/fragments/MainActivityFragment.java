package com.example.theseus.bingewatch.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.theseus.bingewatch.ApiClient;
import com.example.theseus.bingewatch.ApiInterface;
import com.example.theseus.bingewatch.R;
import com.example.theseus.bingewatch.Utility;
import com.example.theseus.bingewatch.adapters.MovieAdapter;
import com.example.theseus.bingewatch.model.MoviesResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {
    private static final String LOG_TAG=MainActivityFragment.class.getSimpleName();
    private Unbinder unbinder;
    ApiInterface apiService;
    @BindView(R.id.movie_grid)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    public MainActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_main_activity, container, false);
        unbinder=ButterKnife.bind(this, view);
//        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),
//                Utility.calculateNoOfColumns(getContext())));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d(LOG_TAG,"response size: ");

//                Toast.makeText(getContext(),"asd",Toast.LENGTH_SHORT).show();
                fetchData();
            }
        });
        return view;
    }

    private void fetchData() {
        String api_key=getString(R.string.movie_api_key);
        apiService= ApiClient.getClient().create(ApiInterface.class);
        Call<MoviesResponse> call=apiService.getTopRatedMovies(api_key);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<MoviesResponse.Movies> movies=response.body().getMovies();
                Log.d(LOG_TAG,"response size: "+movies.size());
                        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                mRecyclerView.setAdapter(new MovieAdapter(movies));
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
