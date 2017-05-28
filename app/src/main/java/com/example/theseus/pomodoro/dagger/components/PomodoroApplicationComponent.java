package com.example.theseus.pomodoro.dagger.components;

import com.example.theseus.pomodoro.dagger.modules.ApplicationModule;
import com.example.theseus.pomodoro.dagger.modules.SharedPreferencesModule;
import com.example.theseus.pomodoro.dagger.scopes.ApplicationScope;
import com.example.theseus.pomodoro.model.Timer;

import dagger.Component;

/**
 * Created by theseus on 20/5/17.
 */
@ApplicationScope
@Component(modules = {ApplicationModule.class, SharedPreferencesModule.class})
public interface PomodoroApplicationComponent {
    void inject(Timer timer);
}
