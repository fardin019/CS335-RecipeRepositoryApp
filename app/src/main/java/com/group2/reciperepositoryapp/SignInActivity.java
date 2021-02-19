package com.group2.reciperepositoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        EditText inputUsername = findViewById(R.id.email);
        EditText inputPassword = findViewById(R.id.password);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnLinkToRegister = findViewById(R.id.btnLinkToRegisterScreen);

        DatabaseHelper db = new DatabaseHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String username = inputUsername.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                if (!username.isEmpty() && !password.isEmpty()) {
                    int where_to = db.authUser(username, password);
                    if(where_to == 1) {
                        Intent i = new Intent(getApplicationContext(), AdminHomeActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else if(where_to == 2){
                        Intent i = new Intent(getApplicationContext(), RegistrationActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else Toast.makeText(getApplicationContext(),"Something went wrong please try again!", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(),"Please enter your valid Username and Password!", Toast.LENGTH_LONG).show();
                }
            }

        });

        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        RegistrationActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}