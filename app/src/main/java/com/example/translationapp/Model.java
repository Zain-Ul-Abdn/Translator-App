package com.example.translationapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;

public class Model extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "Translation.db";
        private static final String TABLE_NAME = "translation_table";
        private static final String Col_1 = "ID";
        private static final String Col_2 = "Usertxt";
        private static final String Col_3 = "Translatedtxt";


    private static final int DATABASE_VERSION = 1;

    public Model(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME + "( " + Col_1 + "  INTEGER PRIMARY KEY AUTOINCREMENT, " + Col_2 + " Text, "+  Col_3 + " Text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABlE IF EXISTS " + TABLE_NAME);
    }

    public boolean Insert(String text, String translation){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Col_2,text);
        values.put(Col_3,translation);

        long result = db.insert(TABLE_NAME,null,values);

        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
}
