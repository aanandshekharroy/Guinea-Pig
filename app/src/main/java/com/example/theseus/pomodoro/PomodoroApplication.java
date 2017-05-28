package com.example.theseus.pomodoro;

import android.app.Application;
import android.content.Context;

import com.example.theseus.pomodoro.dagger.components.ApplicationComponent;
import com.example.theseus.pomodoro.dagger.components.DaggerApplicationComponent;
import com.example.theseus.pomodoro.dagger.modules.ApplicationModule;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

/**
 * Created by theseus on 20/5/17.
 */

public class PomodoroApplication extends Application {
    private ApplicationComponent mPomodoroApplicationComponent;
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
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        mContext=getApplicationContext();
        mPomodoroApplicationComponent= DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
//        activityComponent= DaggerActivityComponent.builder()
//        getA

    }
    public static Context getContext(){
        return mContext ;
    }
    public ApplicationComponent getPomodoroAppplicationComponent(){
        return mPomodoroApplicationComponent;
    }
}
