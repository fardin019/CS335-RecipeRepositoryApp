package com.group2.reciperepositoryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "recipe_database";
    private static final String USER_TABLE = "user_reg";
    private static final String RECIPE_TABLE = "recipe";
    private static final String CATEGORY_TABLE = "category";
    private static final String INGREDIENT_TABLE = "ingredient";
    private static final String RECIPE_INGREDIENT_TABLE = "recipe_ingredient";
    private static final String COMMENT_TABLE = "comment";
    private static final String MEDIA_TABLE = "media";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String user_reg = "CREATE TABLE " + USER_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "FirstName TEXT, MiddleName TEXT, LastName TEXT, Gender TEXT, Email TEXT, " +
                "Role TEXT, Username TEXT, Password TEXT)";

        String category = "CREATE TABLE " + CATEGORY_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " Name TEXT)";

        String ingredient = "CREATE TABLE " + INGREDIENT_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT)";

        String recipe = "CREATE TABLE " + RECIPE_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " Name TEXT, Description TEXT, Category_id INTEGER, User_id INTEGER, " +
                "FOREIGN KEY(Category_id) REFERENCES category(id), " +
                "FOREIGN KEY(User_id) REFERENCES user_reg(id))";

        String recipe_ingredient = "CREATE TABLE " + RECIPE_INGREDIENT_TABLE + " (" +
                "Recipe_id INTEGER, Ingredient_id INTEGER, Quantity INTEGER)";

        String comment = "CREATE TABLE " + COMMENT_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "User_id INTEGER, Recipe_id INTEGER, Content TEXT, Date TEXT," +
                " FOREIGN KEY(User_id) REFERENCES user_reg(id)," +
                " FOREIGN KEY(Recipe_id) REFERENCES recipe(id))";

        String media = "CREATE TABLE " + MEDIA_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Recipe_id INTEGER, media_files BLOB, FOREIGN KEY(Recipe_id) REFERENCES recipe(id))";


        db.execSQL("PRAGMA foreign_keys=ON;");
        db.execSQL(user_reg);
        db.execSQL(category);
        db.execSQL(ingredient);
        db.execSQL(recipe);
        db.execSQL(recipe_ingredient);
        db.execSQL(comment);
        db.execSQL(media);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RECIPE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CATEGORY_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + INGREDIENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RECIPE_INGREDIENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + COMMENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + MEDIA_TABLE);
        onCreate(db);
    }

    //Guys use this class to put your CRUD methods for your use
    //Start here and below
    public boolean addQuantity(String Quantity1, String Quantity2, String Quantity3, String Quantity4, String Quantity5, String Quantity6, String Quantity7) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        ArrayList IngredientID = getIngredientID();
        String IngredientId1 = (String) IngredientID.get(0), IngredientId2 = (String) IngredientID.get(1), IngredientId3 = (String) IngredientID.get(2), IngredientId4 = (String) IngredientID.get(3), IngredientId5 = (String) IngredientID.get(4), IngredientId6 = (String) IngredientID.get(5), IngredientId7 = (String) IngredientID.get(6);
        String RecipeID1 =getRecipeID();

        values.put("Quantity", Quantity1);
        values.put("Ingredient_id", IngredientId1);
        values.put("Recipe_id", RecipeID1);
        long result1 = db.insert("recipe_ingredient", null, values);

        values.put("Quantity", Quantity2);
        values.put("Ingredient_id", IngredientId2);
        values.put("Recipe_id", RecipeID1);
        long result2 = db.insert("recipe_ingredient", null, values);

        values.put("Quantity", Quantity3);
        values.put("Ingredient_id", IngredientId3);
        values.put("Recipe_id", RecipeID1);
        long result3 = db.insert("recipe_ingredient", null, values);

        values.put("Quantity", Quantity4);
        values.put("Ingredient_id", IngredientId4);
        values.put("Recipe_id", RecipeID1);
        long result4 = db.insert("recipe_ingredient", null, values);

        values.put("Quantity", Quantity5);
        values.put("Ingredient_id", IngredientId5);
        values.put("Recipe_id", RecipeID1);
        long result5 = db.insert("recipe_ingredient", null, values);

        values.put("Quantity", Quantity6);
        values.put("Ingredient_id", IngredientId6);
        values.put("Recipe_id", RecipeID1);
        long result6 = db.insert("recipe_ingredient", null, values);

        values.put("Quantity", Quantity7);
        values.put("Ingredient_id", IngredientId7);
        values.put("Recipe_id", RecipeID1);
        long result7 = db.insert("recipe_ingredient", null, values);

        db.close();

        if (result1 != -1 && result2 != -1 && result3 != -1 && result4 != -1 && result5 != -1 && result6 != -1 && result7 != -1)
            return true;
        else return false;
    }

    public ArrayList getIngredientID() {
        ArrayList list = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();

        String IngredientQuery = "SELECT Ingredient_id FROM INGREDIENT_TABLE WHERE Ingredient_id>= Count(Ingredient_id)-7 ;";

        Cursor cursor = db.rawQuery(IngredientQuery, null);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String ingredients = cursor.getString(cursor.getColumnIndex("Ingredient_id"));
                list.add(ingredients);
            }
        }
        cursor.close();
        db.close();

        return list;
    }
    public String getRecipeID() {
        SQLiteDatabase db = this.getReadableDatabase();
        String RecipeIDQuery = "SELECT Recipe_id FROM RECIPE_TABLE WHERE Recipe_id>= Count(Recipe_id)-1 ;";
        Cursor cursor = db.rawQuery(RecipeIDQuery, null);
        String RecipeID = cursor.getString(cursor.getColumnIndex("Recipe_id"));
        cursor.close();
        db.close();
        return RecipeID;
    }

    public boolean addIngredient(String Ingredient1, String Ingredient2, String Ingredient3, String Ingredient4, String Ingredient5, String Ingredient6, String Ingredient7) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            String RecipeID1 =getRecipeID();

            values.put("Name", Ingredient1);
            values.put("Recipe_id", RecipeID1);
            long result1 = db.insert("ingredient", null, values);

            values.put("Name", Ingredient2);
            values.put("Recipe_id", RecipeID1);
            long result2 = db.insert("ingredient", null, values);

            values.put("Name", Ingredient3);
            values.put("Recipe_id", RecipeID1);
            long result3 = db.insert("ingredient", null, values);

            values.put("Name", Ingredient4);
            values.put("Recipe_id", RecipeID1);
            long result4 = db.insert("ingredient", null, values);

            values.put("Name", Ingredient5);
            values.put("Recipe_id", RecipeID1);
            long result5 = db.insert("ingredient", null, values);

            values.put("Name", Ingredient6);
            values.put("Recipe_id", RecipeID1);
            long result6 = db.insert("ingredient", null, values);

            values.put("Name", Ingredient7);
            values.put("Recipe_id", RecipeID1);
            long result7 = db.insert("ingredient", null, values);

            db.close();

            if (result1 != -1 && result2 != -1 && result3 != -1 && result4 != -1 && result5 != -1 && result6 != -1 && result7 != -1)
                return true;
            else return false;
    }
    public boolean addRecipeName(String RecipeName){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", RecipeName);
        long result1 = db.insert("recipe", null, values);
        db.close();
        if (result1 != -1) return true;
        else return false;
    }

    public void savePhoto() throws IOException {
       /* SQLiteDatabase db = this.getWritableDatabase();
        FileInputStream fis = new FileInputStream("/storage/sdcard/demoImage.jpg");
        byte[] image = new byte[fis.available()];;
        fis.read(image);
        ContentValues values = new ContentValues();
        values.put("media_files", image);
         db.insert("media", null, values);
        fis.close();
        db.close();
*/
    }
    public boolean saveVideo(View Video1){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("media_files", String.valueOf(Video1));
        long result1 = db.insert("media", null, values);
        db.close();
        if (result1 != -1) return true;
        else return false;
    }

}


