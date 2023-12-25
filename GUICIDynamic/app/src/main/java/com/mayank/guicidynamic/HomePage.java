package com.mayank.guicidynamic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    private Button buttonFont, buttonColor;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_home);
//        Toast.makeText(getApplicationContext(), String.valueOf(R.dimen.small_sp), Toast.LENGTH_SHORT).show();
        addListenerOnButtons();
    }
    private void addListenerOnButtons(){
        buttonFont=(Button)findViewById(R.id.changeFont);
        buttonColor=(Button)findViewById(R.id.changeColor);
        textView=(TextView)findViewById(R.id.textView);
        buttonFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getTextSize()==getResources().getDimension(R.dimen.small_sp))
                    textView.setTextSize(0, getResources().getDimension(R.dimen.medium_sp));
                else
                    textView.setTextSize(0, getResources().getDimension(R.dimen.small_sp));
            }
        });
        buttonColor.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getCurrentTextColor()==getResources().getColor(R.color.red))
                    textView.setTextColor(getResources().getColor(R.color.blue));
                else
                    textView.setTextColor(getResources().getColor(R.color.red));
            }
        }));
    }
}