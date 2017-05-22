package com.example.theseus.pomodoro.view;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.theseus.pomodoro.R;
import com.example.theseus.pomodoro.presenter.RewardsPresenter;
import com.example.theseus.pomodoro.presenter.RewardsPresenterInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by theseus on 22/5/17.
 */

public class RewardsFragment extends DialogFragment implements RewardsView{
    @BindView(R.id.accept_reward)
    Button accept_reward;
    @BindView(R.id.reject_reward)
    Button reject_reward;

    RewardsPresenterInterface rewardsPresenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        rewardsPresenter=new RewardsPresenter(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rewards_view=inflater.inflate(R.layout.rewards_fragment,null,false);
        ButterKnife.bind(this, rewards_view);
        return rewards_view;
    }
    @OnClick(R.id.accept_reward)
    public void rewardAccepted(){
        rewardsPresenter.acceptRewards();
    };
    @OnClick(R.id.reject_reward)
    public void rewardRejected(){
        rewardsPresenter.rejectRewards();
    };

    @Override
    public void dismissRewardsFragment() {

    }
}
