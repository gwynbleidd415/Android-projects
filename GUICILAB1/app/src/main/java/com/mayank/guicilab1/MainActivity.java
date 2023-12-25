package com.mayank.guicilab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int clr = 0, fnt = 24;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t1 = (TextView)findViewById(R.id.textView);
        Button bSize = (Button)findViewById(R.id.bSize);
        Button bColor = (Button)findViewById(R.id.bColor);
        bSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fnt += 6;
                if(fnt==60)
                    fnt=24;
                t1.setTextSize(fnt);
            }
        });
        bColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clr = (++clr)%6;
                switch (clr){
                    case 0:
                        t1.setTextColor(Color.RED);
                        break;
                    case 1:
                        t1.setTextColor(Color.GREEN);
                        break;
                    case 2:
                        t1.setTextColor(Color.BLUE);
                        break;
                    case 3:
                        t1.setTextColor(Color.YELLOW);
                        break;
                    case 4:
                        t1.setTextColor(Color.MAGENTA);
                        break;
                    case 5:
                        t1.setTextColor(Color.CYAN);
                        break;
                }
            }
        });
    }
}