package com.android.myhealthcare.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myhealthcare.R;
import com.android.myhealthcare.models.Appointment;
import com.android.myhealthcare.models.User;

import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.MyHolder> {

    Context context;
    List<Appointment> appointmentList;

    public AppointmentAdapter(Context context, List<Appointment> appointmentList) {
        this.context = context;
        this.appointmentList = appointmentList;
    }

    @NonNull
    @Override
    public AppointmentAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_listing_layout, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentAdapter.MyHolder holder, int position) {
        final Appointment appointment = appointmentList.get(position);
        holder.docname.setText(appointment.getDoctor_id().getName());
        holder.appoint_date.setText(appointment.getAppoint_date());
        holder.appoint_time.setText(appointment.getAppoint_time());
        holder.status.setText(appointment.getStatus());

    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView docname, appoint_date, appoint_time;
        Button status;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            docname = itemView.findViewById(R.id.docname);
            appoint_date = itemView.findViewById(R.id.appdate);
            appoint_time = itemView.findViewById(R.id.apptime);
            status = itemView.findViewById(R.id.status);
        }
    }
}
