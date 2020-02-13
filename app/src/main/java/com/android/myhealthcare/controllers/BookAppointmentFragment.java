package com.android.myhealthcare.controllers;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.myhealthcare.R;
import com.android.myhealthcare.api.AppointmentAPI;
import com.android.myhealthcare.api.Strict;
import com.android.myhealthcare.helper.Notification;
import com.android.myhealthcare.helper.UserSession;
import com.android.myhealthcare.models.Appointment;
import com.android.myhealthcare.models.RequestAppointment;
import com.android.myhealthcare.models.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookAppointmentFragment extends DialogFragment {

    View view;
    DatePicker datePicker;
    TimePicker timePicker;
    Button bookbtn;
    String appointdate, appointtime;
    String doc_id,id;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        view = inflater.inflate(R.layout.fragment_book_appointment, null);

        datePicker = view.findViewById(R.id.datePicker);
        timePicker = view.findViewById(R.id.timePicker);
        bookbtn = view.findViewById(R.id.btnbookapp);

        UserSession userSession = new UserSession(getContext());
         id = userSession.getID();
        appointdate = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();
        appointtime = timePicker.getHour() + " " + timePicker.getMinute();

        Bundle bundle = getArguments();
         doc_id = bundle.getString("ID");

        bookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Strict.StrictMode();
                RequestAppointment requestAppointment = new RequestAppointment(appointdate, appointtime, doc_id, id);
                AppointmentAPI appointmentAPI = new AppointmentAPI();
                if (appointmentAPI.addAppointments(requestAppointment)) {
                    Toast.makeText(getContext(), "Appointment Booked", Toast.LENGTH_SHORT).show();
                    Notification.givenotification(getContext(), "Appointment Booked Successfully");
                    dismiss();
                } else {
                    Toast.makeText(getContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        builder.setView(view);
        return builder.create();
    }

}
