package com.example.theseus.bingewatch.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.theseus.bingewatch.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {
    private Unbinder unbinder;

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
        ButterKnife.bind(this, view);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(),"asd",Toast.LENGTH_SHORT).show();
                doSomething();
            }
        });
        return view;
    }

    private void doSomething() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
