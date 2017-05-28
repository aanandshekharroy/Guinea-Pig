package com.example.theseus.pomodoro.presenter;

import com.example.theseus.pomodoro.view.MvpView;

/**
 * Created by theseus on 27/5/17.
 */

public interface MvpPresenter<V extends MvpView>{
    void onAttach(V view);
    void onDetach();
}
