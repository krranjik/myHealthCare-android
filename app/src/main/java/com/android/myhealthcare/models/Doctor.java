package com.android.myhealthcare.models;

public class Doctor {

    private String _id, name, department, phone, description, location, rating, image;

    public Doctor(String _id, String name, String department, String phone, String description, String location, String rating, String image) {
        this._id = _id;
        this.name = name;
        this.department = department;
        this.phone = phone;
        this.description = description;
        this.location = location;
        this.rating = rating;
        this.image = image;
    }

    public String getId() {
        return _id;
    }

    public String getImage() {
        return image;
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
