package com.group2.reciperepositoryapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //search card view
        CardView search = (CardView) findViewById(R.id.searchcardview);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchActivity();
            }
        });


        // add recipe card view

        CardView addrecipe = (CardView) findViewById(R.id.addcardview);
        addrecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddRecipes();
            }
        });

        // view recipe card view

        CardView viewrecipe = (CardView) findViewById(R.id.viewrecipecardview);
        viewrecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewrecipeActivity();
            }
        });

        // view recipe card view

        CardView profile = (CardView) findViewById(R.id.profilecardview);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileActivity();
            }
        });


        // about app card view

        CardView aboutapp = (CardView) findViewById(R.id.aboutappcardview);
        aboutapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutappActivity();
            }
        });

        // share app card view

        CardView shareapp = (CardView) findViewById(R.id.sharecardview);
        shareapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShareActivity();
            }
        });


        // share app card view

        CardView settings = (CardView) findViewById(R.id.settingscardview);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsActivity();
            }
        });
        // exit card view
        CardView exit = (CardView) findViewById(R.id.exitcardview);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });


    }

    //open search activity method

    public void openSearchActivity() {

        Intent intent = new Intent(this, SearchActivity.class);


        startActivity(intent);

    }

    // open add recipe method

    public void openAddRecipes() {

        Intent intent = new Intent(this, AddRecipes.class);


        startActivity(intent);

    }

    // open view recipe activity
    public void openViewrecipeActivity() {

        Intent intent = new Intent(this, ViewrecipeActivity.class);


        startActivity(intent);

    }

    // open view profile activity
    public void openProfileActivity() {

        Intent intent = new Intent(this, ProfileActivity.class);


        startActivity(intent);

    }

    // open about app activity method
    public void openAboutappActivity() {

        Intent intent = new Intent(this, AboutappActivity.class);


        startActivity(intent);

    }

    // open share app activity method
    public void openShareActivity() {

        Intent intent = new Intent(this, ShareActivity.class);


        startActivity(intent);

    }


    // open share app activity method
    public void openSettingsActivity() {

        Intent intent = new Intent(this, SettingsActivity.class);


        startActivity(intent);

    }
}