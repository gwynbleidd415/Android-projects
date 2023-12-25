package com.mayank.myalarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
//import android.os.Vibrator;
import android.widget.Toast;

public class SecondActivity extends BroadcastReceiver {
    static Ringtone ringtone;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm is Running!", Toast.LENGTH_LONG).show();
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();
    }
}