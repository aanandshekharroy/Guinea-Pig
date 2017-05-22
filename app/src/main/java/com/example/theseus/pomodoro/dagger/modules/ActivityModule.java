package com.example.theseus.pomodoro.dagger.modules;

import android.app.Activity;

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
    HomeActivity homeActivity;
    HomeView homeView;
    public ActivityModule() {
    }

    public ActivityModule(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
        homeView=homeActivity;
    }
    @Provides
    @ApplicationScope
    public HomeActivity getHomeActivity(){
        return homeActivity;
    }

    @Provides
    @ApplicationScope
    public RewardsFragment getRewardsFragment(){
        return new RewardsFragment();
    }
    @Provides
    @ApplicationScope
    public HomePresenterInterface getHomePresenterInterface(HomeView homeView ){
        return new HomePresenter(homeView);
    }

    @Provides
    @ApplicationScope
    public RewardsPresenterInterface getRewardsPresenterInterface(HomeView homeView ){
        return new RewardsPresenter((Activity) homeView);
    }

    @Provides
    @ApplicationScope
    public RewardsModel getRewardsModel(){
        return new Rewards();
    }

    @Provides
    @ApplicationScope
    public HomeView getHomeView(){
        return homeView;
    }
}
