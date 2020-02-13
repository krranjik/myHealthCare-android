package com.android.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.myhealthcare.R;
import com.android.myhealthcare.api.Strict;
import com.android.myhealthcare.api.UserAPI;
import com.android.myhealthcare.models.User;

public class RegistrationPage extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    EditText name, email, username, password, repassword;
    RadioGroup gender;
    Button registerButton;
    String uname, uemail, uusername, upassword, ugender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        name = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        gender = findViewById(R.id.rggender);
        registerButton = findViewById(R.id.signup);
        gender.setOnCheckedChangeListener(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Strict.StrictMode();
                UserAPI userAPI = new UserAPI();
                uname = name.getText().toString();
                uemail = email.getText().toString();
                uusername = username.getText().toString();
                upassword = password.getText().toString();
                User user = new User(null, uname, uusername, upassword, uemail, "", "", ugender, "", "", "", "", "");
                if (userAPI.register(user)) {
                    Toast.makeText(RegistrationPage.this, "User has been registered", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegistrationPage.this, LoginPage.class));
                } else {
                    Toast.makeText(RegistrationPage.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rbmale:
                ugender = "Male";
                break;

            case R.id.rbfemale:
                ugender = "Female";
                break;

            case R.id.rbother:
                ugender = "Others";
                break;
        }
    }
}
