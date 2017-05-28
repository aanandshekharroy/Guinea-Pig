package com.example.theseus.pomodoro.model.prefs;

import android.content.SharedPreferences;

import com.example.theseus.pomodoro.Constants;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by theseus on 28/5/17.
 */
@Singleton
public class AppPreference implements PreferenceManager {
    private static final String PREF_POMODORO_DURATION="pomodoro_duration";
    private static final String PREF_REST_DURATION="rest_duration";
    SharedPreferences mPrefs;
    @Inject
    public AppPreference(SharedPreferences mPrefs) {
        this.mPrefs = mPrefs;
    }

    @Override
    public int getPomodoroDuration() {
        return mPrefs.getInt(PREF_POMODORO_DURATION, Constants.DEFAULT_POMODORO_DURATION);
    }

    @Override
    public int getRestDuration() {
        return mPrefs.getInt(PREF_REST_DURATION,Constants.DEFAULT_REST_DURATION);
    }

    @Override
    public void setPomodoroDuration(int duration) {
        /*
        To be implemented
        * */
    }

    @Override
    public void setRestDuration(int duration) {
        /*
        * To be implemented
        * */
    }
}
