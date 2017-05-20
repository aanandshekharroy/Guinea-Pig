package com.example.theseus.pomodoro.model;

/**
 * Created by theseus on 20/5/17.
 */

public interface TimerModel {
    public int getWorkTimerDuration(String state);
    public int getRestDuration();
}
