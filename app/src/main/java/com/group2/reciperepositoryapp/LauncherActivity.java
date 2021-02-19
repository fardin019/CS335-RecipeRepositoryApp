


package com.group2.reciperepositoryapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class LauncherActivity extends AppCompatActivity {
   protected int SECONDS = 3;
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);


        // added codes
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 1000);
    }


    //
    private Runnable runnable = new Runnable() {
        public void run() {
            long currentMilliseconds = System.currentTimeMillis();
            SECONDS--;
            if (SECONDS > 0) {
                handler.postAtTime(this, currentMilliseconds);
                handler.postDelayed(runnable, 1000);
            } else {
                Intent it = new Intent(LauncherActivity.this, LoginActivity.class);
                startActivity(it);
                handler.removeCallbacks(runnable);
                finish();
            }
        }
    };

}
    
