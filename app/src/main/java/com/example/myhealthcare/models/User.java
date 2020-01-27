package com.example.myhealthcare.models;

public class User {

    private String name, username, password, email, address, dob, gender, bloodgroup, weight, height, phone, patient_img;

    public User(String name, String username, String password, String email, String address, String dob, String gender, String bloodgroup, String weight, String height, String phone, String patient_img) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.bloodgroup = bloodgroup;
        this.weight = weight;
        this.height = height;
        this.phone = phone;
        this.patient_img = patient_img;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public String getPhone() {
        return phone;
    }

    public String getPatient_img() {
        return patient_img;
    }
}
