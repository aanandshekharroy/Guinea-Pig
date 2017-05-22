package com.example.theseus.pomodoro;

import android.app.Application;
import android.content.Context;

import com.example.theseus.pomodoro.dagger.components.DaggerPomodoroApplicationComponent;
import com.example.theseus.pomodoro.dagger.components.PomodoroApplicationComponent;
import com.example.theseus.pomodoro.dagger.modules.ActivityModule;
import com.example.theseus.pomodoro.dagger.modules.ContextModule;

import timber.log.Timber;

/**
 * Created by theseus on 20/5/17.
 */

public class PomodoroApplication extends Application {
    private PomodoroApplicationComponent mPomodoroApplicationComponent;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.uprootAll();
            Timber.plant(new Timber.DebugTree());
        }
        Timber.d("started");
        mContext=getApplicationContext();
//        mPomodoroApplicationComponent= DaggerPomodoroApplicationComponent
//                .builder()
//.activityModule(new ActivityModule())
//                .contextModule(new ContextModule(mContext))
//                .build();
//        activityComponent= DaggerActivityComponent.builder()
//        getA

    }
    public static Context getContext(){
        return mContext ;
    }
    public PomodoroApplicationComponent getPomodoroAppplicationComponent(){
        return mPomodoroApplicationComponent;
    }
}
