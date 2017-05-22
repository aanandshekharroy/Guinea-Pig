package com.example.theseus.pomodoro;

import android.app.Application;
import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.example.theseus.pomodoro.dagger.components.DaggerPomodoroApplicationComponent;
import com.example.theseus.pomodoro.dagger.components.PomodoroApplicationComponent;
import com.example.theseus.pomodoro.dagger.modules.ActivityModule;
import com.example.theseus.pomodoro.dagger.modules.ContextModule;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

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
        Stetho.initializeWithDefaults(this);
        ActiveAndroid.initialize(this);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        mContext=getApplicationContext();
        mPomodoroApplicationComponent= DaggerPomodoroApplicationComponent
                .builder()
                .contextModule(new ContextModule(mContext))
                .build();
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
