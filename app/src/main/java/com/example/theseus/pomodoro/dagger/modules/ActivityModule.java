package com.example.theseus.pomodoro.dagger.modules;

import com.example.theseus.pomodoro.dagger.scopes.ApplicationScope;
import com.example.theseus.pomodoro.view.HomeActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by theseus on 22/5/17.
 */
@Module
public class ActivityModule {
    HomeActivity homeActivity;

    public ActivityModule() {
    }

    public ActivityModule(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }
    @Provides
    @ApplicationScope
    public HomeActivity getHomeActivity(){
        return homeActivity;
    }
}
