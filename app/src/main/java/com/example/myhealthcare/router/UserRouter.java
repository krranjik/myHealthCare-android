package com.example.myhealthcare.router;

import com.example.myhealthcare.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserRouter {

    @POST("registerpatient")
    Call<Void> register(@Body User user);
}
