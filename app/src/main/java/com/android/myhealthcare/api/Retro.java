package com.android.myhealthcare.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retro {

    //for testing
//    private static final String BASE_URL
//            = "http://192.168.100.76:4444/";
//    public static final String IMG_URL
//            = "http://192.168.100.76:4444/public/";

    private static final String BASE_URL
            = "http://10.0.2.2:4444/";
    public static final String IMG_URL
            = "http://10.0.2.2:4444/public/";

    public static Retrofit getInstance() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}