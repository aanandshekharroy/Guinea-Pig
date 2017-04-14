package com.example.theseus.marvel.components;

import android.content.SharedPreferences;

import com.example.theseus.marvel.modules.ContextModule;
import com.example.theseus.marvel.modules.MarvelAPIModule;
import com.example.theseus.marvel.modules.SharedPreferenceModule;

import dagger.Component;

/**
 * Created by theseus on 12/4/17.
 */
@Component(modules = {SharedPreferenceModule.class,ContextModule.class})
public interface MarvelApplicationComponent {
    SharedPreferences getSharedPreference();
    MarvelAPIModule getMarvelAPI();
}
