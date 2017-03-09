package com.example.isidr.schoolsisidro.Control;

/*Created by Isidro on 28/11/2015*/

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite_Towns_and_schools extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Towns_and_Schools";
    private static final int DATABASE_VERSION = 2;

    String sqlCreateTowns =
            "CREATE TABLE Towns (" +
                    "Code INTEGER PRIMARY KEY, " +
                    "Name TEXT, " +
                    "Lat REAL, " +
                    "Lon REAL)";
    String sqlCreateSchools = "CREATE TABLE Schools (" +
            "Code INTEGER PRIMARY KEY, " +
            "Name TEXT, " +
            "Town INTEGER, " +
            "Kind_of_School TEXT, " +
            "Lat REAL, " +
            "Lon REAL, " +
            "FOREIGN KEY(Town) REFERENCES Town(Code))";

    public SQLite_Towns_and_schools (Context context) {
        super (context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreateTowns);
        db.execSQL(sqlCreateSchools);
    }

    // Called, if the database version is increased in your application code.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Schools");
        db.execSQL("DROP TABLE IF EXISTS Towns");
        db.execSQL(sqlCreateTowns);
        db.execSQL(sqlCreateSchools);
    }

}
