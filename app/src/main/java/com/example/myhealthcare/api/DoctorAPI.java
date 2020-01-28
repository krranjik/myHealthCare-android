package com.example.myhealthcare.api;

import com.example.myhealthcare.models.Doctor;
import com.example.myhealthcare.router.DoctorRouter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class DoctorAPI {

    DoctorRouter doctorRouter = Retro.getInstance().create(DoctorRouter.class);
    List<Doctor> doctorList1 = null;
    Doctor docDetail;

    public Doctor getDoctorDetails(String id) {
        Call<Doctor> doctorCall = doctorRouter.getDoctorById(id);
        Strict.StrictMode();
        try {
            Response<Doctor> response = doctorCall.execute();
            if (response.isSuccessful()) {
                docDetail = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return docDetail;
    }

    public List<Doctor> getAllDoctors() {
        Call<List<Doctor>> doctorList = doctorRouter.getAllDoctors();
        Strict.StrictMode();
        try {
            Response<List<Doctor>> response = doctorList.execute();
            if (response.isSuccessful()) {
                doctorList1 = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return doctorList1;
    }
}
