package com.nachtech.tms.models;

public class Project {
    public String projectName;
    public String projectType;
    public String projectStatus;
    public String startDate;
    public String endDate;
    public String sizeDay;
    public String location;
    public String projectManager;
    public String deliveryManager;
    public String engagementManager;
    public String shortDescription;
    public String longDescription;
    public String technologies;
    public String clientName;
    public String clientIndustry;
    public String clientDescription;

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
