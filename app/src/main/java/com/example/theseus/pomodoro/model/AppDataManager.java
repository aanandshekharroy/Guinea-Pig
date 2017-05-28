package com.example.theseus.pomodoro.model;

import com.example.theseus.pomodoro.Utilities;
import com.example.theseus.pomodoro.model.db.DBHelper;
import com.example.theseus.pomodoro.model.prefs.PreferenceHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by theseus on 28/5/17.
 */
@Singleton
public class AppDataManager implements DataManager{
    PreferenceHelper mPrefs;
    DBHelper mDBHelper;
    @Inject
    public AppDataManager(PreferenceHelper mPrefs, DBHelper mDBHelper) {
        this.mPrefs = mPrefs;
        this.mDBHelper = mDBHelper;
    }

    @Override
    public void storeRewards() {
        int score=mPrefs.getPomodoroDuration();
        String end_time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String start_time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        mDBHelper.storeRewards(start_time,end_time,score,true);
    }

    @Override
    public boolean isTimerRunning() {
        return mPrefs.getTimerRunning();
    }

    @Override
    public String getWorkDurationText() {
        long milliseconds=mPrefs.getPomodoroDuration()*60*1000;
        return Utilities.getTimeStringFromMilliseconds(milliseconds);
    }

    @Override
    public String getRestDurationText() {
        long milliseconds=mPrefs.getRestDuration()*60*1000;
        return Utilities.getTimeStringFromMilliseconds(milliseconds);
    }

}
