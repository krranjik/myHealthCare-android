package com.example.myhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    TextView forgotpassword, createacc;
    Button btnlogin;
    String usernametxt, passwordtxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        forgotpassword = findViewById(R.id.forgotPassword);
        createacc = findViewById(R.id.createacc);
        btnlogin = findViewById(R.id.btnlogin);

        forgotpassword.setOnClickListener(this);
        createacc.setOnClickListener(this);
        btnlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
