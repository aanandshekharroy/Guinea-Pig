package com.example.theseus.pomodoro;

/**
 * Created by theseus on 22/5/17.
 */

public class Utilities {
    public static long getMillisecondsFromText(String time){
        if(time.equals("25:00")){
            return 10*1000;
        }else if(time.equals("15:00")){
            return 5*1000;
        }
        return 0;
    }
    public static String getTimeStringFromMilliseconds(long milliseconds){
        long seconds=milliseconds/1000;
        long minutes=seconds/60;
        String timerString=String.valueOf(minutes)+" mm "+String.valueOf(seconds%60)+" ss";
        return timerString;
    }
}
