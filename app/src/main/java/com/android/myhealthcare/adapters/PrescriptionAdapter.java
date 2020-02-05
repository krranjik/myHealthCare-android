package com.android.myhealthcare.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myhealthcare.R;
import com.android.myhealthcare.models.Prescription;

import java.util.List;

public class PrescriptionAdapter extends RecyclerView.Adapter<PrescriptionAdapter.MyHolder> {

    Context context;
    List<Prescription> prescriptionList;

    public PrescriptionAdapter(Context context, List<Prescription> prescriptionList) {
        this.context = context;
        this.prescriptionList = prescriptionList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_view_layout, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        final Prescription prescription = prescriptionList.get(position);
        holder.start_date.setText(prescription.getStart_date());
        holder.end_date.setText(prescription.getEnd_date());
        holder.medicine_name.setText(prescription.getMedicine_name());
        holder.morning_time.setText(prescription.getMorning_time());
        holder.day_time.setText(prescription.getDay_time());
        holder.night_time.setText(prescription.getNight_time());
    }

    @Override
    public int getItemCount() {
        return prescriptionList.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        TextView start_date, end_date, medicine_name, morning_time, day_time, night_time;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            start_date = itemView.findViewById(R.id.startdate);
            end_date = itemView.findViewById(R.id.stopdate);
            medicine_name = itemView.findViewById(R.id.medicinename);
            morning_time = itemView.findViewById(R.id.morntime);
            day_time = itemView.findViewById(R.id.daytime);
            night_time = itemView.findViewById(R.id.nighttime);
        }
    }
}
