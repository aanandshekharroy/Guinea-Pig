package com.example.theseus.pomodoro.ui.home;

import com.example.theseus.pomodoro.model.CountdownEvent;
import com.example.theseus.pomodoro.ui.MvpPresenter;

/**
 * Created by theseus on 20/5/17.
 */

public interface HomePresenterInterface<V extends HomeView> extends MvpPresenter<V> {
    void setupWorkTimer();
    void setupRestTimer();
    void startTimerClicked(String text);
    void updateTimerText(CountdownEvent event);
    void timerCompleted();
    void rewardsFragmentDismissed();

    void setupTimer();
}
