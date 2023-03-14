package com.nachtech.tms.pages;

import com.nachtech.tms.shared.DatePicker;
import org.openqa.selenium.By;

public class CreateProjectPopup extends BasePage{
    /** ---------------------- Web elements ------------------------ */
    private DatePicker datePicker = new DatePicker();

    /** ---------------------- Locators of Web elements ------------------------ */
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

    /** ---------------------- Page Methods -----------------------*/
    /** Input element */
    public void inputProjectName(String projectName) {
        inputText(TXT_PROJECT_NAME, projectName);
    }

    public void selectProjectType(String projectType) {
        selectOptionOfDropdownByVisibleText(DDL_PROJECT_TYPE, projectType);
    }

    public void selectProjectStatus(String projectStatus) {
        selectOptionOfDropdownByVisibleText(DDL_PROJECT_STATUS, projectStatus);
    }

    public void selectStartDate(String date) {
        clickElement(DTP_START_DATE);
        datePicker.selectDate(date);
    }

    public void selectEndDate(String date) {
        clickElement(DTP_END_DATE);
        datePicker.selectDate(date);
    }

    public void inputSizeDay(String sizeDay) {
        inputText(TXT_SIZE_DAY, sizeDay);
    }

    public void selectLocation(String location) {
        selectOptionOfDropdownByVisibleText(DDL_LOCATION, location);
    }

    public void selectProjectManager(String projectManager) {
        selectOptionOfDropdownByVisibleText(DDL_PROJECT_MANAGER, projectManager);
    }

    public void selectDeliveryManager(String deliveryManage) {
        selectOptionOfDropdownByVisibleText(DDL_DELIVERY_MANAGER, deliveryManage);
    }

    public void selectEngagementManager(String engagementManager) {
        selectOptionOfDropdownByVisibleText(DDL_ENGAGEMENT_MANAGER, engagementManager);
    }

    public void inputShortDescription(String shortDescription) {
        inputText(TXA_SHORT_DESCRIPTION, shortDescription);
    }

    public void inputLongDescription(String longDescription) {
        inputText(TXA_LONG_DESCRIPTION, longDescription);
    }

    public void inputTechnologies(String technologies) {
        inputText(TXA_TECHNOLOGIES, technologies);
    }

    public void inputClientName(String clientName) {
        inputText(TXT_CLIENT_NAME, clientName);
    }

    public void selectClientIndustry(String clientIndustry) {
        selectOptionOfDropdownByVisibleText(DDL_CLIENT_INDUSTRY, clientIndustry);
    }

    public void inputClientDescription(String clientDescription) {
        inputText(TXA_CLIENT_DESCRIPTION, clientDescription);
    }

    /** Click element */
    public void clickCreateButton() {
        clickElement(BTN_CREATE);
    }

    /** Get text element */
    public String getCreateProjectSuccessfullyMessage() {
        return getText(LBL_CREATE_PROJECT_SUCCESSFULLY_MESSAGE);
    }
}
