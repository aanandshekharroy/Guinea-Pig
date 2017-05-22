package com.example.theseus.pomodoro.model;

/**
 * Created by theseus on 20/5/17.
 */

public interface TimerModel {
    public String getWorkTimerText();
    public int getRestDuration();

    void startCountdownTimer(String duration);

    String getRestTimerText();

    String getTimerTextFromMilliseconds(long millisUntilFinished);
}
