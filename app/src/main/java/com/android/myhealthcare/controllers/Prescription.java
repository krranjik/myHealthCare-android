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
import com.android.myhealthcare.adapters.PrescriptionAdapter;
import com.android.myhealthcare.api.PrescriptionAPI;
import com.android.myhealthcare.helper.UserSession;

public class Prescription extends AppCompatActivity {

    RecyclerView rvPrescription;
    String id;
    UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);

        userSession = new UserSession(this);
        id = userSession.getID();

        rvPrescription = findViewById(R.id.rv_prescriptions);
        PrescriptionAPI prescriptionAPI = new PrescriptionAPI();
        PrescriptionAdapter prescriptionAdapter = new PrescriptionAdapter(this, prescriptionAPI.getPrescriptionDetail(id));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvPrescription.setAdapter(prescriptionAdapter);
        rvPrescription.setLayoutManager(layoutManager);
    }
}
