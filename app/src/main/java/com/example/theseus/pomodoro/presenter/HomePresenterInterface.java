package com.example.theseus.pomodoro.presenter;

import com.example.theseus.pomodoro.model.CountdownEvent;
import com.example.theseus.pomodoro.view.HomeView;

/**
 * Created by theseus on 20/5/17.
 */

public interface HomePresenterInterface {
    void setupWorkTimer();
    void setupRestTimer();
    int startTimerClicked(String text);
    void updateTimerText(CountdownEvent event);
    void timerCompleted();
    void rewardsFragmentDismissed();
}
