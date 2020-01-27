package com.example.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myhealthcare.R;
import com.example.myhealthcare.api.UserAPI;
import com.example.myhealthcare.models.User;

public class LoginPage extends AppCompatActivity {

    EditText username, password;
    TextView forgotpassword, createacc;
    Button btnlogin;
    String uusername, upassword;


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
                startActivity(new Intent(LoginPage.this, RegistrationPage.class));
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserAPI userAPI = new UserAPI();
                uusername = username.getText().toString();
                upassword = password.getText().toString();
                User user = new User(uusername, upassword);

                if (userAPI.login(user)) {
                    Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginPage.this, Dashboard.class));
                } else {
                    Toast.makeText(LoginPage.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
