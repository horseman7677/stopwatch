package com.example.stopwatch;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;


public class MainActivity extends AppCompatActivity {
    private long pauseOffSet;
    private Chronometer chronometer;
    private boolean running;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        chronometer = findViewById(R.id.chronometer);

    }

    public void start(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffSet);
            chronometer.start();
            running = true;
        }
    }

    public void stop(View v) {
        if (running) {
            chronometer.stop();
            pauseOffSet = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }

    }

    public void reset(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffSet = 0;
    }

}