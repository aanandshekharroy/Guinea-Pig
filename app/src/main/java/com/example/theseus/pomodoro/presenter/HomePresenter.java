package com.example.theseus.pomodoro.presenter;

import com.example.theseus.pomodoro.model.CountdownEvent;
import com.example.theseus.pomodoro.model.Timer;
import com.example.theseus.pomodoro.model.TimerModel;
import com.example.theseus.pomodoro.view.HomeView;

/**
 * Created by theseus on 20/5/17.
 */

public class HomePresenter implements HomePresenterInterface {
    TimerModel timerModel;
    HomeView homeView;
    public HomePresenter(HomeView homeView){
        this.homeView=homeView;
        timerModel=new Timer();
    }


    @Override
    public void setupWorkTimer(HomeView homeView) {
        String text=timerModel.getWorkTimerText();
        homeView.setTimerText(text);
    }

    @Override
    public int startTimerClicked(String text) {
        timerModel.startCountdownTimer(text);
        return 0;
    }

    @Override
    public void updateTimerText(CountdownEvent event) {
        if(event.isEventFinished()){
            homeView.inflateRewardFragment();
        }else{

        }
    }

    @Override
    public void timerCompleted() {

    }

    @Override
    public void rewardsFragmentDismissed() {
        homeView.dismissRewardsFragment();
    }
}
