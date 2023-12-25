package com.mayank.multlithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    TextView tw1, tw2;
    Button bt1,bt2;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(R.id.button);
        bt2 = (Button) findViewById(R.id.button2);
        tw1 = (TextView) findViewById(R.id.evenTextView);
        tw2 = (TextView) findViewById(R.id.oddTextView);
        handler = new Handler();

        bt1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "Even Thread Started", Toast.LENGTH_SHORT).show();
                new Thread(new Runnable()
                {
                    @Override
                    public void run() {
                        try {
                            int evenCounter = 2;
                            while (evenCounter < 51) {
                                updateEvenTextView(evenCounter);
                                evenCounter += 2;
                                Thread.sleep(1000);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "Odd Thread Started", Toast.LENGTH_SHORT).show();
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        try {
                            int oddCounter = 1;
                            while (oddCounter < 51) {
                                updateOddTextView(oddCounter);
                                oddCounter += 2;
                                Thread.sleep(1000);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
    private synchronized void updateEvenTextView(final int counter){
        handler.post(new Runnable() {
            @Override
            public void run() {
                tw1.setText("Even Counter : "+counter);
            }
        });
    }
    private synchronized void updateOddTextView(final int counter){
        handler.post(new Runnable() {
            @Override
            public void run() {
                tw2.setText("Odd Counter : "+counter);
            }
        });
    }
}