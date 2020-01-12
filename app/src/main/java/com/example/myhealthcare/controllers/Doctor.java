package com.example.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myhealthcare.R;

public class Doctor extends AppCompatActivity {

    TextView title;
    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

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
