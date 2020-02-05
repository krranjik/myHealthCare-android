package com.android.myhealthcare.api;

import com.android.myhealthcare.models.Report;
import com.android.myhealthcare.router.ReportRouter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class ReportAPI {

    ReportRouter reportRouter = Retro.getInstance().create(ReportRouter.class);
    List<Report> reportDetail =null;

    public List<Report> getReportDetail(String id) {
        Call<List<Report>> reportCall = reportRouter.getReportById(id);
        Strict.StrictMode();
        try {
            Response<List<Report>> response = reportCall.execute();
            if (response.isSuccessful()) {
                reportDetail = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reportDetail;
    }

}
