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

import com.an.biometric.BiometricCallback;
import com.an.biometric.BiometricManager;
import com.android.myhealthcare.R;
import com.android.myhealthcare.helper.UserSession;

public class WelcomeScreen extends AppCompatActivity implements View.OnClickListener, BiometricCallback {

    TextView getStarted, quote;
    ImageView logo;
    private UserSession userSession;

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
        getStarted.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        userSession = new UserSession(this);
        if (userSession.isActive()) {
            new BiometricManager.BiometricBuilder(WelcomeScreen.this)
                    .setTitle("Fingerprint Authentication")
                    .setDescription("Use your fingerprint to access")
                    .setNegativeButtonText("Cancel")
                    .build()
                    .authenticate(WelcomeScreen.this);
        } else {
            Intent intent = new Intent(WelcomeScreen.this, LoginPage.class);
            startActivity(intent);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onSdkVersionNotSupported() {
        startActivity(new Intent(WelcomeScreen.this, LoginPage.class));
        finish();
    }

    @Override
    public void onBiometricAuthenticationNotSupported() {
        startActivity(new Intent(WelcomeScreen.this, LoginPage.class));
        finish();
    }

    @Override
    public void onBiometricAuthenticationNotAvailable() {
        startActivity(new Intent(WelcomeScreen.this, LoginPage.class));
        finish();
    }

    @Override
    public void onBiometricAuthenticationPermissionNotGranted() {

    }

    @Override
    public void onBiometricAuthenticationInternalError(String error) {

    }

    @Override
    public void onAuthenticationFailed() {

    }

    @Override
    public void onAuthenticationCancelled() {

    }

    @Override
    public void onAuthenticationSuccessful() {
        startActivity(new Intent(WelcomeScreen.this, Dashboard.class));
        finish();
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {

    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {

    }
}
