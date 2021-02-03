package com.group2.reciperepositoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class LauncherActivity extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                Intent intent = new Intent(LauncherActivity.this , HomeActivity.class);
                startActivity(intent);


            }
        },2000);
    }
}