package com.example.myhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {

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
        forgotpassword = findViewById(R.id.resetPw);
        createacc = findViewById(R.id.createacc);
        btnlogin = findViewById(R.id.btnlogin);

        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginPage.this, RegistrationPage.class);
                startActivity(myIntent);
            }
        });

//        btnlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(LoginPage.this, Dashboard.class);
//                startActivity(myIntent);
//            }
//        });
    }

}
