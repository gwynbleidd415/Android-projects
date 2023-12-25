package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.app.ActionBar;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class EventListener extends AppCompatActivity implements View.OnClickListener{
    private ImageView mImageView;
    private Button mBtnLeft;
    private Button mBtnRight;
    private Button mBtnCenter;
    private Button mBtnZoomIn;
    private Button mBtnZoomout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_listener);
        mImageView = (ImageView)findViewById(R.id.imageView);
        mBtnLeft = (Button)findViewById(R.id.btnLeft);
        mBtnRight = (Button)findViewById(R.id.btnRight);
        mBtnCenter = (Button)findViewById(R.id.btnCenter);
        mBtnZoomIn = (Button)findViewById(R.id.btnZoomIn);
        mBtnZoomout = (Button)findViewById(R.id.btnZoomOut);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventListener.this,"You have clicked the ImageView !",Toast.LENGTH_SHORT).show();
            }
        });
        mBtnCenter.setOnClickListener(this);
        mBtnLeft.setOnClickListener(this);
        mBtnRight.setOnClickListener(this);
        mBtnZoomIn.setOnClickListener(this);
        mBtnZoomout.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)mImageView.getLayoutParams();
        switch(v.getId()){
            case R.id.btnCenter:
                params.addRule(RelativeLayout.CENTER_HORIZONTAL);
                params.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                params.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);
                break;
            case R.id.btnLeft:
                params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                params.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                break;
            case R.id.btnRight:
                params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                params.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);
                break;
            case R.id.btnZoomIn:
                int height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics());
                int width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250, getResources().getDisplayMetrics());
                params.height= height;
                params.width = width;
                break;
            case R.id.btnZoomOut:
                int zoomoutHeight = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics());
                int zoomoutWidth = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 150, getResources().getDisplayMetrics());
                params.height= zoomoutHeight;
                params.width = zoomoutWidth;
                break;
        } mImageView.setLayoutParams(params);
    }
}