package com.android.myhealthcare.router;

import com.android.myhealthcare.models.Appointment;
import com.android.myhealthcare.models.RequestAppointment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AppointmentRouter {

    @POST("addappointment")
    Call<Void> addAppointment(@Body RequestAppointment appointment);

    @GET("getappointmentbyid/{id}")
    Call<List<Appointment>> getAppointmentById(@Path("id") String id);


}
