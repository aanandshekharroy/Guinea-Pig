package com.example.theseus.pomodoro.presenter;

import android.app.Activity;

import com.example.theseus.pomodoro.dagger.components.ActivityComponent;
import com.example.theseus.pomodoro.dagger.components.DaggerActivityComponent;
import com.example.theseus.pomodoro.dagger.modules.ActivityModule;
import com.example.theseus.pomodoro.model.RewardsModel;
import com.example.theseus.pomodoro.view.HomeActivity;
import com.example.theseus.pomodoro.view.HomeView;
import com.example.theseus.pomodoro.view.RewardsView;

import javax.inject.Inject;

/**
 * Created by theseus on 20/5/17.
 */

public class RewardsPresenter<V extends RewardsView>
        extends BasePresenter<V> implements RewardsPresenterInterface<V>{
    @Inject
    HomePresenterInterface homePresenter;
    @Inject
    RewardsModel rewardsModel;

    public RewardsPresenter() {
        ActivityComponent component= DaggerActivityComponent
                .builder()
                .activityModule(new ActivityModule((HomeActivity) activity))
                .build();
        component.inject(this);
    }

    @Override
    public void acceptRewards() {
        rewardsModel.storeRewards();
        homePresenter.rewardsFragmentDismissed();
        homePresenter.setupRestTimer();
    }

    @Override
    public void rejectRewards() {
        homePresenter.rewardsFragmentDismissed();
    }
}
