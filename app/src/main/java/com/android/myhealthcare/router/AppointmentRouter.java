package com.android.myhealthcare.router;

import com.android.myhealthcare.models.Appointment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AppointmentRouter {

    @GET("getappointmentbyid/{id}")
    Call<List<Appointment>> getAppointmentById(@Path("id") String id);


}
