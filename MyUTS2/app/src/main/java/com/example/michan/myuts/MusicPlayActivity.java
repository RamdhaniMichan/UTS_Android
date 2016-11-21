package com.example.michan.myuts;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MusicPlayActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;
    private TextView t_judul;
    private MediaPlayer mp;
    private String nama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Play Music");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mp = new MediaPlayer();
        Bundle b = getIntent().getExtras();
        nama = b.getString("nama");

        btnPlay = (Button) findViewById(R.id.btnPLAY);
        btnPause = (Button) findViewById(R.id.btnPAUSE);
        btnStop = (Button) findViewById(R.id.btnSTOP);
        t_judul = (TextView) findViewById(R.id.judul);
        t_judul.setText(nama);



        stateAwal();

        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnStop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if (v == btnPlay)
        {
            play();
            btnPlay.setEnabled(false);
            btnPause.setEnabled(true);
            btnStop.setEnabled(true);
        }
        if (v == btnPause)
        {
            pause();
        }
        if (v == btnStop)
        {
            stop();
        }

    }

    /** State Awal / Pertama Dijalankan */
    public void stateAwal(){
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
    }

    /** Dijalankan Oleh Tombol Play */
    private void play() {
        /** Memanggil File MP3 " */
        Bundle b = getIntent().getExtras();

        String judul = b.getString("judul");

        mp = MediaPlayer.create(this, Uri.parse("android.resource://"+getPackageName()+"/raw/"+judul));

        try {
            mp.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** Menjalankan Audio */
        mp.start();

        /** Penanganan Ketika Suara Berakhir */
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    /** Dijalankan Oleh Tombol Pause */
    public void pause(){
        if(mp.isPlaying()){
            if(mp!=null){
                mp.pause();

            }
        } else {
            if(mp!=null){
                mp.start();

            }
        }
    }

    /** Dijalankan Oleh Tombol Stop */
    public void stop(){
        mp.stop();

        try{
            mp.prepare();
            mp.seekTo(0);
        }catch (Throwable t) {
            t.printStackTrace();
        }

        stateAwal();
    }
}
