package com.miscdebris.eightfifteen;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by aaghevli on 6/30/13.
 */
public class SchedulerSetupReceiver extends BroadcastReceiver {

    private static final long EXEC_INTERVAL = 24 * 60 * 60 * 1000; // 1 day

    public void onReceive(Context context, Intent intent) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, SchedulerEventReceiver.class); // explicit
        PendingIntent intentExecuted = PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_CANCEL_CURRENT);
        long next815PM = getNext815PM();
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, next815PM, EXEC_INTERVAL, intentExecuted);
    }

    private long getNext815PM() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 20); // 8PM
        calendar.set(Calendar.MINUTE, 15);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        if (new Date(System.currentTimeMillis()).after(calendar.getTime())) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        return calendar.getTimeInMillis();
    }
}
