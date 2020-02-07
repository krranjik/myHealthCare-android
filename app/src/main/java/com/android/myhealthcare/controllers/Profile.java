package com.android.myhealthcare.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.myhealthcare.R;
import com.android.myhealthcare.api.UserAPI;
import com.android.myhealthcare.helper.GetImage;
import com.android.myhealthcare.helper.UserSession;
import com.android.myhealthcare.models.User;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile extends AppCompatActivity {

    TextView name, gender, address, email, dob, bloodgroup, weight, height, phone;
    TextView title;
    CircleImageView imageView;
    Button editprofile;
    UserAPI userAPI;
    UserSession userSession;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        title = findViewById(R.id.menu_title_holder);
        title.setText("Profile");

        name = findViewById(R.id.pname);
        gender = findViewById(R.id.pgender);
        address = findViewById(R.id.paddress);
        email = findViewById(R.id.pemail);
        dob = findViewById(R.id.pdob);
        bloodgroup = findViewById(R.id.pbloodgroup);
        weight = findViewById(R.id.pweight);
        height = findViewById(R.id.pheight);
        phone = findViewById(R.id.pphone);
        imageView = findViewById(R.id.profile_img);
        editprofile = findViewById(R.id.editprofile);
        userSession = new UserSession(this);
        id = userSession.getID();

        userAPI = new UserAPI();
        User user = userAPI.getPatientDetail(id);
        name.setText(user.getName());
        gender.setText(user.getGender());
        address.setText(user.getAddress());
        email.setText(user.getEmail());
        dob.setText(user.getDob());
        bloodgroup.setText(user.getBloodgroup());
        weight.setText(user.getWeight());
        height.setText(user.getHeight());
        phone.setText(user.getPhone());
        GetImage.setImage(user.getImage(), imageView);

        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditProfileFragment editProfileFragment = new EditProfileFragment();
                editProfileFragment.show(Profile.this.getSupportFragmentManager(), "123");
            }
        });
    }

}
