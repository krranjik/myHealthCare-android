package com.android.myhealthcare.models;

public class Report {
    String _id, report_name, report_date, image;
    User patient_id;
    Doctor doctor_id;

    public Report(String _id, String report_name, String report_date, String image, User patient_id, Doctor doctor_id) {
        this._id = _id;
        this.report_name = report_name;
        this.report_date = report_date;
        this.image = image;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
    }

    public String get_id() {
        return _id;
    }

    public String getReport_name() {
        return report_name;
    }

    public String getReport_date() {
        return report_date;
    }

    public String getImage() {
        return image;
    }

    public User getPatient_id() {
        return patient_id;
    }

    public Doctor getDoctor_id() {
        return doctor_id;
    }
}