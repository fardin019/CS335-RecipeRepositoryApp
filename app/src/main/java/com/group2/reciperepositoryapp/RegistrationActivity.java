package com.group2.reciperepositoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        EditText inputFirstname = findViewById(R.id.firstname);
        EditText inputMiddlename = findViewById(R.id.middlename);
        EditText inputLastname = findViewById(R.id.lastname);
        EditText inputUsername = findViewById(R.id.username);
        EditText inputEmail = findViewById(R.id.email);
        EditText inputPassword = findViewById(R.id.password);

        RadioButton male = findViewById(R.id.rdbMale);
        RadioButton female = findViewById(R.id.rdbFemale);

        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnLinkToLogin = findViewById(R.id.btnLinkToLoginScreen);

        DatabaseHelper db = new DatabaseHelper(this);


        inputUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.equals("")){
                    String username = inputUsername.getText().toString().trim();

                    if(db.checkUsername(username))
                        Toast.makeText(getApplicationContext(), "This Username has already been used!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = inputFirstname.getText().toString().trim();
                String middlename = inputMiddlename.getText().toString().trim();
                String lastname = inputLastname.getText().toString().trim();
                String username = inputUsername.getText().toString().trim();
                String role = "User";
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                String gender = (male.isChecked())?"M":(female.isChecked())?"F":"";

                if(!firstname.isEmpty() && !middlename.isEmpty() && !lastname.isEmpty() &&
                        !username.isEmpty() && !email.isEmpty() && !password.isEmpty()
                        && !gender.isEmpty()){
                    db.addUser(firstname, middlename, lastname, gender, email, username, role, password);
                }
                else Toast.makeText(getApplicationContext(), "Please fill all fields!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}