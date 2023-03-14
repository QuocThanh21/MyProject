package com.nashtech.tms.testdatas;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.nashtech.tms.utils.JsonUtil;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class CreateProjectTestData {
    private String projectName;
    private String projectType;
    private String projectStatus;
    private String startDate;
    private String endDate;
    private String sizeDay;
    private String location;
    private String projectManager;
    private String deliveryManager;
    private String engagementManager;
    private String shortDescription;
    private String longDescription;
    private String technologies;
    private String clientName;
    private String clientIndustry;
    private String clientDescription;

    /** ---------------------- Constructor ------------------------ */
    public CreateProjectTestData(String nameOfJsonFile) throws FileNotFoundException {
        CreateProjectTestData project = covertJsonToObject(nameOfJsonFile);
        this.projectName = project.getProjectName() + LocalDateTime.now(); //add LocalDateTime.now() to ensure projectName is unique
        this.projectType = project.getProjectType();
        this.projectStatus = project.getProjectStatus();
        this.startDate = project.getStartDate();
        this.endDate = project.getEndDate();
        this.sizeDay = project.getSizeDay();
        this.location = project.getLocation();
        this.projectManager = project.getProjectManager();
        this.deliveryManager = project.getDeliveryManager();
        this.engagementManager = project.getEngagementManager();
        this.shortDescription = project.getShortDescription();
        this.longDescription = project.getLongDescription();
        this.technologies = project.getTechnologies();
        this.clientName = project.getClientName();
        this.clientIndustry = project.getClientIndustry();
        this.clientDescription = project.getClientDescription();
    }

    /** ---------------------- Methods ------------------------ */
    private CreateProjectTestData covertJsonToObject(String nameOfJsonFile) throws FileNotFoundException {
        JsonUtil jsonUtil = new JsonUtil();
        JsonReader reader = jsonUtil.readJsonFile(nameOfJsonFile);
        Gson gson = new Gson();
        CreateProjectTestData project = gson.fromJson(reader, CreateProjectTestData.class);
        return project;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getSizeDay() {
        return sizeDay;
    }

    public String getLocation() {
        return location;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public String getDeliveryManager() {
        return deliveryManager;
    }

    public String getEngagementManager() {
        return engagementManager;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getTechnologies() {
        return technologies;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientIndustry() {
        return clientIndustry;
    }

    public String getClientDescription() {
        return clientDescription;
    }
}
