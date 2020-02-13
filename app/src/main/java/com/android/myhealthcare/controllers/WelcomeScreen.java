package com.android.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.myhealthcare.R;

public class WelcomeScreen extends AppCompatActivity implements View.OnClickListener {

    TextView getStarted, quote;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        quote = findViewById(R.id.quote);
        logo = findViewById(R.id.logo);
        getStarted = findViewById(R.id.getstarted);
        getStarted.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fadein));
        logo.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fadein));
        quote.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fadein));
        getStarted.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(WelcomeScreen.this, LoginPage.class);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
