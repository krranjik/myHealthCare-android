package com.android.myhealthcare.models;

public class Appointment {
    String _id, appoint_date, appoint_time, status;
    User patient_id;
    Doctor doctor_id;

    public Appointment(String _id, String appointment_date, String appointment_time, String status, User patient_id, Doctor doctor_id) {
        this._id = _id;
        this.appoint_date = appointment_date;
        this.appoint_time = appointment_time;
        this.status = status;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
    }

    public String get_id() {
        return _id;
    }

    public String getAppoint_date() {
        return appoint_date;
    }

    public String getAppoint_time() {
        return appoint_time;
    }

    public String getStatus() {
        return status;
    }

    public User getPatient_id() {
        return patient_id;
    }

    public Doctor getDoctor_id() {
        return doctor_id;
    }
}
