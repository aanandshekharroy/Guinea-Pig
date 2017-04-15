package com.example.theseus.marvel.modules;

import android.content.Context;

import com.example.theseus.marvel.MarvelApplicationComponentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by theseus on 12/4/17.
 */
@Module
public class ContextModule {
    public Context mContext;
    public ContextModule(Context context){
        mContext=context;
    }
    @Provides
    @MarvelApplicationComponentScope
    public Context getContext(){
        return mContext;
    }
}
