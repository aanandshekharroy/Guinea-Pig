package com.example.theseus.marvel;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by theseus on 12/4/17.
 */
@Module
public class SharedPreferenceModule {
    @Provides
    public SharedPreferences getSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}

