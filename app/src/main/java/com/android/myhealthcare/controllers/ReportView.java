package com.android.myhealthcare.controllers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.android.myhealthcare.R;
import com.android.myhealthcare.api.Retro;
import com.android.myhealthcare.helper.UserSession;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class ReportView extends DialogFragment {

    UserSession userSession;
    String id;
    String img;

    public ReportView(String img) {
        this.img = img;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_report_view, null);

        ImageView reportholder = view.findViewById(R.id.reportholder);
        Picasso.get().load(Retro.IMG_URL+img).into(reportholder);

        builder.setView(view);
        return builder.create();
    }
}