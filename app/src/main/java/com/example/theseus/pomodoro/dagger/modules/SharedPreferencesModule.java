package com.example.theseus.pomodoro.dagger.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.theseus.pomodoro.dagger.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by theseus on 20/5/17.
 */
@Module(includes = {ApplicationModule.class})
public class SharedPreferencesModule {
    @Provides
    @ApplicationScope
    public SharedPreferences getSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
