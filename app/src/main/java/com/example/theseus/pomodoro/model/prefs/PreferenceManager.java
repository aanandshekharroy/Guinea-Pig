package com.example.theseus.pomodoro.model.prefs;

/**
 * Created by theseus on 28/5/17.
 */

public interface PreferenceManager {
    int getPomodoroDuration();
    int getRestDuration();
    void setPomodoroDuration(int duration);
    void setRestDuration(int duration);
}
