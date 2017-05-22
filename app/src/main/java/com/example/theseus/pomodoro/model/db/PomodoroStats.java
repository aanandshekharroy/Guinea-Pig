package com.example.theseus.pomodoro.model.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by theseus on 22/5/17.
 */
@Table(name = "pomodoro_stats")
public class PomodoroStats extends Model {
    @Column(name = "start_time")
    String start_time;
    @Column(name = "end_time")
    String end_time;
    @Column(name = "score")
    int score;
    @Column(name = "completed")
    boolean completed;

    public PomodoroStats(String start_time, String end_time, int score, boolean completed) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.score = score;
        this.completed = completed;
    }
//    public int get
}
