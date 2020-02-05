package com.android.myhealthcare.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myhealthcare.R;
import com.android.myhealthcare.controllers.DoctorProfile;
import com.android.myhealthcare.helper.GetImage;
import com.android.myhealthcare.models.Doctor;

import java.util.List;

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
        holder.rating.setRating(Float.parseFloat(doctor.getRating()));
        GetImage.setImage(doctor.getImage(),holder.doctor_img);
        System.out.println(doctor.getId());
        holder.cvdoc.setOnClickListener(new View.OnClickListener() {
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
        RatingBar rating;
        ImageView doctor_img;
        CardView cvdoc;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            department = itemView.findViewById(R.id.department);
            rating=itemView.findViewById(R.id.ratingbar);
            doctor_img = itemView.findViewById(R.id.doctor_image);
            cvdoc=itemView.findViewById(R.id.cvdoc);
        }
    }
}
