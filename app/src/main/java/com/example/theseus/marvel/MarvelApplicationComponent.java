package com.example.theseus.marvel;

import android.content.SharedPreferences;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by theseus on 12/4/17.
 */
@Component
public interface MarvelApplicationComponent {
    SharedPreferences getSharedPreferences();
    Retrofit getRetrofit();
}
