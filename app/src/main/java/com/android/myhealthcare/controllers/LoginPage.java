package com.android.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.myhealthcare.R;
import com.android.myhealthcare.api.Strict;
import com.android.myhealthcare.api.UserAPI;
import com.android.myhealthcare.helper.EditTextValidation;
import com.android.myhealthcare.helper.UserSession;
import com.android.myhealthcare.models.User;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Objects;

public class LoginPage extends AppCompatActivity {
    TextInputLayout etUsername, etPassword;
    EditText username, password;
    private HashMap<String, TextInputLayout> errorMap;
    TextView createacc;
    Button btnlogin;
    String uusername, upassword;
    private UserSession userSession;

    SensorManager mSensorManager;
    private float mAccel;
    private float mAccelCurrent = SensorManager.GRAVITY_EARTH;
    private float mAccelLast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        createacc = findViewById(R.id.createacc);
        btnlogin = findViewById(R.id.btnlogin);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(mSensorManager).registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        mAccel = 10f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;

        userSession = new UserSession(this);
        if (userSession.isActive()) {
            startActivity(new Intent(LoginPage.this, Dashboard.class));
            finish();
        }

        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginPage.this, RegistrationPage.class));
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Strict.StrictMode();

                if (isSignInDetailsValid()) {
                    UserAPI userAPI = new UserAPI();
                    uusername = etUsername.getEditText().getText().toString();
                    upassword = etPassword.getEditText().getText().toString();
                    User user = new User(uusername, upassword);

                    if (userAPI.login(user)) {
                        userSession.startSession();
                        Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginPage.this, Dashboard.class));
                    } else {
                        Toast.makeText(LoginPage.this, "Invalid username or password !", Toast.LENGTH_SHORT).show();
                        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                        vibrator.vibrate(100);
                    }
                } else {
                    errorMap = new HashMap<>();
                    errorMap.put("username", etUsername);
                    errorMap.put("password", etPassword);
                }

            }
        });
    }

    private boolean isSignInDetailsValid() {

        if (EditTextValidation.isEmpty(etUsername) | EditTextValidation.isEmpty(etPassword)) {
            return false;
        }
        return true;
    }


    private final SensorEventListener mSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta;
            if (mAccel > 12) {
                Intent in = new Intent(LoginPage.this, RegistrationPage.class);
                startActivity(in);
                finish();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    @Override
    protected void onResume() {
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mSensorListener);
        super.onPause();
    }


}
