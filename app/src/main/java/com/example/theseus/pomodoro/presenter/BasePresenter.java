package com.example.theseus.pomodoro.presenter;

import com.example.theseus.pomodoro.view.MvpView;

/**
 * Created by theseus on 27/5/17.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    V mvpView;
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
}
