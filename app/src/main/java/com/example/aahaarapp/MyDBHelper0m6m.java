package com.example.aahaarapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper0m6m extends SQLiteOpenHelper {
    private static final String DB_NAME = "Children0m6m";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME_Lac = "children0m6m";
    private static final String Name = "name";
    private static final String Mother = "mother";
    private static final String Mobile_number = "mobileNo";
    private static final String Weight = "weight";
    private static final String Height_unit = "heightunit";
    private static final String Height = "height";
    private static final String Nutritional = "nutritional";
    private static final String Energy = "energy";
    private static final String Protein= "protein";
    private static final String Fat = "fats";
    private static final String Food_Solid = "food";
    private static final String Hemoglobin = "hemoglobin";
    private static final String Health_Service = "healthService";





    public MyDBHelper0m6m(@Nullable Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_lac = "CREATE TABLE " + TABLE_NAME_Lac + " ("
                + Mobile_number + " TEXT PRIMARY KEY , "
                + Name + " TEXT , "
                + Mother + " TEXT ,"
                + Weight + " TEXT , "
                + Height_unit + " TEXT , "
                + Height + " TEXT , "
                + Nutritional + " TEXT , "
                + Energy + " TEXT , "
                + Protein + " TEXT , "
                + Fat + " TEXT , "
                + Food_Solid + " TEXT , "
                + Hemoglobin + " TEXT , "
                + Health_Service + " TEXT ) ";

        db.execSQL(query_lac);
    }

    public void children0M6MRegister(String name,String mother,String mobile,String weight, String height_unit,String height)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Mobile_number, mobile);
        values.put(Name, name);
        values.put(Mother, mother);
        values.put(Weight, weight);
        values.put(Height_unit, height_unit);
        values.put(Height, height);
        values.put(Nutritional,"");
        values.put(Energy,"");
        values.put(Protein,"");
        values.put(Fat,"");
        values.put(Food_Solid ,"");
        values.put(Hemoglobin ,"");

        db.insert(TABLE_NAME_Lac, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void updateColumns(String id, String value1, String value2, String value3,String value4,String value5,String value6) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Nutritional, value1);
        values.put(Energy, value2);
        values.put(Protein, value3);
        values.put(Fat, value4);
        values.put(Food_Solid, value5);
        values.put(Hemoglobin, value6);

        db.update(TABLE_NAME_Lac, values, Mobile_number + " = ?", new String[]{id});
        db.close();
    }

}
