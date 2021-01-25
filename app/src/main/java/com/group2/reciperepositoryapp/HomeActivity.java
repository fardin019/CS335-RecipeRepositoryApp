package com.group2.reciperepositoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        String Name = intent.getStringExtra(LoginActivity.EXTRA_TEXT);
        TextView Welcome_Message = (TextView) findViewById(R.id.Welcome_Message);


       Welcome_Message.setText("Welcome "+Name);
    }









    }

