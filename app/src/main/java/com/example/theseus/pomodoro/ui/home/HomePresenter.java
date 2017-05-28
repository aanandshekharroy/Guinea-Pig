package com.example.theseus.pomodoro.ui.home;

import com.example.theseus.pomodoro.Constants;
import com.example.theseus.pomodoro.model.CountdownEvent;
import com.example.theseus.pomodoro.model.DataManager;
import com.example.theseus.pomodoro.ui.BasePresenter;

import javax.inject.Inject;

/**
 * Created by theseus on 20/5/17.
 */

public class HomePresenter<V extends HomeView>
        extends BasePresenter<V>
        implements HomePresenterInterface<V> {

    @Inject
    public HomePresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void setupWorkTimer() {
        String text=getDataManager().getWorkDurationText();
        if(getMvpView()!=null){
            getMvpView().setTimerText(text);
        }
        return ;
    }

    @Override
    public void setupRestTimer() {
        String text=getDataManager().getRestDurationText();
        getMvpView().setTimerText(text);
//        timerModel.startCountdownTimer(text);
    }

    @Override
    public void startTimerClicked(String text) {
//        timerModel.startCountdownTimer(text);
        if(getDataManager().isTimerRunning()){
//            Show fragment to abandon current timer
        }else {

        }
    }

    @Override
    public void updateTimerText(CountdownEvent event) {
        if(event.isEventFinished()){
            if(event.getType().equals(Constants.REST)){
                setupWorkTimer();
            }else if(event.getType().equals(Constants.WORK)){
                getMvpView().inflateRewardFragment();
            }

        }else{
//            getMvpView().setTimerText(timerModel.getTimerTextFromMilliseconds(event.getMillisUntilFinished()));
        }
    }

    @Override
    public void timerCompleted() {

    }

    @Override
    public void rewardsFragmentDismissed() {
        getMvpView().dismissRewardsFragment();
    }

    @Override
    public void setupTimer() {
        boolean isTimerRunning=getDataManager().isTimerRunning();
        if(!isTimerRunning){
            if(getMvpView()!=null){
                setupWorkTimer();
            }
        }else{
//            Timer is running so setup according to environment
        }
    }
}
