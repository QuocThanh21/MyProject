package com.demoqa.pages;

import com.demoqa.shared.DatePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterStudentFormPage extends BasePage{
    /** ---------------------- Elements ------------------------ */
    /** Elements in Register form */
    private static final By TXT_FIRST_NAME = By.id("firstName");
    private static final By TXT_LAST_NAME = By.id("lastName");
    private static final By TXT_EMAIL = By.id("userEmail");
    private static final String RDO_GENDER_LOCATOR = "//label[contains(@for,'gender') and text()='%s']";
    private static final By TXT_MOBILE = By.id("userNumber");
    private static final By TXT_SUBJECT = By.id("subjectsInput");
    private static final String OPT_SUBJECT_LOCATOR = "//div[@id='subjectsContainer']//div[contains(@id,'option') and text()='%s']";
    private static final String CHK_HOBBIES_LOCATOR = "//label[contains(@for,'hobbies') and text()='%s']";
    private static final By TXT_UPLOAD_PICTURE = By.id("uploadPicture");
    private static final By TXA_ADDRESS = By.id("currentAddress");
    private static final By DDL_STATE = By.id("state");
    private static final String OPT_STATE = "//div[@id='state']//div[contains(@id,'option') and text()='%s']";
    private static final By DDL_CITY = By.id("city");
    private static final String OPT_CITY = "//div[@id='city']//div[contains(@id,'option') and text()='%s']";
    private static final By BTN_SUBMIT = By.id("submit");

    private SubmitRegisterFormModal submitRegisterFormModal;
    private DatePicker datePicker;

    /** ---------------------- Constructor ------------------------ */
    public RegisterStudentFormPage(WebDriver driver) {
        super(driver);
        submitRegisterFormModal = new SubmitRegisterFormModal(driver);
        datePicker = new DatePicker(driver);
    }

    /** ---------------------- Page Methods in Register form-----------------------*/
    public void inputFirstName(String firstName) {
        inputText(this.TXT_FIRST_NAME, firstName);
    }

    public void inputLastName(String lastName) {
        inputText(this.TXT_LAST_NAME, lastName);
    }

    public void inputEmail(String email) {
        inputText(this.TXT_EMAIL, email);
    }

    public void selectGender(String gender) {
        clickElement(convertLocator("xpath", this.RDO_GENDER_LOCATOR, gender));
    }

    public void inputMobile(String mobile) {
        inputText(this.TXT_MOBILE, mobile);
    }

    public void selectDateOfBirth(String dateOfBirth) {
        datePicker.selectDate(dateOfBirth);
    }

    public void selectSubjects(String[] subjects) {
        for(String subject : subjects) {
            inputText(this.TXT_SUBJECT, subject);
            clickElement(convertLocator("xpath", this.OPT_SUBJECT_LOCATOR, subject));
        }
    }

    public void selectHobbies(String[] hobbies) {
        for(String hobby : hobbies) {
            clickElement(convertLocator("xpath", this.CHK_HOBBIES_LOCATOR, hobby));
        }
    }

    public void uploadPicture(String pictureFile) {
        inputText(this.TXT_UPLOAD_PICTURE, pictureFile);
    }

    public void inputCurrentAddress(String currentAddress) {
        inputText(this.TXA_ADDRESS, currentAddress);
    }

    public void selectState(String state) {
        clickElement(this.DDL_STATE);
        clickElement(convertLocator("xpath", this.OPT_STATE, state));
    }

    public void selectCity(String city) {
        clickElement(this.DDL_CITY);
        clickElement(convertLocator("xpath", this.OPT_CITY, city));
    }

    public void clickSubmitButton() {
        clickElement(this.BTN_SUBMIT);
    }

    /** ---------------------- Page Methods in Submit modal -----------------------*/
    public String getStudentNameInSubmitModalDialog() { return submitRegisterFormModal.getStudentName(); }

    public String getStudentEmailInSubmitModalDialog() { return submitRegisterFormModal.getStudentEmail(); }

    public String getGenderInSubmitModalDialog() {
        return submitRegisterFormModal.getGender();
    }

    public String getMobileInSubmitModalDialog() {
        return submitRegisterFormModal.getMobile();
    }

    public String getDateOfBirthInSubmitModalDialog() {
        return submitRegisterFormModal.getDateOfBirth();
    }

    public String getSubjectsInSubmitModalDialog() { return submitRegisterFormModal.getSubjects(); }

    public String getHobbiesInSubmitModalDialog() { return submitRegisterFormModal.getHobbies(); }

    public String getPictureInSubmitModalDialog() { return submitRegisterFormModal.getPicture(); }

    public String getAddressInSubmitModalDialog() {
        return submitRegisterFormModal.getAddress();
    }

    public String getStateAndCityInSubmitModalDialog() { return submitRegisterFormModal.getStateAndCity(); }

    public String getTitleInSubmitModalDialog() { return submitRegisterFormModal.getTitle(); }
}
