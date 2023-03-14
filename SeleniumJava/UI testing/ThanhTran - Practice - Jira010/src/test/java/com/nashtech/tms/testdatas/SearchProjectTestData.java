package com.nashtech.tms.testdatas;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.nashtech.tms.utils.JsonUtil;
import java.io.FileNotFoundException;

public class SearchProjectTestData {
    private String projectName;
    private String projectType;
    private String location;

    /** ---------------------- Constructor ------------------------ */
    public SearchProjectTestData(String nameOfJsonFile) throws FileNotFoundException {
        SearchProjectTestData searchProjectTestData = covertJsonToObject(nameOfJsonFile);
        this.projectName = searchProjectTestData.getProjectName();
        this.projectType = searchProjectTestData.getProjectType();
        this.location = searchProjectTestData.getLocation();
    }

    /** ---------------------- Methods ------------------------ */
    private SearchProjectTestData covertJsonToObject(String nameOfJsonFile) throws FileNotFoundException {
        JsonUtil jsonUtil = new JsonUtil();
        JsonReader reader = jsonUtil.readJsonFile(nameOfJsonFile);
        Gson gson = new Gson();
        SearchProjectTestData searchProjectTestData = gson.fromJson(reader, SearchProjectTestData.class);
        return searchProjectTestData;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public String getLocation() {
        return location;
    }
}
