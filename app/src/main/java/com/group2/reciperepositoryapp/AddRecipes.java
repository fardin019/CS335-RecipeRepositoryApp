package com.group2.reciperepositoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.group2.reciperepositoryapp.DatabaseHelper;


public class AddRecipes extends AppCompatActivity {
    DatabaseHelper dtb1= new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrecipes);

        EditText addRecipetxt = (EditText) findViewById(R.id.editTextTextMultiLine);
        String RecipeName = addRecipetxt.getText().toString();//add recipe name

        EditText addIngredient1 = (EditText) findViewById(R.id.editTextTextPersonName6);
        String Ingredient1 = addIngredient1.getText().toString();//add ingredient no1

        EditText addIngredient2 = (EditText) findViewById(R.id.editTextTextPersonName3);
        String Ingredient2 = addIngredient2.getText().toString();//add ingredient no2

        EditText addIngredient3 = (EditText) findViewById(R.id.editTextTextPersonName7);
        String Ingredient3 = addIngredient3.getText().toString();//add ingredient no3

        EditText addIngredient4 = (EditText) findViewById(R.id.editTextTextPersonName8);
        String Ingredient4 = addIngredient4.getText().toString();//add ingredient no4

        EditText addIngredient5 = (EditText) findViewById(R.id.editTextTextPersonName9);
        String Ingredient5 = addIngredient5.getText().toString();//add ingredient no5

        EditText addIngredient6 = (EditText) findViewById(R.id.editTextTextPersonName10);
        String Ingredient6 = addIngredient6.getText().toString();//add ingredient no6

        EditText addIngredient7 = (EditText) findViewById(R.id.editTextTextPersonName11);
        String Ingredient7 = addIngredient7.getText().toString();//add ingredient no7

        EditText addQuantity1 = (EditText) findViewById(R.id.editTextTextPersonName2);
        String Quantity1 = addQuantity1.getText().toString();//add quantity for ingredient no1

        EditText addQuantity2 = (EditText) findViewById(R.id.editTextTextPersonName4);
        String Quantity2 = addQuantity2.getText().toString();//add quantity for ingredient no2

        EditText addQuantity3 = (EditText) findViewById(R.id.editTextTextPersonName5);
        String Quantity3 = addQuantity3.getText().toString();//add quantity for ingredient no3

        EditText addQuantity4 = (EditText) findViewById(R.id.editTextTextPersonName6);
        String Quantity4 = addQuantity4.getText().toString();//add quantity for ingredient no4

        EditText addQuantity5 = (EditText) findViewById(R.id.editTextTextPersonName12);
        String Quantity5 = addQuantity5.getText().toString();//add quantity for ingredient no5

        EditText addQuantity6 = (EditText) findViewById(R.id.editTextTextPersonName13);
        String Quantity6 = addQuantity6.getText().toString();//add quantity for ingredient no6

        EditText addQuantity7 = (EditText) findViewById(R.id.editTextTextPersonName14);
        String Quantity7 = addQuantity7.getText().toString();//add quantity for ingredient no7

        Button btn1 = (Button) findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getNewSheets();
            }
        });
        Button btn2= (Button) findViewById(R.id.button);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 dtb1.addQuantity(Quantity1,Quantity2,Quantity3,Quantity4,Quantity5,Quantity6,Quantity7);
                 dtb1.addIngredient();
                 dtb1.addRecipeName();
            }
        });
    }

    private void getNewSheets() {
        Intent intent = new Intent(this, AddRecipes.class);
    }


}
