package com.example.theseus.pomodoro.model.db;

/**
 * Created by theseus on 28/5/17.
 */

public interface DBHelper {
    void storeRewards(String start_time, String end_time,int score,boolean isComplete);
}
