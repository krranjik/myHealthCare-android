package com.example.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myhealthcare.R;

public class Appointment extends AppCompatActivity {

    TextView title;
    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        title = findViewById(R.id.menu_title_holder);
        backbtn = findViewById(R.id.back);
        title.setText("Appointment");
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Appointment.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }
}
