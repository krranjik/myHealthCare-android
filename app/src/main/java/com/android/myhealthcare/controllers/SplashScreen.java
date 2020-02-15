package com.android.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.android.myhealthcare.R;

public class SplashScreen extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        imageView = findViewById(R.id.splashlogo);

        Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
        imageView.startAnimation(myAnimation);

        final Intent myIntent = new Intent(this, WelcomeScreen.class);

        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    ActivityOptions options =
                            ActivityOptions.makeCustomAnimation(SplashScreen.this, R.anim.fadein, R.anim.fadeout);
                    startActivity(myIntent, options.toBundle());
                    finish();
                }
            }
        };
        thread.start();
    }
}
