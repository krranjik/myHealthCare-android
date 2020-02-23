package com.android.myhealthcare.models;

public class User {

    private String _id, name, username, password, email, address, dob, gender, bloodgroup, weight, height, phone, image, token, id;

    public User(String _id, String name, String username, String password, String email, String address, String dob, String gender, String bloodgroup, String weight, String height, String phone, String image) {
        this._id = _id;
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
        this.image = image;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String password) {
        this.password = password;
    }

    public User(String name, String address, String dob, String bloodgroup, String weight, String height, String phone) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.bloodgroup = bloodgroup;
        this.weight = weight;
        this.height = height;
        this.phone = phone;
    }

    public String getId() {
        return _id;
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

    public String getImage() {
        return image;
    }

    public String get_id() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
