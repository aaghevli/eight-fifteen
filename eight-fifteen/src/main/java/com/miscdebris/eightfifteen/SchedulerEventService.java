package com.miscdebris.eightfifteen;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import java.util.Date;

/**
 * Created by aaghevli on 6/30/13.
 */
public class SchedulerEventService  extends Service {

    private MediaPlayer mediaPlayer = null;

    @Override
    public IBinder onBind(final Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, final int flags, final int startId) {
        Context context = getApplicationContext();
        mediaPlayer = MediaPlayer.create(context, R.raw.casio_alarm);
        mediaPlayer.start(); // no need to call prepare(); create() does that for you
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}