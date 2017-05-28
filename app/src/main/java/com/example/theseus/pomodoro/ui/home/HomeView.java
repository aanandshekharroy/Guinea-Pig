package com.example.theseus.pomodoro.ui.home;

import com.example.theseus.pomodoro.ui.MvpView;

/**
 * Created by theseus on 20/5/17.
 */

public interface HomeView extends MvpView {
    void inflateRewardFragment();
    void setupTimer(int duration);
    void setButtonTag(String tag);
    String getButtonTag();
    void setTimerText(String text);

    void dismissRewardsFragment();
}
