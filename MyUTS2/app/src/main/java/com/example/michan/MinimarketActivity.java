package com.example.michan;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.michan.koneksi.Database;
import com.example.michan.myuts.MapsActivity;
import com.example.michan.myuts.R;

public class MinimarketActivity extends AppCompatActivity
{
    ListView lv;
    ListAdapter adapter;
    SQLiteDatabase db;
    Cursor cursor;
    EditText et_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minimarket);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db = (new Database(this)).getWritableDatabase();
        lv = (ListView) findViewById(R.id.lv);
        et_db = (EditText) findViewById(R.id.et);

        try
        {
            cursor = db.rawQuery("SELECT * FROM minimarket", null);
            adapter = new SimpleCursorAdapter(this, R.layout.lv_cart,
                    cursor, new String[]
                    {"nama","img"}, new int[]{R.id.lvtextmin, R.id.lvimgmin});
            lv.setAdapter(adapter);
            lv.setTextFilterEnabled(true);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    detail(position);
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void search_db(View v)
    {
        String edit_db = et_db.getText().toString();
        if (!edit_db.equals(""))
        {
            try
            {
                cursor = db.rawQuery("SELECT * FROM minimarket WHERE nama LIKE ?", new String[]{"%" +edit_db+"%"});
                adapter = new SimpleCursorAdapter(this, R.layout.lv_cart, cursor, new String[]
                        {"nama","img"}, new int[]{R.id.lvtextmin,R.id.lvimgmin});
                if (adapter.getCount() == 0)
                {
                    Toast.makeText(this, "Tidak Ditemukan "+edit_db+"",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    lv.setAdapter(adapter);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try
            {
                cursor = db.rawQuery("SELECT * FROM minimarket", null);
                adapter = new SimpleCursorAdapter(this, R.layout.lv_cart, cursor, new String[]
                        {"nama","img"}, new int[]{R.id.lvtextmin,R.id.lvimgmin});
                lv.setAdapter(adapter);
                lv.setTextFilterEnabled(true);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void detail(int position)
    {
        String _id = "";
        String nama = "";
        Double lat = null;
        Double longi = null;

        if (cursor.moveToFirst())
        {
            cursor.moveToPosition(position);
            nama = cursor.getString(cursor.getColumnIndex("nama"));
            lat = Double.valueOf(cursor.getString(cursor.getColumnIndex("lat")));
            longi = Double.valueOf(cursor.getString(cursor.getColumnIndex("long")));
        }

        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("nama", nama);
        i.putExtra("lat", lat);
        i.putExtra("long",longi);
        startActivity(i);
    }

}
