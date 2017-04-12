package com.example.theseus.marvel;

import android.content.SharedPreferences;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by theseus on 12/4/17.
 */
@Component(modules = {SharedPreferenceModule.class,ContextModule.class})
public interface MarvelApplicationComponent {
    SharedPreferences getSharedPreference();
}
