package com.example.theseus.pomodoro.view;

/**
 * Created by theseus on 20/5/17.
 */

public interface HomeView extends MvpView{
    void inflateRewardFragment();
    void setupTimer(int duration);
    void setButtonTag(String tag);
    String getButtonTag(String tag);
    void setTimerText(String text);

    void dismissRewardsFragment();
}
