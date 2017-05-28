package com.example.theseus.pomodoro.model;
import com.example.theseus.pomodoro.Utilities;

/**
 * Created by theseus on 20/5/17.
 */

public class Timer implements TimerModel {
    public Timer(){
    }

/*
* this is where you will get the data fro shared prefs
* */
    @Override
    public String getWorkTimerText() {
        return "25:00";
    }

    @Override
    public String getTimerTextFromMilliseconds(long millisUntilFinished) {
        return Utilities.getTimeStringFromMilliseconds(millisUntilFinished);
    }

    @Override
    public int getRestDuration() {
//        int i=sharedPreferences.getInt("rest_duration",10);
//        Log.d("Timer:","i="+i);
        return 0;
    }
/*
* start the service, service sends out event bus notification
*
* */
    @Override
    public void startCountdownTimer(String duration) {
//        if(duration.equals("25:00")){
//
//            Intent countdownServiceIntent=new Intent(mContext,CountdownService.class);
//            countdownServiceIntent.putExtra(Constants.TYPE,Constants.WORK);
//            countdownServiceIntent.putExtra(Constants.COUNTDOWN_TIME,Utilities.getMillisecondsFromText(duration));
//            mContext.startService(countdownServiceIntent);
//
//        }else if(duration.equals("15:00")){
//            Intent countdownServiceIntent=new Intent(mContext,CountdownService.class);
//            Timber.d("service started");
//            countdownServiceIntent.putExtra(Constants.TYPE,Constants.REST);
//            countdownServiceIntent.putExtra(Constants.COUNTDOWN_TIME,Utilities.getMillisecondsFromText(duration));
//            mContext.startService(countdownServiceIntent);
//        }
    }

    @Override
    public String getRestTimerText() {
        return "15:00";
    }
}
