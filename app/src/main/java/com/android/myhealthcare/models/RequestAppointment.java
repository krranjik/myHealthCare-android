package com.android.myhealthcare.models;

public class RequestAppointment {

    String appoint_date, appoint_time, doctor_id, patient_id;

    public RequestAppointment(String appoint_date, String appoint_time, String doctor_id, String patient_id) {
        this.appoint_date = appoint_date;
        this.appoint_time = appoint_time;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
    }

    public String getAppoint_date() {
        return appoint_date;
    }

    public String getAppoint_time() {
        return appoint_time;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public String getPatient_id() {
        return patient_id;
    }
}
