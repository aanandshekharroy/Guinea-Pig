package com.example.theseus.pomodoro.model.db;

import com.example.theseus.pomodoro.model.db.model.DaoMaster;
import com.example.theseus.pomodoro.model.db.model.DaoSession;
import com.example.theseus.pomodoro.model.db.model.PomodoroStats;

import javax.inject.Inject;

/**
 * Created by theseus on 28/5/17.
 */

public class AppDB implements DBHelper{
    private DaoSession daoSession;
    @Inject
    public AppDB(DBOpenHelper dbOpenHelper){
        daoSession=new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public void storeRewards(String start_time, String end_time, int score, boolean isComplete) {
        daoSession.getPomodoroStatsDao().insert(new PomodoroStats(start_time,end_time,score,isComplete));
    }
}
