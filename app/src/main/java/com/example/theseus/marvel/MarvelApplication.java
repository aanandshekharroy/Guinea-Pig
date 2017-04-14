package com.example.theseus.marvel;

import android.app.Application;

import com.example.theseus.marvel.components.MarvelApplicationComponent;
import com.example.theseus.marvel.modules.ContextModule;

import timber.log.Timber;

/**
 * Created by theseus on 12/4/17.
 */

public class MarvelApplication extends Application {
    public MarvelApplicationComponent marvelApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        if(!BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
        Timber.e("errorfre");
        marvelApplicationComponent=  DaggerMarvelApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }
    public MarvelApplicationComponent getMarvelApplicationComponent(){
        return marvelApplicationComponent;
    }
}
