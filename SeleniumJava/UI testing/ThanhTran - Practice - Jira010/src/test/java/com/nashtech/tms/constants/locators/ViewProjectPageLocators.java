package com.nashtech.tms.constants.locators;

import org.openqa.selenium.By;

public class ViewProjectPageLocators {
    /** Project Information */
    public static final By LBL_PROJECT_NAME = By.xpath("//label[text()='Project Name : ']/following-sibling::p");
    public static final By LBL_PROJECT_TYPE = By.xpath("//label[text()='Project Type : ']/following-sibling::p");
    public static final By LBL_PROJECT_STATUS = By.xpath("//label[text()='Project Status : ']/following-sibling::p");
    public static final By LBL_START_DATE = By.xpath("//label[@for='startDate']/following-sibling::p");
    public static final By LBL_END_DATE = By.xpath("//label[@for='endDate']/following-sibling::p");
    public static final By LBL_SIZE_DAY = By.xpath("//label[@for='sizeday']/following-sibling::p");
    public static final By LBL_LOCATION = By.xpath("//label[@for='location']/following-sibling::p");
    public static final By LBL_PROJECT_MANAGER = By.xpath("//label[@for='projectManager']/following-sibling::p");
    public static final By LBL_DELIVERY_MANAGER = By.xpath("//label[@for='deliveryManager']/following-sibling::p");
    public static final By LBL_ENGAGEMENT_MANAGER = By.xpath("//label[@for='engagementManager']/following-sibling::p");
    public static final By LBL_SHORT_DESCRIPTION = By.xpath("//label[@for='shortDescription']/following-sibling::p");
    public static final By LBL_LONG_DESCRIPTION = By.xpath("//label[@for='longDescription']/following-sibling::p");
    public static final By LBL_TECHNOLOGIES= By.xpath("//label[@for='technologies']/following-sibling::p");
    public static final By LBL_CLIENT_NAME = By.xpath("//label[@for='clientName']/following-sibling::p");
    public static final By LBL_CLIENT_INDUSTRY= By.xpath("//label[@for='clientindustry']/following-sibling::p");
    public static final By LBL_CLIENT_DESCRIPTION = By.xpath("//label[@for='clientdescription']/following-sibling::p");
}
