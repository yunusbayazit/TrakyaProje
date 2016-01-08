package com.example.yunus.trakyadosyapaylasim;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.yunus.trakyadosyapaylasim.Model.Auth;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);

        new CountDownTimer(5000,1000) {

            /** This method will be invoked on finishing or expiring the timer */
            @Override
            public void onFinish() {
                /** Creates an intent to start new activity */
                Intent intent = new Intent(getBaseContext(), LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                /** Creates a new activity, on finishing this timer */
                startActivity(intent);

                /** Close this activity screen */
                finish();
            }

            /** This method will be invoked in every 1000 milli seconds until
             * this timer is expired.Because we specified 1000 as tick time
             * while creating this CountDownTimer
             */
            @Override
            public void onTick(long millisUntilFinished) {
            }
        }.start();
    }
}
