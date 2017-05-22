package com.example.theseus.pomodoro.model;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.theseus.pomodoro.Constants;

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
        final long duration=intent.getLongExtra(Constants.COUNTDOWN_TIME,1000);
        final String type=intent.getStringExtra(Constants.TYPE);
        Timber.d("countdown duration: "+duration);
        CountDownTimer countDownTimer = new CountDownTimer(duration, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Timber.d("In service ticking");
                float time_spent=(duration-millisUntilFinished)/duration;
                EventBus.getDefault().post(new CountdownEvent(false,millisUntilFinished,time_spent));
            }

            @Override
            public void onFinish() {
                Log.d("Model","finished");
                EventBus.getDefault().post(new CountdownEvent(true,type));
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
