package com.android.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.myhealthcare.R;
import com.android.myhealthcare.api.UserAPI;
import com.android.myhealthcare.helper.EditTextValidation;
import com.android.myhealthcare.helper.UserSession;
import com.android.myhealthcare.models.User;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;

public class LoginPage extends AppCompatActivity {
    TextInputLayout etUsername, etPassword;
    EditText username, password;
    private HashMap<String, TextInputLayout> errorMap;
    TextView forgotpassword, createacc;
    Button btnlogin;
    String uusername, upassword;
    private UserSession userSession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        forgotpassword = findViewById(R.id.resetPw);
        createacc = findViewById(R.id.createacc);
        btnlogin = findViewById(R.id.btnlogin);

        userSession = new UserSession(this);
        if (userSession.isActive()) {
            startActivity(new Intent(LoginPage.this, Dashboard.class));
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

}
