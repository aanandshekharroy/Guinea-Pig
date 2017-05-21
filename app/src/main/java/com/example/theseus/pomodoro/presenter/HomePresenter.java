package com.example.theseus.pomodoro.presenter;

import com.example.theseus.pomodoro.model.Timer;
import com.example.theseus.pomodoro.model.TimerModel;

/**
 * Created by theseus on 20/5/17.
 */

public class HomePresenter implements HomePresenterInterface {
    TimerModel timerModel;
    public HomePresenter(){
        timerModel=new Timer();
    }
    @Override
    public int startTimerClicked() {
        timerModel.getRestDuration();
        return 0;
    }

    @Override
    public void timerCompleted() {

    }

    @Override
    public void rewardsFragmentDismissed() {

    }
}
