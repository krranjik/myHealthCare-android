package com.android.myhealthcare.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.MyHolder> {
    @NonNull
    @Override
    public AppointmentAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentAdapter.MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView appointment_date, appointment_time;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
