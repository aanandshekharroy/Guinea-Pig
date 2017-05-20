package com.example.theseus.pomodoro.dagger.modules;


import android.content.Context;

import com.example.theseus.pomodoro.dagger.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by theseus on 20/5/17.
 */
@Module
public class ContextModule {
    private Context mContext;
    ContextModule(Context context){
        mContext=context;
    }
    @Provides
    @ApplicationScope
    public Context getContext(){
        return mContext;
    };
}
