package com.android.myhealthcare.models;

public class Appointment {
    String _id, appointment_date, appointment_time;
    User patient_id;
    Doctor doctor_id;

    public Appointment(String _id, String appointment_date, String appointment_time, User patient_id, Doctor doctor_id) {
        this._id = _id;
        this.appointment_date = appointment_date;
        this.appointment_time = appointment_time;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
    }

    public String get_id() {
        return _id;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public User getPatient_id() {
        return patient_id;
    }

    public Doctor getDoctor_id() {
        return doctor_id;
    }
}
