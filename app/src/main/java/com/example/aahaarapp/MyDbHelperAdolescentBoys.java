package com.example.aahaarapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class MyDbHelperAdolescentBoys extends SQLiteOpenHelper {

    private static final String DB_NAME = "AdolescentBoys";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "Adolescentboys";
    private static final String name = "Name";
    private static final String dob = "Dob";
    private static final String yob = "Yob";
    private static final String father = "Father";
    private static final String mother = "Mother";

    private static final String mobileNo = "Mobile_No";
    private static final String Nutritional_Supplements = "NutritionalSupplements";
    private static final String Energy_Intake = "EnergyIntake";
    private static final String Protein_Intake = "ProteinIntake";
    private static final String Fat_Intake = "FatIntake";
    private static final String Food_Solids = "FoodSolids";
    private static final String Hemoglobin = "Hemoglobin";
    private static final String Health_Service = "HealthService";


    public MyDbHelperAdolescentBoys(@Nullable Context context) {
        super(context,DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_reg = "CREATE TABLE " + TABLE_NAME + " ("
                + mobileNo + " TEXT PRIMARY KEY, "
                + name + "TEXT" + dob + "TEXT" + yob + "TEXT"
                + father + " TEXT"+mother+"TEXT)";
        db.execSQL(query_reg);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void registeruser(String name1,String dob1,String yob1,String mobile1,String father,String mother)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(mobileNo, mobile1);
        values.put(name,name1 );
        values.put(dob,dob1);
        values.put(yob,yob1);
        values.put(father,father);
        values.put(mother,mother);
        values.put(Nutritional_Supplements,"");
        values.put(Energy_Intake,"");
        values.put(Protein_Intake,"");
        values.put(Fat_Intake,"");
        values.put(Food_Solids,"");
        values.put(Hemoglobin,"");
        values.put(Health_Service,"");

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public void updateColumns(String id, String value1, String value2, String value3,String value4,String value5,String value6,String value7) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Nutritional_Supplements, value1);
        values.put(Energy_Intake, value2);
        values.put(Protein_Intake, value3);
        values.put(Fat_Intake, value4);
        values.put(Food_Solids, value5);
        values.put(Hemoglobin, value6);
        values.put(Health_Service, value7);
        db.update(TABLE_NAME, values, mobileNo + " = ?", new String[]{id});
        db.close();
    }


}
