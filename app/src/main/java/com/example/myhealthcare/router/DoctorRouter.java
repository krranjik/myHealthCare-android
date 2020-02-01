package com.example.myhealthcare.router;

import com.example.myhealthcare.models.Doctor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DoctorRouter {

    @GET("getalldoctors")
    Call<List<Doctor>> getAllDoctors();

    @GET("getdoctorbyid/{id}")
    Call<Doctor> getDoctorById(@Path("id") String id);
}