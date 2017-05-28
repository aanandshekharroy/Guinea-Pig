package com.example.theseus.pomodoro.model.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by theseus on 22/5/17.
 */
@Entity(nameInDb = "pomodoro_stats")
public class PomodoroStats {
    @Id(autoincrement = true)
    private Long id;
    String start_time;

    String end_time;

    int score;

    boolean isCompleted;

    public PomodoroStats(String start_time, String end_time, int score, boolean isCompleted) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.score = score;
        this.isCompleted = isCompleted;
    }
//    public int get




    @Generated(hash = 952086672)
    public PomodoroStats(Long id, String start_time, String end_time, int score,
            boolean isCompleted) {
        this.id = id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.score = score;
        this.isCompleted = isCompleted;
    }




    @Generated(hash = 1607551969)
    public PomodoroStats() {
    }


    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart_time() {
        return this.start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return this.end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
