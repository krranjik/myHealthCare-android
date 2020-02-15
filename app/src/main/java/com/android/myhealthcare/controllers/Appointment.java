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
import com.android.myhealthcare.adapters.AppointmentAdapter;
import com.android.myhealthcare.api.AppointmentAPI;
import com.android.myhealthcare.helper.UserSession;

public class Appointment extends AppCompatActivity {

    RecyclerView rvAppoint;
    UserSession userSession;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        rvAppoint = findViewById(R.id.rv_appointment);
        userSession = new UserSession(this);
        id = userSession.getID();

        AppointmentAPI appointmentAPI = new AppointmentAPI();
        AppointmentAdapter appointmentAdapter = new AppointmentAdapter(this, appointmentAPI.getAppointmentDetail(id));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvAppoint.setLayoutManager(layoutManager);
        rvAppoint.setAdapter(appointmentAdapter);

    }
}
