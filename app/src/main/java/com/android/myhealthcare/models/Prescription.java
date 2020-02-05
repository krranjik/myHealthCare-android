package com.android.myhealthcare.models;

public class Prescription {
    String start_date, end_date, morning_time, day_time, night_time, medicine_name;
    User patient_id;

    public Prescription(String start_date, String end_date, String morning_time, String day_time, String night_time, String medicine_name, User patient_id) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.morning_time = morning_time;
        this.day_time = day_time;
        this.night_time = night_time;
        this.medicine_name = medicine_name;
        this.patient_id = patient_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getMorning_time() {
        return morning_time;
    }

    public String getDay_time() {
        return day_time;
    }

    public String getNight_time() {
        return night_time;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public User getPatient_id() {
        return patient_id;
    }
}
