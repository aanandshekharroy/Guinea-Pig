package com.example.theseus.pomodoro.model;

import org.w3c.dom.Text;

/**
 * Created by theseus on 28/5/17.
 */

public interface DataManager {
    void storeRewards();

    boolean isTimerRunning();
    String getWorkDurationText();

    String getRestDurationText();
}
