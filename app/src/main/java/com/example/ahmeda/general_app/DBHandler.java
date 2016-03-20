package com.example.ahmeda.general_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by AhmedA on 3/20/2016.
 */
public class DBHandler extends SQLiteOpenHelper {

    SQLiteDatabase moviesDB;

    public DBHandler(Context context) {
        super(context, "My_DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Movies (id integer primary key, dec varchar(255), name varchar(255))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertCol(ArrayList<String> values) {
        moviesDB = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("dec",values.get(0));
        row.put("name", values.get(1));
        moviesDB.insert("Movies", null, row);
    }

    public Cursor getCol(String name) {
        moviesDB = getReadableDatabase();
        String[] val = {"name", "dec"};
        String[] val2 = {name};
        return moviesDB.query("Movies",val,"name = ?", val2,null,null,null,null);
    }
}
