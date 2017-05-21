package com.example.theseus.pomodoro;

import android.app.Application;
import android.content.Context;

import com.example.theseus.pomodoro.dagger.components.DaggerPomodoroApplicationComponent;
import com.example.theseus.pomodoro.dagger.components.PomodoroApplicationComponent;
import com.example.theseus.pomodoro.dagger.modules.ContextModule;

/**
 * Created by theseus on 20/5/17.
 */

public class PomodoroApplication extends Application {
    private PomodoroApplicationComponent mPomodoroApplicationComponent;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        mPomodoroApplicationComponent= DaggerPomodoroApplicationComponent
                .builder()
                .contextModule(new ContextModule(mContext))
                .build();
//        getA

    }
    public static Context getContext(){
        return mContext ;
    }
    public PomodoroApplicationComponent getPomodoroAppplicationComponent(){
        return mPomodoroApplicationComponent;
    }
    public static String getRe(){
        return "Ff";
    }
}
