package com.android.myhealthcare.controllers;


import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.myhealthcare.R;
import com.android.myhealthcare.api.Strict;
import com.android.myhealthcare.api.UserAPI;
import com.android.myhealthcare.helper.GetImage;
import com.android.myhealthcare.helper.Notification;
import com.android.myhealthcare.helper.UserSession;
import com.android.myhealthcare.models.User;

import java.io.File;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditProfileFragment extends DialogFragment {

    View view;
    EditText name, address, dob, bloodgroup, weight, height, phone;
    Button save;
    CircleImageView imageView;
    ImageView addimage;
    Uri imageUri;
    Bitmap bitmap;
    MultipartBody.Part image;
    private static final int PICK_IMAGE = 1;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.fragment_edit_profile, null);

        name = view.findViewById(R.id.name);
        address = view.findViewById(R.id.address);
        dob = view.findViewById(R.id.dob);
        bloodgroup = view.findViewById(R.id.bloodgroup);
        weight = view.findViewById(R.id.weight);
        height = view.findViewById(R.id.height);
        phone = view.findViewById(R.id.phone);
        save = view.findViewById(R.id.save);
        imageView = view.findViewById(R.id.profile_image);
        addimage = view.findViewById(R.id.addimage);
        addimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.
                                Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });

        UserSession userSession = new UserSession(getContext());
        String id = userSession.getID();

        UserAPI userAPI = new UserAPI();
        User user = userAPI.getPatientDetail(id);
        name.setText(user.getName());
        address.setText(user.getAddress());
        dob.setText(user.getDob());
        bloodgroup.setText(user.getBloodgroup());
        weight.setText(user.getWeight());
        height.setText(user.getHeight());
        phone.setText(user.getPhone());
        GetImage.setImage(user.getImage(), imageView);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(name.getText().toString(),
                        address.getText().toString(),
                        dob.getText().toString(),
                        bloodgroup.getText().toString(),
                        weight.getText().toString(),
                        height.getText().toString(),
                        phone.getText().toString()
                );
                Strict.StrictMode();
                UserAPI userAPI = new UserAPI();
                if (userAPI.updatePatient(user, image)) {
                    Toast.makeText(getContext(), "Update Successful", Toast.LENGTH_SHORT).show();
                    Notification.givenotification(getContext(), "Profile Updated Successfully");
                    startActivity(new Intent(getContext(), Profile.class));
                } else {
                    Toast.makeText(getContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setView(view);
        return builder.create();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
            askPermission();
        }
    }


    public void askPermission() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            getImgReady();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getImgReady();
            } else {
                Toast.makeText(getContext(), "No Permission", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void getImgReady() {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContext().getContentResolver().query(imageUri, filePathColumn, null, null, null);
        assert cursor != null;
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String imgPath = cursor.getString(columnIndex);
        System.out.println(imgPath);
        File file = new File(imgPath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
        image = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
    }


}