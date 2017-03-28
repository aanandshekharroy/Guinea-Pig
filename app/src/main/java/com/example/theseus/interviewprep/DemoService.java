package com.example.theseus.interviewprep;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by theseus on 28/3/17.
 */

public class DemoService extends Service {
    private static final String LOG_TAG=DemoService.class.getSimpleName();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(LOG_TAG,"onBind");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG,"onStartCommand");
        Toast.makeText(this,"Asd",Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

}
