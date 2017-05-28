package com.example.theseus.pomodoro.dagger.components;

import android.content.Context;

import com.example.theseus.pomodoro.dagger.ApplicationContext;
import com.example.theseus.pomodoro.dagger.modules.ApplicationModule;
import com.example.theseus.pomodoro.model.AppDataManager;
import com.example.theseus.pomodoro.model.DataManager;
import com.example.theseus.pomodoro.model.Timer;
import com.example.theseus.pomodoro.model.db.DBOpenHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by theseus on 20/5/17.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(AppDataManager appDataManager);
    DataManager getDataManager();
    @ApplicationContext Context getContext();
}
