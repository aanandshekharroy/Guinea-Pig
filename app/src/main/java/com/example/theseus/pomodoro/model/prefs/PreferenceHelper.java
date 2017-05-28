package com.example.theseus.pomodoro.model.prefs;

/**
 * Created by theseus on 28/5/17.
 */

public interface PreferenceHelper {
    int getPomodoroDuration();
    int getRestDuration();

    boolean getTimerRunning();
    int getTimerType();

    void setPomodoroDuration(int duration);
    void setRestDuration(int duration);
}
