package com.example.aahaarapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelperAdolescentGirls extends SQLiteOpenHelper {

    private static final String DB_NAME = "AdolescentGirls";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "Adolescentgirls";
    private static final String name = "Name";
    private static final String dob = "Dob";
    private static final String yob = "Yob";
    private static final String Father = "Father";
    private static final String Mother = "Mother";
private static final String menstrual_cycle="menstrual_cycle";
    private static final String iron = "Iron";
    private static final String hemo = "Hemoglobin";
    private static final String service = "Service";
    private static final String height_unit = "Height_unit";
    private static final String height = "Height";
    private static final String weight = "Weight";



    private static final String mobileNo = "Mobile_No";
    public MyDBHelperAdolescentGirls(@Nullable Context context) {
        super(context,DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_reg = "CREATE TABLE " + TABLE_NAME + " ("
                + mobileNo + " TEXT PRIMARY KEY, "
                + name + "TEXT" + dob + "TEXT" + yob + "TEXT"
                + Father + " TEXT"+Mother+"TEXT"+menstrual_cycle+"Text" + iron+"Text"+hemo
                +"Text"+service+"Text"+height_unit+"Text"+height+"Text"+weight+"Text)";
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
        values.put(Father,father);
        values.put(Mother,mother);
        values.put(menstrual_cycle,"");
        values.put(iron,"");
        values.put(hemo,"");
        values.put(service,"");
        values.put(height_unit,"");
        values.put(height,"");
        values.put(weight,"");
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public void updateColumns(String id, String value1, String value2, String value3,String value4,String value5,String value6,String value7) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(menstrual_cycle, value1);
        values.put(iron, value2);
        values.put(hemo, value3);
        values.put(service, value4);
        values.put(height_unit, value5);
        values.put(height, value6);
        values.put(weight, value7);
        db.update(TABLE_NAME, values, mobileNo + " = ?", new String[]{id});
        db.close();
    }
}
