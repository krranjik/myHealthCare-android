package com.android.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.myhealthcare.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Privacy extends AppCompatActivity {

    PDFView pdfPrivacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);

        pdfPrivacy = findViewById(R.id.privacypdf);

        pdfPrivacy.fromAsset("Privacy.pdf").load();
    }
}
