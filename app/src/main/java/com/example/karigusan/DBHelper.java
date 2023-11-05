package com.example.karigusan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ResortDB";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_FAVORITE_RESORTS = "favorite_resorts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_RESORT_NAME = "resort_name";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_FAVORITE_RESORTS +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_RESORT_NAME + " TEXT" +
                ")";
        try {
            db.execSQL(createTable);
        } catch (Exception e) {
            Log.e("DBHelper", "Error creating table: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITE_RESORTS);
            onCreate(db);
        } catch (Exception e) {
            Log.e("DBHelper", "Error upgrading database: " + e.getMessage());
        }
    }

    public void addFavoriteResort(String resortName) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_RESORT_NAME, resortName);
            db.insert(TABLE_FAVORITE_RESORTS, null, values);
            db.close();
        } catch (Exception e) {
            Log.e("DBHelper", "Error adding favorite resort: " + e.getMessage());
        }
    }

    public List<String> getAllFavoriteResorts() {
        List<String> favoriteResorts = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FAVORITE_RESORTS, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    int columnIndexResortName = cursor.getColumnIndex(COLUMN_RESORT_NAME);
                    if (columnIndexResortName != -1) {
                        favoriteResorts.add(cursor.getString(columnIndexResortName));
                    }
                }
                cursor.close();
            }
            db.close();
        } catch (Exception e) {
            Log.e("DBHelper", "Error getting all favorite resorts: " + e.getMessage());
        }
        return favoriteResorts;
    }
    public void removeFavoriteResort(String resortName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("favorite_resorts", "resort_name" + " = ?", new String[]{resortName});
        db.close();
    }
}
