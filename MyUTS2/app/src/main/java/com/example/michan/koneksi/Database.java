package com.example.michan.koneksi;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.michan.myuts.R;

/**
 * Created by Michan on 05/11/2016.
 */

public class Database extends SQLiteOpenHelper
{
    final static String DB_NAME = "db_myuts";

    public Database (Context context)
    {
        super (context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE IF NOT EXISTS minimarket(_id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT, lat TEXT, long TEXT, img BLOB)";
        db.execSQL(sql);

        ContentValues values = new ContentValues();

        values.put("_id","1");
        values.put("nama","Alfamart kramat1");
        values.put("lat","-6.862823");
        values.put("long","109.133937");
        values.put("img", R.mipmap.alfa1);
        db.insert("minimarket","_id", values);

        values.put("_id","2");
        values.put("nama","Alfamart kramat2");
        values.put("lat","-6.879248");
        values.put("long","109.186819");
        values.put("img", R.mipmap.alfa2);
        db.insert("minimarket","_id", values);

        values.put("_id","3");
        values.put("nama","Alfamart kramat3");
        values.put("lat","-6.896725");
        values.put("long","109.188167");
        values.put("img", R.mipmap.alfa3);
        db.insert("minimarket","_id", values);



        String sql2 = "CREATE TABLE IF NOT EXISTS music(_id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT, judul TEXT)";
        db.execSQL(sql2);

        ContentValues values2 = new ContentValues();
        values2.put("_id","1");
        values2.put("nama","01 Road of Resistance");
        values2.put("judul", R.raw.road);
        db.insert("music","_id", values2);

        values2.put("_id","2");
        values2.put("nama","02 KARATE");
        values2.put("judul", R.raw.karate);
        db.insert("music","_id", values2);

        values2.put("_id","3");
        values2.put("nama","03 Awadama Fever");
        values2.put("judul", R.raw.awadama);
        db.insert("music","_id", values2);

        values2.put("_id","4");
        values2.put("nama","04 YAVA!");
        values2.put("judul", R.raw.yava);
        db.insert("music","_id", values2);

        values2.put("_id","5");
        values2.put("nama","05 Amore");
        values2.put("judul", R.raw.amore);
        db.insert("music","_id", values2);

        String sql3 = "CREATE TABLE IF NOT EXISTS video(_id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT, judul TEXT)";
        db.execSQL(sql3);

        ContentValues values3 = new ContentValues();
        values3.put("_id","1");
        values3.put("nama","Real band");
        values3.put("judul", R.raw.real);
        db.insert("video","_id", values3);

        values3.put("_id","2");
        values3.put("nama","Ikmal");
        values3.put("judul", R.raw.ikmal);
        db.insert("video","_id", values3);

        values3.put("_id","3");
        values3.put("nama","Sprit");
        values3.put("judul", R.raw.sprit);
        db.insert("video","_id", values3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS minimarket");
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS music");
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS video");
        onCreate(db);
    }
}