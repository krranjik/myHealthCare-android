package com.android.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.myhealthcare.R;
import com.android.myhealthcare.adapters.DoctorAdapter;
import com.android.myhealthcare.api.DoctorAPI;

public class Doctor extends AppCompatActivity {

    TextView title;
    ImageView backbtn;
    RecyclerView rvDoctors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        rvDoctors = findViewById(R.id.rv_doctors);
        DoctorAPI doctorAPI = new DoctorAPI();
        DoctorAdapter doctorAdapter = new DoctorAdapter(this,doctorAPI.getAllDoctors());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvDoctors.setLayoutManager(layoutManager);
        rvDoctors.setAdapter(doctorAdapter);

        title = findViewById(R.id.menu_title_holder);
        backbtn = findViewById(R.id.back);
        title.setText("Doctor");
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Doctor.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }
}
