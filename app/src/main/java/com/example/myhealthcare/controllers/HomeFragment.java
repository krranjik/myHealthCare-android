package com.example.myhealthcare.controllers;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myhealthcare.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    View root;
    CardView cvPrescription, cvReport, cvDoctor, cvAppointment;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_home, container, false);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        String month = month_date.format(calendar.getTime());

        TextView textViewDate = root.findViewById(R.id.view_date);
        textViewDate.setText(String.valueOf(date));

        TextView textViewMonth = root.findViewById(R.id.view_month);
        textViewMonth.setText(month);

        cvPrescription = root.findViewById(R.id.cvprescription);
        cvReport = root.findViewById(R.id.cvReport);
        cvAppointment = root.findViewById(R.id.cvAppointment);
        cvDoctor = root.findViewById(R.id.cvDoctor);

        cvPrescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Prescription.class));
            }
        });

        cvReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Report.class));
            }
        });

        cvAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Appointment.class));
            }
        });

        cvDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Doctor.class));
            }
        });

        return root;
    }

}
