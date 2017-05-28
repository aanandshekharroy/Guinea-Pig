package com.example.theseus.pomodoro.ui.rewards;

import com.example.theseus.pomodoro.ui.MvpPresenter;

/**
 * Created by theseus on 20/5/17.
 */

public interface RewardsPresenterInterface<V extends RewardsView> extends MvpPresenter<V> {
    void acceptRewards();
    void rejectRewards();
}
