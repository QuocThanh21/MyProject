package com.demoqa.testdatas;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.demoqa.utils.JsonUtil;
import java.io.FileNotFoundException;

public class LoginTestData {
    private String username;
    private String password;

    /** ---------------------- Constructor ------------------------ */
    public LoginTestData(String nameOfJsonFile) throws FileNotFoundException {
        LoginTestData loginTestData = covertJsonToObject(nameOfJsonFile);
        this.username = loginTestData.getUsername();
        this.password = loginTestData.getPassword();
    }

    /** ---------------------- Methods ------------------------ */
    private LoginTestData covertJsonToObject(String nameOfJsonFile) throws FileNotFoundException {
        JsonUtil jsonUtil = new JsonUtil();
        JsonReader reader = jsonUtil.readJsonFile(nameOfJsonFile);
        Gson gson = new Gson();
        LoginTestData loginTestData = gson.fromJson(reader, LoginTestData.class);
        return loginTestData;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
