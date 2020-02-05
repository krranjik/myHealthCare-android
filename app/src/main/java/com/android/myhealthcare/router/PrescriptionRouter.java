package com.android.myhealthcare.router;

import com.android.myhealthcare.models.Prescription;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PrescriptionRouter {

    @GET("getprescriptionbyid/{id}")
    Call<List<Prescription>> getPrescriptionById(@Path("id") String id);
}
