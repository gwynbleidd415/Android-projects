package com.mayank.lmela;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class secondPage extends AppCompatActivity {
    TextView nameS, regNoS, deptS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);
        nameS = (TextView)findViewById(R.id.nameS);
        regNoS = (TextView)findViewById(R.id.regNoS);
        deptS = (TextView)findViewById(R.id.deptS);
        Intent sPage = getIntent();
        nameS.setText(sPage.getStringExtra("nameI"));
        regNoS.setText(sPage.getStringExtra("regNoI"));
        deptS.setText(sPage.getStringExtra("deptI"));
    }
}
