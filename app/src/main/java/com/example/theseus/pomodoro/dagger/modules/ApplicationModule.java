package com.example.theseus.pomodoro.dagger.modules;


import android.app.Application;
import android.content.Context;

import com.example.theseus.pomodoro.dagger.scopes.ApplicationScope;
import com.example.theseus.pomodoro.model.AppDataManager;
import com.example.theseus.pomodoro.model.DataManager;
import com.example.theseus.pomodoro.model.prefs.AppPreference;
import com.example.theseus.pomodoro.model.prefs.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by theseus on 20/5/17.
 */
@Module
public class ApplicationModule {
    private Application mContext;
    public ApplicationModule(Application context){
        mContext=context;
    }
    @Provides
    @ApplicationScope
    public Application getApplicationContext(){
        return mContext;
    };

    @Provides
    @Singleton
    public PreferenceManager getPreferenceManager(AppPreference appPreference){
        return appPreference;
    }

    @Provides
    @Singleton
    public DataManager getDataManager(AppDataManager appDataManager){
        return appDataManager;
    }
}
