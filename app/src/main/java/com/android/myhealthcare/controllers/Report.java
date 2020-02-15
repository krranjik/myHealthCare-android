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
import com.android.myhealthcare.adapters.ReportAdapter;
import com.android.myhealthcare.api.ReportAPI;
import com.android.myhealthcare.helper.UserSession;

public class Report extends AppCompatActivity {

    RecyclerView rvreport;
    UserSession userSession;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        userSession = new UserSession(this);
        id = userSession.getID();

        rvreport = findViewById(R.id.rv_report);
        ReportAPI reportAPI = new ReportAPI();
        ReportAdapter reportAdapter = new ReportAdapter(this, reportAPI.getReportDetail(id));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvreport.setLayoutManager(layoutManager);
        rvreport.setAdapter(reportAdapter);
    }
}
