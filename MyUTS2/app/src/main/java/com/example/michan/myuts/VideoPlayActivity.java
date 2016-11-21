package com.example.michan.myuts;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoPlayActivity extends AppCompatActivity
{
    TextView t_judul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Play Video");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        String judul = b.getString("judul");
        String nama = b.getString("nama");

        t_judul = (TextView) findViewById(R.id.judul);
        t_judul.setText(nama);

        VideoView video = (VideoView) findViewById(R.id.video);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/raw/"+judul);
        video.setVideoURI(uri);
        video.start();
    }

}