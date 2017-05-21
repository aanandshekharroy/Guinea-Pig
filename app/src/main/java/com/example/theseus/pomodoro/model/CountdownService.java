package com.example.theseus.pomodoro.model;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by theseus on 21/5/17.
 */

public class CountdownService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("Model","ticking");

            }

            @Override
            public void onFinish() {
                Log.d("Model","finished");
            }
        }.start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
