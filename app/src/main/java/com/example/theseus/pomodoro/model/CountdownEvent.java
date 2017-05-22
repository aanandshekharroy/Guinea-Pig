package com.example.theseus.pomodoro.model;

/**
 * Created by theseus on 21/5/17.
 */

public class CountdownEvent {
    boolean eventFinished;
    long millisUntilFinished;
    float fraction;
    String type;
    public CountdownEvent(boolean eventFinished, long millisUntilFinished, float fraction) {
        this.eventFinished = eventFinished;
        this.millisUntilFinished = millisUntilFinished;
        this.fraction = fraction;
    }

    public CountdownEvent(boolean eventFinished, long millisUntilFinished){
        this.eventFinished=eventFinished;
        this.millisUntilFinished=millisUntilFinished;
    }

    public CountdownEvent(boolean eventFinished, String type) {
        this.eventFinished=eventFinished;
        this.type=type;
    }

    public float getFraction() {
        return fraction;
    }

    public String getType() {
        return type;
    }

    public boolean isEventFinished() {
        return eventFinished;
    }

    public long getMillisUntilFinished() {
        return millisUntilFinished;
    }
}
