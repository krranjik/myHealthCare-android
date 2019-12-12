package com.example.myhealthcare.controllers;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myhealthcare.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    View root;

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
        String month =month_date.format(calendar.getTime());

        TextView textViewDate = root.findViewById(R.id.view_date);
        textViewDate.setText(String.valueOf(date));

        TextView textViewMonth = root.findViewById(R.id.view_month);
        textViewMonth.setText(month);

        return root;
    }

}
