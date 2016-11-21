package com.example.michan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.michan.myuts.R;

/**
 * Created by Michan on 05/11/2016.
 */

public class SplashActivity extends AppCompatActivity{
    public static final int SPLASH_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
      public void run() {
        Intent intent= new Intent(SplashActivity.this,MenuUtamaActivity.class);
        startActivity(intent);
        SplashActivity.this.finish();
    }
},SPLASH_TIME);




        }

}
