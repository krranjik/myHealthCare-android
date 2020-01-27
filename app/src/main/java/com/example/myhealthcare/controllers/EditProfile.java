package com.example.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myhealthcare.R;
import com.example.myhealthcare.api.UserAPI;
import com.example.myhealthcare.models.User;

public class EditProfile extends AppCompatActivity {

    EditText name, address, email, dob, bloodgroup, weight, height, phone;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        dob = findViewById(R.id.dob);
        bloodgroup = findViewById(R.id.bloodgroup);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        phone = findViewById(R.id.phone);
        save = findViewById(R.id.save);

        name.setText(UserAPI.userDetail.getName());
        address.setText(UserAPI.userDetail.getAddress());
        dob.setText(UserAPI.userDetail.getDob());
        bloodgroup.setText(UserAPI.userDetail.getBloodgroup());
        weight.setText(UserAPI.userDetail.getWeight());
        height.setText(UserAPI.userDetail.getHeight());
        phone.setText(UserAPI.userDetail.getPhone());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(name.getText().toString(),
                        address.getText().toString(),
                        dob.getText().toString(),
                        bloodgroup.getText().toString(),
                        weight.getText().toString(),
                        height.getText().toString(),
                        phone.getText().toString()
                );

                UserAPI userAPI = new UserAPI();
                if (userAPI.updatePatient(user)) {
                    Toast.makeText(EditProfile.this, "Update Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(EditProfile.this, Profile.class));
                } else {
                    Toast.makeText(EditProfile.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
