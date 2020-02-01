package com.example.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.myhealthcare.R;
import com.example.myhealthcare.api.DoctorAPI;
import com.example.myhealthcare.models.Doctor;

public class DoctorProfile extends AppCompatActivity {

    TextView name, department, phone, description, location;
    RatingBar rating;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);

        name = findViewById(R.id.name);
        department = findViewById(R.id.department);
        phone = findViewById(R.id.phone);
        description = findViewById(R.id.description);
        location = findViewById(R.id.location);
        rating = findViewById(R.id.rating);
        DoctorAPI doctorAPI = new DoctorAPI();
        id = getIntent().getStringExtra("id");
        System.out.println(id + " as");
        Doctor docDetail = doctorAPI.getDoctorDetails(id);

        name.setText(docDetail.getName());
        department.setText(docDetail.getDepartment());
        phone.setText(docDetail.getPhone());
        description.setText(docDetail.getDescription());
        location.setText(docDetail.getLocation());
//        System.out.println(docDetail.getRating());
        rating.setNumStars(Integer.parseInt("5"));
    }
}
