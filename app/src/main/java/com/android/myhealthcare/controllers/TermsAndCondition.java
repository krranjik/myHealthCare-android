package com.android.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.myhealthcare.R;
import com.github.barteksc.pdfviewer.PDFView;

public class TermsAndCondition extends AppCompatActivity {

    PDFView pdfTAC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_condition);

        pdfTAC = findViewById(R.id.tacpdf);

        pdfTAC.fromAsset("TAC.pdf").load();
    }
}
