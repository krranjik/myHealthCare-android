package com.example.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myhealthcare.R;
import com.example.myhealthcare.api.DoctorAPI;
import com.example.myhealthcare.helper.GetImage;
import com.example.myhealthcare.models.Doctor;

import de.hdodenhof.circleimageview.CircleImageView;

public class DoctorProfile extends AppCompatActivity {

    TextView name, department, phone, description, location, title;
    RatingBar rating;
    String id;
    CircleImageView imageView;
    ImageView backbtn;

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
        imageView = findViewById(R.id.doctor_img);

        title = findViewById(R.id.menu_title_holder);
        title.setText("Doctor Profile");

        backbtn = findViewById(R.id.back);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorProfile.this, Doctor.class));
            }
        });

        DoctorAPI doctorAPI = new DoctorAPI();
        id = getIntent().getStringExtra("id");
        System.out.println(id + " as");
        Doctor docDetail = doctorAPI.getDoctorDetails(id);

        name.setText(docDetail.getName());
        department.setText(docDetail.getDepartment());
        phone.setText(docDetail.getPhone());
        description.setText(docDetail.getDescription());
        location.setText(docDetail.getLocation());
        rating.setRating(Float.parseFloat(docDetail.getRating()));
        GetImage.setImage(docDetail.getImage(), imageView);
    }
}
