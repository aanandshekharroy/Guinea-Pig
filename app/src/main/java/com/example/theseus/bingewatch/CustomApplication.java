package com.example.theseus.bingewatch;

import android.app.Application;

/**
 * Created by theseus on 3/4/17.
 */

public class CustomApplication extends Application {
    private NetComponent mNetComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent=DaggerNetComponent
                .builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .build();
    }
    public NetComponent getNetComponent(){
        return mNetComponent;
    }
}
