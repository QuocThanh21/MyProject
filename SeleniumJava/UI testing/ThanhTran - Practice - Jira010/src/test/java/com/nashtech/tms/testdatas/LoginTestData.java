package com.nashtech.tms.testdatas;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.nashtech.tms.utils.JsonUtil;
import java.io.FileNotFoundException;

public class LoginTestData {
    private String validUsername;
    private String validPassword;
    private String invalidUsername;
    private String invalidPassword;

    /** ---------------------- Constructor ------------------------ */
    public LoginTestData(String nameOfJsonFile) throws FileNotFoundException {
        LoginTestData loginTestData = covertJsonToObject(nameOfJsonFile);
        this.validUsername = loginTestData.getValidUsername();
        this.validPassword = loginTestData.getValidPassword();
        this.invalidUsername = loginTestData.getInvalidUsername();
        this.invalidPassword = loginTestData.getInvalidPassword();
    }

    /** ---------------------- Methods ------------------------ */
    private LoginTestData covertJsonToObject(String nameOfJsonFile) throws FileNotFoundException {
        JsonUtil jsonUtil = new JsonUtil();
        JsonReader reader = jsonUtil.readJsonFile(nameOfJsonFile);
        Gson gson = new Gson();
        LoginTestData loginTestData = gson.fromJson(reader, LoginTestData.class);
        return loginTestData;
    }

    public String getValidUsername() { return validUsername; }

    public String getValidPassword() {
        return validPassword;
    }

    public String getInvalidUsername() {
        return invalidUsername;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }
}
