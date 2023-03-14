package com.demoqa.models;

public class Student {
    public String firstName;
    public String lastName;
    public String userEmail;
    public String gender;
    public String mobile;
    public String dateOfBirth;
    public String subjects;
    public String hobbies;
    public String picture;
    public String currentAddress;
    public String state;
    public String city;

    /** ---------------------- Constructor ------------------------ */
    public Student(
            String firstName,
            String lastName,
            String userEmail,
            String gender,
            String mobile,
            String dateOfBirth,
            String subjects,
            String hobbies,
            String picture,
            String currentAddress,
            String state,
            String city
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.gender = gender;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
        this.subjects = subjects;
        this.hobbies = hobbies;
        this.picture = picture;
        this.currentAddress = currentAddress;
        this.state = state;
        this.city = city;
    }
}
