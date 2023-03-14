package com.nashtech.tms.constants.locators;

import org.openqa.selenium.By;

public class CreateProjectPopupLocators {
    public static final By TXT_PROJECT_NAME = By.id("name");
    public static final By DDL_PROJECT_TYPE = By.id("projecttype");
    public static final By DDL_PROJECT_STATUS = By.id("status");
    public static final By DTP_START_DATE = By.xpath("//input[@name='sdate']/..");
    public static final By DTP_END_DATE = By.xpath("//input[@name='edate']/..");
    public static final By TXT_SIZE_DAY = By.id("sizeday");
    public static final By DDL_LOCATION = By.id("location");
    public static final By DDL_PROJECT_MANAGER = By.id("projectManager");
    public static final By DDL_DELIVERY_MANAGER = By.id("deliveryManager");
    public static final By DDL_ENGAGEMENT_MANAGER = By.id("engagementManager");
    public static final By TXA_SHORT_DESCRIPTION = By.id("shortDescription");
    public static final By TXA_LONG_DESCRIPTION = By.id("longDescription");
    public static final By TXA_TECHNOLOGIES= By.id("technologies");
    public static final By TXT_CLIENT_NAME = By.id("clientName");
    public static final By DDL_CLIENT_INDUSTRY= By.id("clientindustry");
    public static final By TXA_CLIENT_DESCRIPTION = By.id("clientdescription");
    public static final By LBL_CREATE_PROJECT_SUCCESSFULLY_MESSAGE = By.cssSelector("span[data-notify='message']");

    public static final By BTN_CREATE = By.id("btnConfirm");
}
