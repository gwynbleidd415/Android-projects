package com.mayank.lmela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class homePage extends AppCompatActivity {

    EditText nameI, regNoI;
    Button submitI;
    Spinner deptI;

    String[] depts = {"CSE","IT","ECE","EEE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        nameI = findViewById(R.id.nameI);
        regNoI = findViewById(R.id.regNoI);
        submitI = findViewById(R.id.submitI);
        deptI = findViewById(R.id.deptI);

        ArrayAdapter adapter = new ArrayAdapter(homePage.this, R.layout.support_simple_spinner_dropdown_item, depts);
        deptI.setAdapter(adapter);

        submitI.setOnClickListener(v -> {

            Intent sPage = new Intent(homePage.this, secondPage.class);
            sPage.putExtra("nameI", nameI.getText().toString());
            sPage.putExtra("regNoI", regNoI.getText().toString());
            sPage.putExtra("deptI",deptI.getSelectedItem().toString());
            startActivity(sPage);
        });
    }
}