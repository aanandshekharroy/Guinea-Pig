package com.example.theseus.pomodoro.presenter;

import com.example.theseus.pomodoro.view.RewardsView;

/**
 * Created by theseus on 20/5/17.
 */

public interface RewardsPresenterInterface<V extends RewardsView> extends MvpPresenter<V> {
    void acceptRewards();
    void rejectRewards();
}
