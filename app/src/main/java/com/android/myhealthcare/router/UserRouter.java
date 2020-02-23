package com.android.myhealthcare.router;

import com.android.myhealthcare.models.User;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface UserRouter {

    @POST("addpatient")
    Call<Void> register(@Body User user);

    @POST("patientlogin")   
    Call<User> login(@Body User user);

    @Multipart
    @PUT("updatepatient/{id}")
    Call<Void> updatePatient(@Path("id") String id, @Part("name")RequestBody name,
                             @Part("address")RequestBody adddress,
                             @Part("dob")RequestBody dob,
                             @Part("bloodgroup")RequestBody bloodgroup,
                             @Part("weight")RequestBody weight,
                             @Part("height")RequestBody height,
                             @Part("phone")RequestBody phone,
                             @Part MultipartBody.Part img);

    @GET("findpatientbyid/{id}")
    Call<User> getPatientByid(@Path("id") String id);

    @PUT("updatepatient/{id}")
    Call<Void> updatepassword(@Path("id") String id,@Body User user);
}
