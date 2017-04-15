package com.example.theseus.marvel.components;

import android.content.SharedPreferences;

import com.example.theseus.marvel.MarvelApplicationComponentScope;
import com.example.theseus.marvel.modules.ContextModule;
import com.example.theseus.marvel.modules.MarvelAPIModule;
import com.example.theseus.marvel.modules.NetworkModule;
import com.example.theseus.marvel.modules.PicassoModule;
import com.example.theseus.marvel.modules.SharedPreferenceModule;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by theseus on 12/4/17.
 */
@MarvelApplicationComponentScope
@Component(modules = {SharedPreferenceModule.class,
        MarvelAPIModule.class,
        PicassoModule.class})
public interface MarvelApplicationComponent {
    SharedPreferences getSharedPreference();
    MarvelAPIModule getMarvelAPI();
    Picasso getPicasso();
}
