package com.example.theseus.pomodoro.dagger.modules;

import android.app.FragmentManager;
import android.content.Context;

import com.example.theseus.pomodoro.dagger.scopes.ApplicationScope;
import com.example.theseus.pomodoro.view.HomeActivity;

import dagger.Module;
import dagger.Provides;
import android.support.v4.app.Fragment;

/**
 * Created by theseus on 22/5/17.
 */
@Module(includes = {ActivityModule.class})
public class FragmentManagerModule {
    @ApplicationScope
    @Provides
    public FragmentManager getFragmenftManager(HomeActivity homeActivity){
        return homeActivity.getFragmentManager();
    }
}
