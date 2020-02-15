package com.android.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.myhealthcare.R;
import com.android.myhealthcare.adapters.DoctorAdapter;
import com.android.myhealthcare.api.DoctorAPI;
import com.android.myhealthcare.api.Strict;

public class Doctor extends AppCompatActivity {

    RecyclerView rvDoctors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        Strict.StrictMode();
        rvDoctors = findViewById(R.id.rv_doctors);
        DoctorAPI doctorAPI = new DoctorAPI();
        DoctorAdapter doctorAdapter = new DoctorAdapter(this, doctorAPI.getAllDoctors());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvDoctors.setLayoutManager(layoutManager);
        rvDoctors.setAdapter(doctorAdapter);
    }
}
