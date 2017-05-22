package com.example.theseus.pomodoro.presenter;

import com.example.theseus.pomodoro.model.CountdownEvent;
import com.example.theseus.pomodoro.view.HomeView;

/**
 * Created by theseus on 20/5/17.
 */

public interface HomePresenterInterface {
    public void setupWorkTimer(HomeView homeView);
    public int startTimerClicked(String text);
    void updateTimerText(CountdownEvent event);
    public void timerCompleted();
    public void rewardsFragmentDismissed();
}
