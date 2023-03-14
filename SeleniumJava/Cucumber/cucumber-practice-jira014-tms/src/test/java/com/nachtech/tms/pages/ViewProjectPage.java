package com.nachtech.tms.pages;

import org.openqa.selenium.By;

public class ViewProjectPage extends BasePage{
    /** ---------------------- Locators of Web elements ------------------------ */
    private static final By LBL_PROJECT_NAME = By.xpath("//label[text()='Project Name : ']/following-sibling::p");
    private static final By LBL_PROJECT_TYPE = By.xpath("//label[text()='Project Type : ']/following-sibling::p");
    private static final By LBL_PROJECT_STATUS = By.xpath("//label[text()='Project Status : ']/following-sibling::p");
    private static final By LBL_START_DATE = By.xpath("//label[@for='startDate']/following-sibling::p");
    private static final By LBL_END_DATE = By.xpath("//label[@for='endDate']/following-sibling::p");
    private static final By LBL_SIZE_DAY = By.xpath("//label[@for='sizeday']/following-sibling::p");
    private static final By LBL_LOCATION = By.xpath("//label[@for='location']/following-sibling::p");
    private static final By LBL_PROJECT_MANAGER = By.xpath("//label[@for='projectManager']/following-sibling::p");
    private static final By LBL_DELIVERY_MANAGER = By.xpath("//label[@for='deliveryManager']/following-sibling::p");
    private static final By LBL_ENGAGEMENT_MANAGER = By.xpath("//label[@for='engagementManager']/following-sibling::p");
    private static final By LBL_SHORT_DESCRIPTION = By.xpath("//label[@for='shortDescription']/following-sibling::p");
    private static final By LBL_LONG_DESCRIPTION = By.xpath("//label[@for='longDescription']/following-sibling::p");
    private static final By LBL_TECHNOLOGIES= By.xpath("//label[@for='technologies']/following-sibling::p");
    private static final By LBL_CLIENT_NAME = By.xpath("//label[@for='clientName']/following-sibling::p");
    private static final By LBL_CLIENT_INDUSTRY= By.xpath("//label[@for='clientindustry']/following-sibling::p");
    private static final By LBL_CLIENT_DESCRIPTION = By.xpath("//label[@for='clientdescription']/following-sibling::p");
    
    /** ---------------------- Page Methods ------------------------ */
    /** Get text element */
    public String getProjectName() { return getText(LBL_PROJECT_NAME); }

    public String getProjectType() { return getText(LBL_PROJECT_TYPE); }

    public String getProjectStatus() { return getText(LBL_PROJECT_STATUS); }

    public String getStartDate() { return getText(LBL_START_DATE); }

    public String getEndDate() { return getText(LBL_END_DATE); }

    public String getSizeDay() { return getText(LBL_SIZE_DAY); }

    public String getLocation() { return getText(LBL_LOCATION); }

    public String getProjectManager() { return getText(LBL_PROJECT_MANAGER); }

    public String getDeliveryManager() { return getText(LBL_DELIVERY_MANAGER); }

    public String getEngagementManager() { return getText(LBL_ENGAGEMENT_MANAGER); }

    public String getShortDescription() { return getText(LBL_SHORT_DESCRIPTION); }

    public String getLongDescription() { return getText(LBL_LONG_DESCRIPTION); }

    public String getTechnologies() { return getText(LBL_TECHNOLOGIES); }

    public String getClientName() { return getText(LBL_CLIENT_NAME); }

    public String getClientIndustry() { return getText(LBL_CLIENT_INDUSTRY); }

    public String getClientDescription() { return getText(LBL_CLIENT_DESCRIPTION); }
}
