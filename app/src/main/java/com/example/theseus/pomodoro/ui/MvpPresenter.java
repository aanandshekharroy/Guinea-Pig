package com.example.theseus.pomodoro.ui;

import com.example.theseus.pomodoro.model.DataManager;

/**
 * Created by theseus on 27/5/17.
 */

public interface MvpPresenter<V extends MvpView>{
    void onAttach(V view);
    void onDetach();

}
