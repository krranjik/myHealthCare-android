package com.android.myhealthcare.api;

import com.android.myhealthcare.models.Prescription;
import com.android.myhealthcare.router.PrescriptionRouter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class PrescriptionAPI {

    PrescriptionRouter prescriptionRouter = Retro.getInstance().create(PrescriptionRouter.class);
    List<Prescription> prescriptionDetail = null;

    public List<Prescription> getPrescriptionDetail(String id) {
        Call<List<Prescription>> prescriptionCall = prescriptionRouter.getPrescriptionById(id);
        Strict.StrictMode();
        try {
            Response<List<Prescription>> response = prescriptionCall.execute();
            if (response.isSuccessful()) {
                prescriptionDetail = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prescriptionDetail;
    }
}
