package com.example.theseus.pomodoro;

import android.app.Application;

import com.example.theseus.pomodoro.dagger.components.PomodoroApplicationComponent;

/**
 * Created by theseus on 20/5/17.
 */

public class PomodoroApplication extends Application {
    private PomodoroApplicationComponent mPomodoroApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
//        mPomodoroApplicationComponent=
    }
    public PomodoroApplicationComponent getPomodoroAppplicationComponent(){
        return mPomodoroApplicationComponent;
    }
}
