package com.example.lado.notes_sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lado on 13/3/18.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notesdata.db";
    public static final String TABLE_PRODUCTS = "notes";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_THEME = "theme";
    public static final String COLUMN_INPUT = "usersinput";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_THEME
                + " TEXT, " + COLUMN_INPUT + " TEXT" + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_PRODUCTS);
        onCreate(db);
    }

    public void AddUser(UserInput theme) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_THEME, theme.getTheme());
        contentValues.put(COLUMN_INPUT, theme.getUserinput());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, contentValues);
        db.close();
    }
    public void DeleteUser(String user, String passowrd) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_THEME + "=\"" + user + "\";");
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_INPUT + "=\"" + passowrd + "\";");
    }
    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1";

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if(cursor.getString(cursor.getColumnIndex("theme"))!= null) {
                dbString += cursor.getString(cursor.getColumnIndex("theme"));
                dbString += "\n";
            }
            cursor.moveToNext();
        }
        db.close();
        return dbString;
    }
}
