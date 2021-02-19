package com.group2.reciperepositoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.rentoz1.example.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button Login_Button = (Button) findViewById(R.id.Login_Button);
        Login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomepage();
            }
        });


    }


    public void openHomepage ( ) {
        EditText editTextName = (EditText) findViewById(R.id.editTextFirstName);
        String name = editTextName.getText().toString();
        EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        String password = editTextPassword.getText().toString();// Password stored as plaintext, we can encrypt them
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(EXTRA_TEXT, name);

        startActivity(intent);


    }
}







