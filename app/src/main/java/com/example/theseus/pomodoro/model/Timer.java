package com.example.theseus.pomodoro.model;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;

import com.example.theseus.pomodoro.PomodoroApplication;
import com.example.theseus.pomodoro.R;
import com.example.theseus.pomodoro.dagger.components.DaggerPomodoroApplicationComponent;
import com.example.theseus.pomodoro.dagger.components.PomodoroApplicationComponent;
import com.example.theseus.pomodoro.dagger.modules.ContextModule;

import javax.inject.Inject;

import static java.lang.reflect.Array.getInt;

/**
 * Created by theseus on 20/5/17.
 */

public class Timer implements TimerModel {
    @Inject
    SharedPreferences sharedPreferences;

    public Timer(){
        PomodoroApplicationComponent component= DaggerPomodoroApplicationComponent
                .builder()
                .contextModule(new ContextModule(PomodoroApplication.getContext()))
                .build();
        component.inject(this);
    }

/*
* this is where you will get the data fro shared prefs
* */
    @Override
    public String getWorkTimerText() {
        return "25:00";
    }

    @Override
    public int getRestDuration() {
        int i=sharedPreferences.getInt("rest_duration",10);
        Log.d("Timer:","i="+i);
        return 0;
    }
/*
* start the service, service sends out event bus notification
*
* */
    @Override
    public void startCountdownTimer(String duration) {
        if(duration.equals("25:00")){

            /*
            *  starTheService
            * */
        }
    }
}
