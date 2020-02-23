package com.android.myhealthcare.controllers;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.myhealthcare.R;
import com.android.myhealthcare.helper.UserSession;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    View root;
    CardView cvProfile, cvLogout, cvAbout, cvTAC, cvPrivacy;
    UserSession userSession;


    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_settings, container, false);

        cvProfile = root.findViewById(R.id.cvProfile);
        userSession = new UserSession(getActivity());
        cvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Profile.class));
            }
        });

        cvLogout = root.findViewById(R.id.cvLogout);
        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSession.endSession();
                startActivity(new Intent(getActivity(), LoginPage.class));

            }
        });

        cvAbout = root.findViewById(R.id.cvAbout);
        cvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), About.class));
            }
        });

        cvTAC = root.findViewById(R.id.cvTAC);
        cvTAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), TermsAndCondition.class));
            }
        });

        cvPrivacy = root.findViewById(R.id.cvPrivacy);
        cvPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Privacy.class));
            }
        });

        return root;
    }
}
