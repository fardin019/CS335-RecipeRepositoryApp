package com.group2.reciperepositoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        DatabaseHelper db = new DatabaseHelper(this);

        EditText inputCategory = findViewById(R.id.category);

        Button addCat = findViewById(R.id.btnRegister);

        addCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = inputCategory.getText().toString().trim();


                if(!category.isEmpty()) db.addCategory(category);
                else Toast.makeText(getApplicationContext(), "Please fill the category field!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}