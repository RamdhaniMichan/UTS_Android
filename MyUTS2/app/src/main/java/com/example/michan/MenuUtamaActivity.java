package com.example.michan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.michan.myuts.R;

/**
 * Created by Michan on 05/11/2016.
 */

public class MenuUtamaActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton profil,minimarket,music,video,help;
    @Override
    protected  void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        profil = (ImageButton) findViewById(R.id.btnprofil);
        minimarket = (ImageButton) findViewById(R.id.btnmimimarket);
        music = (ImageButton) findViewById(R.id.btnmusic);
        video = (ImageButton) findViewById(R.id.btnvideo);
        help = (ImageButton) findViewById(R.id.btnhelp);

        profil.setOnClickListener(this);
        minimarket.setOnClickListener(this);
        music.setOnClickListener(this);
        video.setOnClickListener(this);
        help.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if (v == profil)
        {
            Intent i = new Intent (MenuUtamaActivity.this,ProfilActivity.class);
            startActivity(i);
        }
        if (v == minimarket)
        {
            Intent i = new Intent (MenuUtamaActivity.this,MinimarketActivity.class);
            startActivity(i);
        }
        if (v == music)
        {
            Intent i = new Intent (MenuUtamaActivity.this,MusicActivity.class);
            startActivity(i);
        }
        if (v == video)
        {
            Intent i = new Intent (MenuUtamaActivity.this,VideoActivity.class);
            startActivity(i);
        }
        if (v == help)
        {
            Intent i = new Intent (MenuUtamaActivity.this,HelpActivity.class);
            startActivity(i);
        }

    }

    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setMessage("Apa yakin ingin keluar aplikasi")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                    public void onClick (DialogInterface dialog, int id) {
                        MenuUtamaActivity.this.finish();
                    }
                })
                .setNegativeButton("NO", null)
                .show();
    }
}

