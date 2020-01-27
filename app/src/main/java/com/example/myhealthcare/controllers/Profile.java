package com.example.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myhealthcare.R;
import com.example.myhealthcare.api.UserAPI;

public class Profile extends AppCompatActivity {

    TextView name, gender, address, email, dob, bloodgroup, weight, height, phone;
    Button editprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.name);
        gender = findViewById(R.id.gender);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        dob = findViewById(R.id.dob);
        bloodgroup = findViewById(R.id.bloodgroup);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        phone = findViewById(R.id.phone);
        editprofile = findViewById(R.id.editprofile);

        name.setText(UserAPI.userDetail.getName());
        gender.setText(UserAPI.userDetail.getGender());
        address.setText(UserAPI.userDetail.getAddress());
        email.setText(UserAPI.userDetail.getEmail());
        dob.setText(UserAPI.userDetail.getDob());
        bloodgroup.setText(UserAPI.userDetail.getBloodgroup());
        weight.setText(UserAPI.userDetail.getWeight());
        height.setText(UserAPI.userDetail.getHeight());
        phone.setText(UserAPI.userDetail.getPhone());

        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, EditProfile.class));
            }
        });
    }
}
