package com.example.contactdatabaseapp;

public class ContactModel {
    private String name;
    private String dob;
    private String email;
    private String imagePath;  // Đường dẫn hình ảnh

    public ContactModel(String name, String dob, String email, String imagePath) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
