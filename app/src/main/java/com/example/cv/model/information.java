package com.example.cv.model;

public class information {
    String name,email,phone,city;
    String skills,hobbies,education,experience;
    int radioID;
    public information(){

    }
    public information(String name, String email, String phone, String city, int radioID) {
    this.city=city;
        this.email=email;
        this.phone=phone;
        this.city=city;
        this.radioID=radioID;
    }

    public information(String hobbies, String skills, String education, String experiences) {
        this.education=education;
        this.experience=experiences;
        this.hobbies=hobbies;
        this.skills=skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRadioID() {
        return radioID;
    }

    public void setRadioID(int radioID) {
        this.radioID = radioID;
    }
}
