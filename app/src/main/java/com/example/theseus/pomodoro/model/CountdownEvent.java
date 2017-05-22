package com.example.theseus.pomodoro.model;

/**
 * Created by theseus on 21/5/17.
 */

public class CountdownEvent {
    boolean eventFinished;
    long millisUntilFinished;
    public CountdownEvent(boolean eventFinished, long millisUntilFinished){
        this.eventFinished=eventFinished;
        this.millisUntilFinished=millisUntilFinished;
    }

    public boolean isEventFinished() {
        return eventFinished;
    }

    public long getMillisUntilFinished() {
        return millisUntilFinished;
    }
}
