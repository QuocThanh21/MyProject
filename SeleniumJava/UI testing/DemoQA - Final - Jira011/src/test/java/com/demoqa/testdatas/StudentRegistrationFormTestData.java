package com.demoqa.testdatas;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.demoqa.utils.JsonUtil;

import java.io.FileNotFoundException;

public class StudentRegistrationFormTestData {
    private String firstName;
    private String lastName;
    private String userEmail;
    private String gender;
    private String mobile;
    private String dateOfBirth;
    private String[] subjects;
    private String[] hobbies;
    private String picture;
    private String currentAddress;
    private String state;
    private String city;

    /** ---------------------- Constructor ------------------------ */
    public StudentRegistrationFormTestData(String nameOfJsonFile) throws FileNotFoundException {
        StudentRegistrationFormTestData studentRegistrationFormTestData = covertJsonToObject(nameOfJsonFile);
        this.firstName = studentRegistrationFormTestData.getFirstName();
        this.lastName = studentRegistrationFormTestData.getLastName();
        this.userEmail = studentRegistrationFormTestData.getUserEmail();
        this.gender = studentRegistrationFormTestData.getGender();
        this.mobile = studentRegistrationFormTestData.getMobile();
        this.dateOfBirth = studentRegistrationFormTestData.getDateOfBirth();
        this.subjects = studentRegistrationFormTestData.getSubjects();
        this.hobbies = studentRegistrationFormTestData.getHobbies();
        this.picture = studentRegistrationFormTestData.getPicture();
        this.currentAddress = studentRegistrationFormTestData.getCurrentAddress();
        this.state = studentRegistrationFormTestData.getState();
        this.city = studentRegistrationFormTestData.getCity();
    }

    /** ---------------------- Methods ------------------------ */
    private StudentRegistrationFormTestData covertJsonToObject(String nameOfJsonFile) throws FileNotFoundException {
        JsonUtil jsonUtil = new JsonUtil();
        JsonReader reader = jsonUtil.readJsonFile(nameOfJsonFile);
        Gson gson = new Gson();
        StudentRegistrationFormTestData studentRegistrationFormTestData = gson.fromJson(reader, StudentRegistrationFormTestData.class);
        return studentRegistrationFormTestData;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String[] getSubjects() {
        return subjects;
    }

    private String getArraysToString(String[] array){
        //Initialize with the first value in array
        String results = "";
        if (array.length <= 1) {
            results = array[0];
        }
        else {
            for (int i = 0; i <= array.length - 2; i++) {
               results += array[i] + ", ";
            }
            //Add the final value array
            results += array[array.length - 1];
        }
        return results;
    }

    public String getSubjectsToString() {
        return getArraysToString(subjects);
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public String getHobbiesToString() {
        return getArraysToString(hobbies);
    }

    public String getPicture() {
        return picture;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}
