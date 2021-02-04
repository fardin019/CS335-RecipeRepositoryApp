package com.group2.reciperepositoryapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "recipe_database";
    private static final String USER_TABLE = "user_reg";
    private static final String RECIPE_TABLE = "recipe";
    private static final String CATEGORY_TABLE = "category";
    private static final String INGREDIENT_TABLE = "ingredient";
    private static final String RECIPE_INGREDIENT_TABLE = "recipe_ingredient";
    private static final String COMMENT_TABLE = "comment";




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


        db.execSQL("PRAGMA foreign_keys=ON;");
        db.execSQL(user_reg);
        db.execSQL(category);
        db.execSQL(ingredient);
        db.execSQL(recipe);
        db.execSQL(recipe_ingredient);
        db.execSQL(comment);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RECIPE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CATEGORY_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + INGREDIENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RECIPE_INGREDIENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + COMMENT_TABLE);
        onCreate(db);
    }

    //Guys use this class to put your CRUD methods for your use
    //Start here and below
    public void addQuantity(){};
    public void addIngredient(){};
    public void addRecipeName(){};
}
