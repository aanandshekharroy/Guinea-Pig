package com.example.theseus.pomodoro.model;

import android.os.SystemClock;

import com.example.theseus.pomodoro.model.db.PomodoroStats;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import timber.log.Timber;

/**
 * Created by theseus on 20/5/17.
 */

public class Rewards implements RewardsModel {
    @Override
    public void storeRewards() {
        int score=25;
        String end_time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String start_time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        PomodoroStats pomodoroStats=new PomodoroStats(start_time,end_time,score,true);
        pomodoroStats.save();
    }
}
