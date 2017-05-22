package com.example.theseus.pomodoro.dagger.components;

import com.example.theseus.pomodoro.dagger.modules.ActivityModule;
import com.example.theseus.pomodoro.dagger.modules.FragmentManagerModule;
import com.example.theseus.pomodoro.dagger.scopes.ApplicationScope;
import com.example.theseus.pomodoro.view.HomeActivity;

import dagger.Component;

/**
 * Created by theseus on 22/5/17.
 */
@ApplicationScope
@Component(modules = {ActivityModule.class, FragmentManagerModule.class})
public interface ActivityComponent {
    void inject(HomeActivity homeActivity);
}
