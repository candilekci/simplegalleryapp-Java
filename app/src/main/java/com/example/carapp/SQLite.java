package com.example.carapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLite extends SQLiteOpenHelper {
    private static final int database_VERSION = 1;
    private static final String database_NAME = "AracDB";
    private static final String table_ARAC = "araclar";
    private static final String arac_MODEL = "aracModel";
    private static final String arac_ID = "id";
    private static final String arac_YIL = "aracYıl";
    private static final String arac_KM = "aracKM";
    private static final String arac_Fiyat = "aracFiyat";


    private static final String CREATE_ARAC_TABLE = "CREATE TABLE "
            + table_ARAC +" ("
            + arac_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            arac_MODEL+" TEXT, " +
            arac_YIL+" INTEGER, " +
            arac_KM+" INTEGER, " +
            arac_Fiyat+" INTEGER )";


    public SQLite(@Nullable Context context) {
        super(context, database_NAME, null, database_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_ARAC_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + table_ARAC);
        this.onCreate(sqLiteDatabase);
    }

    public void AracEkle(Arabalar arabalar) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues degerler = new ContentValues();
        degerler.put(arac_MODEL, arabalar.getAracModel());
        degerler.put(arac_YIL, arabalar.getAracYIL());
        degerler.put(arac_KM, arabalar.getAracKM());
        degerler.put(arac_Fiyat, arabalar.getAracFiyat());

        db.insert(table_ARAC,null,degerler);
        db.close();
    }

    public List<Arabalar> AracListele() {
        List<Arabalar> arabalars = new ArrayList<>();
        String query = "SELECT * FROM " + table_ARAC;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        Arabalar arabalar = null;

        if(cursor.moveToFirst()){
            do {
                arabalar = new Arabalar();
                arabalar.setId(Integer.parseInt(cursor.getString(0)));
                arabalar.setAracModel(cursor.getString(1));
                arabalar.setAracYIL(Integer.parseInt(cursor.getString(2)));
                arabalar.setAracKM(Integer.parseInt(cursor.getString(3)));
                arabalar.setAracFiyat(Integer.parseInt(cursor.getString(4)));


                arabalars.add(arabalar);
            }while(cursor.moveToNext());
        };
        return arabalars;
    };
}
