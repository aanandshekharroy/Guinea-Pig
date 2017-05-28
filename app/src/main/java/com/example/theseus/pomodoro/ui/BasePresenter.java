package com.example.theseus.pomodoro.ui;

import com.example.theseus.pomodoro.model.DataManager;

import javax.inject.Inject;

/**
 * Created by theseus on 27/5/17.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private final DataManager mDataManager;
    V mvpView;
    @Inject
    public BasePresenter(DataManager dataManager){
        this.mDataManager=dataManager;
    }
    @Override
    public void onAttach(V view) {
        mvpView=view;
    }

    @Override
    public void onDetach() {
        mvpView=null;
    }

    public V getMvpView() {
        return mvpView;
    }
    public DataManager getDataManager(){
        return mDataManager;
    }

}
