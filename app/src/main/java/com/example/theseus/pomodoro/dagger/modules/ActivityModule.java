package com.example.theseus.pomodoro.dagger.modules;

import android.app.Activity;
import android.content.Context;

import com.example.theseus.pomodoro.dagger.ActivityContext;
import com.example.theseus.pomodoro.dagger.scopes.ApplicationScope;
import com.example.theseus.pomodoro.model.Rewards;
import com.example.theseus.pomodoro.model.RewardsModel;
import com.example.theseus.pomodoro.presenter.HomePresenter;
import com.example.theseus.pomodoro.presenter.HomePresenterInterface;
import com.example.theseus.pomodoro.presenter.RewardsPresenter;
import com.example.theseus.pomodoro.presenter.RewardsPresenterInterface;
import com.example.theseus.pomodoro.view.HomeActivity;
import com.example.theseus.pomodoro.view.HomeView;
import com.example.theseus.pomodoro.view.RewardsFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by theseus on 22/5/17.
 */
@Module
public class ActivityModule {
    Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }
    @Provides
    @ActivityContext
    public Context getContext(){
        return mActivity;
    }
}
