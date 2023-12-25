package com.mayank.myalarmclock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ToggleButton btn;
    TimePicker tpk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        tpk = findViewById(R.id.timepicker);
    }

    public void OnToggleClicked(View view) {
        long time;

        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pending = PendingIntent.getBroadcast(this, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (((ToggleButton) view).isChecked()) {
            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.HOUR_OF_DAY, tpk.getCurrentHour());
            calendar.set(Calendar.MINUTE, tpk.getCurrentMinute());
            time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));

            if (System.currentTimeMillis() > time) {
                if (calendar.AM_PM == 0)
                    time = time + (1000 * 60 * 60 * 12);
                else
                    time = time + (1000 * 60 * 60 * 24);
            }
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pending);
            Toast.makeText(MainActivity.this, "ALARM ON", Toast.LENGTH_SHORT).show();
        }
        else {
            alarmManager.cancel(pending);
            if(SecondActivity.ringtone.isPlaying())
                SecondActivity.ringtone.stop();
            Toast.makeText(MainActivity.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
        }
    }
}