package com.android.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.myhealthcare.R;
import com.android.myhealthcare.api.DoctorAPI;
import com.android.myhealthcare.api.Strict;
import com.android.myhealthcare.helper.GetImage;
import com.android.myhealthcare.models.Doctor;

import de.hdodenhof.circleimageview.CircleImageView;

public class DoctorProfile extends AppCompatActivity {

    TextView name, department, phone, description, location, title;
    RatingBar rating;
    String id;
    CircleImageView imageView;
    Button bookappoint;

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

        DoctorAPI doctorAPI = new DoctorAPI();
        id = getIntent().getStringExtra("id");
        System.out.println(id + " as");
        final Doctor docDetail = doctorAPI.getDoctorDetails(id);

        name.setText(docDetail.getName());
        department.setText(docDetail.getDepartment());
        phone.setText(docDetail.getPhone());
        description.setText(docDetail.getDescription());
        location.setText(docDetail.getLocation());
        rating.setRating(Float.parseFloat(docDetail.getRating()));
        GetImage.setImage(docDetail.getImage(), imageView);

        bookappoint = findViewById(R.id.bookappointment);
        bookappoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Strict.StrictMode();
                Bundle bundle = new Bundle();
                bundle.putString("ID",docDetail.getId());

                BookAppointmentFragment bookAppointmentFragment = new BookAppointmentFragment();
                bookAppointmentFragment.setArguments(bundle);
                bookAppointmentFragment.show(DoctorProfile.this.getSupportFragmentManager(), "123");
            }
        });
    }
}
