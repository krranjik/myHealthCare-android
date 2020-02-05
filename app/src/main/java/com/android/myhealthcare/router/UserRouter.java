package com.android.myhealthcare.router;

import com.android.myhealthcare.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserRouter {

    @POST("addpatient")
    Call<Void> register(@Body User user);

    @POST("patientlogin")   
    Call<User> login(@Body User user);

    @PUT("updatepatient/{id}")
    Call<Void> updatePatient(@Path("id") String id, @Body User user);

    @GET("findpatientbyid/{id}")
    Call<User> getPatientByid(@Path("id") String id);
}
