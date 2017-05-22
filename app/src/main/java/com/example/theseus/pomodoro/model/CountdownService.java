package com.example.theseus.pomodoro.model;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import timber.log.Timber;

/**
 * Created by theseus on 21/5/17.
 */

public class CountdownService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.d("service created");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Timber.d("service started");
        Toast.makeText(this,"Chuhuhu",Toast.LENGTH_SHORT).show();
        CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Timber.d("In service ticking");
                EventBus.getDefault().post(new CountdownEvent(false,millisUntilFinished));
            }

            @Override
            public void onFinish() {
                Log.d("Model","finished");
                EventBus.getDefault().post(new CountdownEvent(true,0));
            }
        }.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
