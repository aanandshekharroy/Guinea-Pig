package com.example.theseus.pomodoro.view;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.theseus.pomodoro.R;

/**
 * Created by theseus on 22/5/17.
 */

public class RewardsFragment extends DialogFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rewards_view=inflater.inflate(R.layout.rewards_fragment,null,false);
        return rewards_view;
    }
}
