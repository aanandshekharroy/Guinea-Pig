package com.example.theseus.pomodoro.dagger.modules;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.theseus.pomodoro.Constants;
import com.example.theseus.pomodoro.dagger.ApplicationContext;
import com.example.theseus.pomodoro.dagger.DatabaseInfo;
import com.example.theseus.pomodoro.dagger.scopes.ApplicationScope;
import com.example.theseus.pomodoro.model.AppDataManager;
import com.example.theseus.pomodoro.model.DataManager;
import com.example.theseus.pomodoro.model.db.AppDB;
import com.example.theseus.pomodoro.model.db.DBHelper;
import com.example.theseus.pomodoro.model.prefs.AppPreference;
import com.example.theseus.pomodoro.model.prefs.PreferenceHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by theseus on 20/5/17.
 */
@Module
public class ApplicationModule {
    private Application mContext;
    public ApplicationModule(Application context){
        mContext=context;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mContext;
    }
    @Provides
    @Singleton
    public PreferenceHelper getPreferenceManager(AppPreference appPreference){
        return appPreference;
    }

    @Provides
    @Singleton
    public DataManager getDataManager(AppDataManager appDataManager){
        return appDataManager;
    }
    @Provides
    public SharedPreferences getSharedPreferenece(){
        return PreferenceManager.getDefaultSharedPreferences(mContext);
    }
    @Provides
    @Singleton
    public DBHelper getDBHelper(AppDB appDB){
        return appDB;
    }
    @Provides
    @DatabaseInfo
    public String getDatabaseInfo(){
        return Constants.DB_NAME;
    }
}
