package com.android.myhealthcare.router;

import com.android.myhealthcare.models.Doctor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DoctorRouter {

    @GET("getalldoctor")
    Call<List<Doctor>> getAllDoctors();

    @GET("getdoctorbyids/{id}")
    Call<Doctor> getDoctorById(@Path("id") String id);
}