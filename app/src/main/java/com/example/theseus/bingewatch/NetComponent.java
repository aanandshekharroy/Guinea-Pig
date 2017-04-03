package com.example.theseus.bingewatch;

import com.example.theseus.bingewatch.activities.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by theseus on 3/4/17.
 */
@Singleton
@Component(modules = {AppModule.class,NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);
}
