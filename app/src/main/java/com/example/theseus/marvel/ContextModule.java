package com.example.theseus.marvel;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by theseus on 12/4/17.
 */
@Module
public class ContextModule {
    Context mContext;
    public ContextModule(Context context){
        mContext=context;
    }
    @Provides
    public Context getContext(){
        return mContext;
    }
}
