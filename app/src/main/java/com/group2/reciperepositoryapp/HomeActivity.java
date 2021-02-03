package com.group2.reciperepositoryapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);






        Intent intent = getIntent();
        String Name = intent.getStringExtra(LoginActivity.EXTRA_TEXT);
        TextView Welcome_Message = (TextView) findViewById(R.id.Welcome_Message);


       Welcome_Message.setText("Welcome "+Name);



       Toolbar toolbar = findViewById(R.id.toolbar);
     // setSupportActionBar(toolbar);
       drawer = findViewById(R.id.drawer_layout);
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this , drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
       // drawer.addDrawerListener(toggle);
       // toggle.syncState();

    }


    public void onBackPressed(){

    }









    }

