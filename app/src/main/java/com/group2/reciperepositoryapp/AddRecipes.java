package com.group2.reciperepositoryapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

import static java.util.Objects.*;


public class AddRecipes extends AppCompatActivity {
    DatabaseHelper dtb1 = new DatabaseHelper(this);
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrecipes);

        EditText addRecipetxt = (EditText) findViewById(R.id.editTextTextMultiLine);
        String RecipeName = addRecipetxt.getText().toString();//add recipe name

        EditText addIngredient1 = (EditText) findViewById(R.id.editTextTextPersonName);
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

        //Buttons
        Button btn1 = (Button) findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNewSheets();
            }
        });


        Button btn2 = (Button) findViewById(R.id.button);
        btn2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                dtb1.addRecipeName(RecipeName);
                dtb1.addIngredient(Ingredient1, Ingredient2, Ingredient3, Ingredient4, Ingredient5, Ingredient6, Ingredient7);
                dtb1.addQuantity(Quantity1, Quantity2, Quantity3, Quantity4, Quantity5, Quantity6, Quantity7);

            }
        });


        ImageButton btn3 = (ImageButton) findViewById(R.id.imageButton);
        btn3.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(AddRecipes.this);
                builder.setTitle("Add Photo!");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (options[item].equals("Take Photo")) {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                            startActivityForResult(intent, 1);
                        } else if (options[item].equals("Choose from Gallery")) {
                            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            startActivityForResult(intent, 2);
                        } else if (options[item].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            }
        });
        ImageButton btn4 = (ImageButton) findViewById(R.id.imageButton2);
        btn3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
               // dtb1.saveVideo(v);
            }
        });
    }

    private void getNewSheets() {
        Intent intent = new Intent(AddRecipes.this, AddRecipes.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : Objects.<File[]>requireNonNull(f.listFiles())) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    String path = Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";
                    dtb1.savePhoto(path);
                } finally {
                    System.out.println("Error Occurred");
                }
            }
            else if (requestCode == 2) {
                Uri selectedImage = data.getData();
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                BitMapToString(thumbnail);
                dtb1.savePhoto (temp);

            }

        }
    }

    public String BitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        temp = Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }
}
