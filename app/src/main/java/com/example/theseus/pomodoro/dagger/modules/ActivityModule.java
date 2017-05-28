package com.example.theseus.pomodoro.dagger.modules;

import android.app.Activity;
import android.content.Context;

import com.example.theseus.pomodoro.dagger.ActivityContext;
import com.example.theseus.pomodoro.ui.home.HomePresenter;
import com.example.theseus.pomodoro.ui.home.HomePresenterInterface;
import com.example.theseus.pomodoro.ui.home.HomeView;

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
    @Provides
    public HomePresenterInterface<HomeView> getHomePresenter(HomePresenter<HomeView> homePresenter){
        return homePresenter;
    }
}
