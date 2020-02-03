package com.android.myhealthcare.helper;

import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.android.myhealthcare.api.Retro;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GetImage {
    public static void setImage(String imageName, ImageView imageView) {
        try {
            String imageURI = Retro.IMG_URL + imageName;
            URL url = new URL(imageURI);
            imageView.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
