package com.example.theseus.pomodoro.dagger.components;

import android.app.Activity;

import com.example.theseus.pomodoro.dagger.modules.ActivityModule;
import com.example.theseus.pomodoro.dagger.scopes.ApplicationScope;
import com.example.theseus.pomodoro.ui.home.HomeActivity;
import com.example.theseus.pomodoro.ui.rewards.RewardsPresenter;

import dagger.Component;

/**
 * Created by theseus on 22/5/17.
 */
@ApplicationScope
@Component(dependencies = {ApplicationComponent.class},modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(HomeActivity activity);

//    void inject(RewardsPresenter rewardsPresenter);
}
