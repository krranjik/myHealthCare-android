package com.android.myhealthcare.controllers;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.myhealthcare.R;
import com.android.myhealthcare.api.UserAPI;
import com.android.myhealthcare.helper.GetImage;
import com.android.myhealthcare.helper.Notification;
import com.android.myhealthcare.helper.UserSession;
import com.android.myhealthcare.models.User;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditProfile extends AppCompatActivity {

    EditText name, address, dob, bloodgroup, weight, height, phone;
    Button save;
    CircleImageView imageView;
    ImageView addimage;
    Uri imageUri;
    Bitmap bitmap;
    private static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        dob = findViewById(R.id.dob);
        bloodgroup = findViewById(R.id.bloodgroup);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        phone = findViewById(R.id.phone);
        save = findViewById(R.id.save);
        imageView = findViewById(R.id.profile_image);
        addimage = findViewById(R.id.addimage);
        addimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Opengallery();
            }
        });

        UserSession userSession = new UserSession(this);
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

                UserAPI userAPI = new UserAPI();
                if (userAPI.updatePatient(user)) {
                    Toast.makeText(EditProfile.this, "Update Successful", Toast.LENGTH_SHORT).show();
                    Notification.givenotification(EditProfile.this,"Profile Updated Successfully");
                    startActivity(new Intent(EditProfile.this, Profile.class));
                } else {
                    Toast.makeText(EditProfile.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Opengallery() {
        Intent gallery = new Intent();
        gallery.setType("image/*");
        gallery.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(gallery, "Choose Image"), PICK_IMAGE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            imageUri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    private void uploadImage(Bitmap bitmap) {
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//        byte[] bytes = stream.toByteArray();
//        try {
//
//            File file = new File(getCacheDir(), "image.jpeg");
//            file.createNewFile();
//            FileOutputStream fos = new FileOutputStream(file);
//            fos.write(bytes);
//            fos.flush();
//            fos.close();
//
//            RequestBody rb = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//            MultipartBody.Part body = MultipartBody.Part.createFormData("imageName", file.getName(), rb);
//
//            PostAPI heroAPI = RetrofitHelper.instance().create(PostAPI.class);
//            Call<String> imageModelCall = heroAPI.uploadImage(body);
//            imageModelCall.enqueue(new Callback<String>() {
//                @Override
//                public void onResponse(Call<String> call, Response<String> response) {
//                    Toast.makeText(UpdateProfile.this, response.body(), Toast.LENGTH_SHORT).show();
//                    updateimagename.setText(response.body());
//                }
//
//                @Override
//                public void onFailure(Call<String> call, Throwable t) {
//                    Toast.makeText(UpdateProfile.this, "Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            });
//
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//    }

}
