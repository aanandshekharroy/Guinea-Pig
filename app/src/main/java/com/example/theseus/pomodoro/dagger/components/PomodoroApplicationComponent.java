package com.example.theseus.pomodoro.dagger.components;

import com.example.theseus.pomodoro.dagger.modules.ContextModule;
import com.example.theseus.pomodoro.dagger.modules.SharedPreferencesModule;
import com.example.theseus.pomodoro.dagger.scopes.ApplicationScope;
import com.example.theseus.pomodoro.model.TimerModel;

import dagger.Component;
import dagger.Module;

/**
 * Created by theseus on 20/5/17.
 */
@ApplicationScope
@Component(modules = {ContextModule.class, SharedPreferencesModule.class})
public interface PomodoroApplicationComponent {
    void inject(TimerModel timerModel);
}