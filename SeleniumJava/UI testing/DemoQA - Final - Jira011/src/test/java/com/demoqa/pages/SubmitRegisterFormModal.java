package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubmitRegisterFormModal extends BasePage{
    /** ---------------------- Elements ------------------------ */
    private static final By LBL_TITLE = By.cssSelector("div.modal-title");
    private static String LBL_VALUE_LOCATOR = "//div[@class='modal-content']//td[text()='%s']//following-sibling::td";

    /** ---------------------- Constructor ------------------------ */
    public SubmitRegisterFormModal(WebDriver driver) {
        super(driver);
    }

    /** ---------------------- Page Methods -----------------------*/
    public String getValueOfField(String field) {
        return getText(convertLocator("xpath", this.LBL_VALUE_LOCATOR, field));
    }

    public String getStudentName() {
        return getValueOfField("Student Name");
    }

    public String getStudentEmail() {
        return getValueOfField("Student Email");
    }

    public String getGender() {
        return getValueOfField("Gender");
    }

    public String getMobile() {
        return getValueOfField("Mobile");
    }

    public String getDateOfBirth() {
        return getValueOfField("Date of Birth");
    }

    public String getSubjects() {
        return getValueOfField("Subjects");
    }

    public String getHobbies() {
        return getValueOfField("Hobbies");
    }

    public String getPicture() {
        return getValueOfField("Picture");
    }

    public String getAddress() {
        return getValueOfField("Address");
    }

    public String getStateAndCity() {
        return getValueOfField("State and City");
    }

    public String getTitle() {
        return getText(this.LBL_TITLE);
    }
}
