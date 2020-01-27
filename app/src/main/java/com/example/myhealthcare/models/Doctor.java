package com.example.myhealthcare.models;

public class Doctor {

    private String name, department, phone, description, location, rating;

    public Doctor(String name, String department, String phone, String description, String location, String rating) {
        this.name = name;
        this.department = department;
        this.phone = phone;
        this.description = description;
        this.location = location;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getRating() {
        return rating;
    }
}
