package com.demoqa.pages;

import com.demoqa.pages.shared.DatePicker;
import org.openqa.selenium.By;

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

    public SubmitRegisterFormModal submitRegisterFormModal;
    private DatePicker datePicker;

    /** ---------------------- Constructor ------------------------ */
    public RegisterStudentFormPage() {
        submitRegisterFormModal = new SubmitRegisterFormModal();
        datePicker = new DatePicker();
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

    public void selectSubjects(String subjects) {
        String[] listSubjects = subjects.split(", ");
        for(String subject : listSubjects) {
            inputText(this.TXT_SUBJECT, subject);
            clickElement(convertLocator("xpath", this.OPT_SUBJECT_LOCATOR, subject));
        }
    }

    public void selectHobbies(String hobbies) {
        String[] listHobbies = hobbies.split(", ");
        for(String hobby : listHobbies) {
            clickElement(convertLocator("xpath", this.CHK_HOBBIES_LOCATOR, hobby));
        }
    }

    public void uploadPicture(String pictureFile) {
        inputText(this.TXT_UPLOAD_PICTURE, System.getProperty("user.dir") + "/" + System.getProperty("IMAGE_DATA_DIR") + "/" + pictureFile);
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
}
