package com.android.myhealthcare.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myhealthcare.R;
import com.android.myhealthcare.controllers.ReportView;
import com.android.myhealthcare.helper.GetImage;
import com.android.myhealthcare.models.Report;

import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.MyHolder> {

    Context context;
    List<Report> reportList;

    public ReportAdapter(Context context, List<Report> reportList) {
        this.context = context;
        this.reportList = reportList;
    }

    @NonNull
    @Override
    public ReportAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.report_listing_layout, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        final Report report = reportList.get(position);
        holder.name.setText(report.getReport_name());
        holder.publishdate.setText(report.getReport_date());
        holder.repbydoc.setText(report.getDoctor_id().getName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReportView reportView = new ReportView(report.getImage());
                reportView.show(((AppCompatActivity) context).getSupportFragmentManager(), "123");
            }
        });
    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        TextView name, publishdate, repbydoc;
        Button view;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.reportname);
            publishdate = itemView.findViewById(R.id.publishdate);
            repbydoc = itemView.findViewById(R.id.repbydoc);
            view = itemView.findViewById(R.id.viewreport);
        }
    }
}
