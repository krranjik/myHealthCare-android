package com.android.myhealthcare.router;

import com.android.myhealthcare.models.Report;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ReportRouter {

    @GET("getreportbyid/{id}")
    Call<List<Report>> getReportById(@Path("id") String id);

}
