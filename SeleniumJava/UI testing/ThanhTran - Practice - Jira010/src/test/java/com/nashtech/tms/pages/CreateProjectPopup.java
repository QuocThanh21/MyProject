package com.nashtech.tms.pages;

import com.nashtech.tms.constants.locators.CreateProjectPopupLocators;
import com.nashtech.tms.shared.DatePicker;
import org.openqa.selenium.WebDriver;

public class CreateProjectPopup extends BasePage{
    private DatePicker datePicker;

    /** ---------------------- Constructor ------------------------ */
    public CreateProjectPopup(WebDriver driver) {
        super(driver);
        datePicker = new DatePicker(driver);
    }

    /** ---------------------- Page Methods -----------------------*/
    /** Input element */
    public void inputProjectName(String projectName) {
        inputText(CreateProjectPopupLocators.TXT_PROJECT_NAME, projectName);
    }

    public void selectProjectType(String projectType) {
        selectOptionOfDropdownByVisibleText(CreateProjectPopupLocators.DDL_PROJECT_TYPE, projectType);
    }

    public void selectProjectStatus(String projectStatus) {
        selectOptionOfDropdownByVisibleText(CreateProjectPopupLocators.DDL_PROJECT_STATUS, projectStatus);
    }

    public void selectStartDate(String date) {
        clickElement(CreateProjectPopupLocators.DTP_START_DATE);
        datePicker.selectDate(date);
    }

    public void selectEndDate(String date) {
        clickElement(CreateProjectPopupLocators.DTP_END_DATE);
        datePicker.selectDate(date);
    }

    public void inputSizeDay(String sizeDay) {
        inputText(CreateProjectPopupLocators.TXT_SIZE_DAY, sizeDay);
    }

    public void selectLocation(String location) {
        selectOptionOfDropdownByVisibleText(CreateProjectPopupLocators.DDL_LOCATION, location);
    }

    public void selectProjectManager(String projectManager) {
        selectOptionOfDropdownByVisibleText(CreateProjectPopupLocators.DDL_PROJECT_MANAGER, projectManager);
    }

    public void selectDeliveryManager(String deliveryManage) {
        selectOptionOfDropdownByVisibleText(CreateProjectPopupLocators.DDL_DELIVERY_MANAGER, deliveryManage);
    }

    public void selectEngagementManager(String engagementManager) {
        selectOptionOfDropdownByVisibleText(CreateProjectPopupLocators.DDL_ENGAGEMENT_MANAGER, engagementManager);
    }

    public void inputShortDescription(String shortDescription) {
        inputText(CreateProjectPopupLocators.TXA_SHORT_DESCRIPTION, shortDescription);
    }

    public void inputLongDescription(String longDescription) {
        inputText(CreateProjectPopupLocators.TXA_LONG_DESCRIPTION, longDescription);
    }

    public void inputTechnologies(String technologies) {
        inputText(CreateProjectPopupLocators.TXA_TECHNOLOGIES, technologies);
    }

    public void inputClientName(String clientName) {
        inputText(CreateProjectPopupLocators.TXT_CLIENT_NAME, clientName);
    }

    public void selectClientIndustry(String clientIndustry) {
        selectOptionOfDropdownByVisibleText(CreateProjectPopupLocators.DDL_CLIENT_INDUSTRY, clientIndustry);
    }

    public void inputClientDescription(String clientDescription) {
        inputText(CreateProjectPopupLocators.TXA_CLIENT_DESCRIPTION, clientDescription);
    }

    /** Click element */
    public void clickCreateButton() {
        clickElement(CreateProjectPopupLocators.BTN_CREATE);
    }

    /** Get text element */
    public String getCreateProjectSuccessfullyMessage() {
        return getText(CreateProjectPopupLocators.LBL_CREATE_PROJECT_SUCCESSFULLY_MESSAGE);
    }

}
