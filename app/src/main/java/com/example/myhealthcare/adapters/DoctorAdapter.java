package com.example.myhealthcare.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhealthcare.R;
import com.example.myhealthcare.controllers.DoctorProfile;
import com.example.myhealthcare.models.Doctor;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.MyHolder> {

    Context context;
    List<Doctor> doctorList;

    public DoctorAdapter(Context context, List<Doctor> doctorList) {
        this.context = context;
        this.doctorList = doctorList;
    }

    @NonNull
    @Override
    public DoctorAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_listing_layout, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorAdapter.MyHolder holder, int position) {
        final Doctor doctor = doctorList.get(position);
        holder.name.setText(doctor.getName());
        holder.department.setText(doctor.getDepartment());
        System.out.println(doctor.getId());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DoctorProfile.class);
                intent.putExtra("id",doctor.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView name, department;
        CircleImageView doctor_img;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            department = itemView.findViewById(R.id.department);
            doctor_img = itemView.findViewById(R.id.doctor_img);
        }
    }
}
