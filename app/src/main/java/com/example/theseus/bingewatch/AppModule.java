package com.example.theseus.bingewatch;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by theseus on 3/4/17.
 */
@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application application){
        mApplication=application;
    }


    @Provides
    @Singleton
    Application providesApplication(){
        return mApplication;
    }
}
