package com.example.theseus.marvel;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by theseus on 12/4/17.
 */

public class MarvelApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if(!BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
        Timber.e("errorfre");
    }
}
