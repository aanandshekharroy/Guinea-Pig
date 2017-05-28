package com.example.theseus.pomodoro.ui.rewards;

import com.example.theseus.pomodoro.model.DataManager;
import com.example.theseus.pomodoro.ui.BasePresenter;

/**
 * Created by theseus on 20/5/17.
 */

public class RewardsPresenter<V extends RewardsView>
        extends BasePresenter<V> implements RewardsPresenterInterface<V>{
    public RewardsPresenter(DataManager dataManager) {
        super(dataManager);
    }


//    public RewardsPresenter() {
//    }

    @Override
    public void acceptRewards() {
//        rewardsModel.storeRewards();
//        homePresenter.rewardsFragmentDismissed();
//        homePresenter.setupRestTimer();
    }

    @Override
    public void rejectRewards() {

//        homePresenter.rewardsFragmentDismissed();
    }
}
