package com.group2.reciperepositoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
         @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_launcher);
            Button startbtn = (Button) this.<View>findViewById(R.id.start_buttonid);
           startbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openLoginActivity();


                }
            });



        }



    public void openLoginActivity(){

        Intent intent = new Intent(this, LoginActivity.class);


        startActivity(intent);

    }
}
    
