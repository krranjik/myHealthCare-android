package com.android.myhealthcare.api;

import com.android.myhealthcare.models.Appointment;
import com.android.myhealthcare.models.RequestAppointment;
import com.android.myhealthcare.router.AppointmentRouter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class AppointmentAPI {

    AppointmentRouter appointmentRouter = Retro.getInstance().create(AppointmentRouter.class);
    List<Appointment> appointmentDetail = null;
    private boolean checkadd = false;
    public static String id;

    public boolean addAppointments(RequestAppointment appointment) {

        Call<Void> callAppointment = appointmentRouter.addAppointment(appointment);

        try {
            Response<Void> regResponse = callAppointment.execute();
            if (regResponse.isSuccessful()) {
                checkadd = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return checkadd;
    }

    public List<Appointment> getAppointmentDetail(String id) {
        Call<List<Appointment>> appointmentCall = appointmentRouter.getAppointmentById(id);
        Strict.StrictMode();
        try {
            Response<List<Appointment>> response = appointmentCall.execute();
            if (response.isSuccessful()) {
                appointmentDetail = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appointmentDetail;
    }

}
