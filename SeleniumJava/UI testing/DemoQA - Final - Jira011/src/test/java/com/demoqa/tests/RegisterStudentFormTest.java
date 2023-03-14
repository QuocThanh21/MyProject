package com.demoqa.tests;

import com.demoqa.constants.MessageConstants;
import com.demoqa.constants.UrlConstants;
import com.demoqa.pages.RegisterStudentFormPage;
import com.demoqa.testdatas.StudentRegistrationFormTestData;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.FileNotFoundException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegisterStudentFormTest extends BaseTest{
    private RegisterStudentFormPage registerStudentFormPage;
    private StudentRegistrationFormTestData studentRegistrationFormTestData;

    @BeforeMethod
    public void beforeMethod() throws FileNotFoundException, AWTException {
        registerStudentFormPage = new RegisterStudentFormPage(driver);
        //Get test data
        studentRegistrationFormTestData = new StudentRegistrationFormTestData("student_registration_form_test_data.json");
        //Navigate to Register student form page
        registerStudentFormPage.navigateToUrl(UrlConstants.STUDENT_REGISTRATION_FORM_URL);
        //Zoom out browser for submit button appears to click
        registerStudentFormPage.zoomOutBrowser(6);
    }

    @Test(description = "Scenario 1.1: Register student form with all fields successfully.")
    public void registerStudentFormSuccessfullyWithAllFields() {
        registerStudentFormPage.inputFirstName(studentRegistrationFormTestData.getFirstName());
        registerStudentFormPage.inputLastName(studentRegistrationFormTestData.getLastName());
        registerStudentFormPage.inputEmail(studentRegistrationFormTestData.getUserEmail());
        registerStudentFormPage.selectGender(studentRegistrationFormTestData.getGender());
        registerStudentFormPage.inputMobile(studentRegistrationFormTestData.getMobile());
        registerStudentFormPage.selectDateOfBirth(studentRegistrationFormTestData.getDateOfBirth());
        registerStudentFormPage.selectSubjects(studentRegistrationFormTestData.getSubjects());
        registerStudentFormPage.selectHobbies(studentRegistrationFormTestData.getHobbies());
        registerStudentFormPage.uploadPicture(studentRegistrationFormTestData.getPicture());
        registerStudentFormPage.inputCurrentAddress(studentRegistrationFormTestData.getCurrentAddress());
        registerStudentFormPage.selectState(studentRegistrationFormTestData.getState());
        registerStudentFormPage.selectCity(studentRegistrationFormTestData.getCity());

        registerStudentFormPage.clickSubmitButton();

        String actualTitleOfSubmitModalDialog = registerStudentFormPage.getTitleInSubmitModalDialog();
        assertThat("Verify submit message in Title of Modal Dialog", actualTitleOfSubmitModalDialog,
                equalTo(MessageConstants.SUBMIT_SUCCESSFULLY_MESSAGE));

        String actualStudentName = registerStudentFormPage.getStudentNameInSubmitModalDialog();
        assertThat("Verify Student name", actualStudentName,
                equalTo(studentRegistrationFormTestData.getFirstName() + " " + studentRegistrationFormTestData.getLastName()));

        String actualStudentEmail = registerStudentFormPage.getStudentEmailInSubmitModalDialog();
        assertThat("Verify Student email", actualStudentEmail,
                equalTo(studentRegistrationFormTestData.getUserEmail()));

        String actualGender = registerStudentFormPage.getGenderInSubmitModalDialog();
        assertThat("Verify Gender", actualGender,
                equalTo(studentRegistrationFormTestData.getGender()));

        String actualMobile = registerStudentFormPage.getMobileInSubmitModalDialog();
        assertThat("Verify Mobile", actualMobile,
                equalTo(studentRegistrationFormTestData.getMobile()));

        String actualDateOfBirth = registerStudentFormPage.getDateOfBirthInSubmitModalDialog();
        assertThat("Verify Date of Birth", actualDateOfBirth,
                equalTo(studentRegistrationFormTestData.getDateOfBirth()));

        String actualSubjects = registerStudentFormPage.getSubjectsInSubmitModalDialog();
        assertThat("Verify Subjects", actualSubjects,
                equalTo(studentRegistrationFormTestData.getSubjectsToString()));

        String actualHobbies = registerStudentFormPage.getHobbiesInSubmitModalDialog();
        assertThat("Verify Hobbies", actualHobbies,
                equalTo(studentRegistrationFormTestData.getHobbiesToString()));

        String actualPicture = registerStudentFormPage.getPictureInSubmitModalDialog();
        String[] filePicture = StringUtils.split(studentRegistrationFormTestData.getPicture(),"\\");
        String expectPicture = filePicture[filePicture.length - 1];
        assertThat("Verify Picture", actualPicture,
                equalTo(expectPicture));

        String actualAddress = registerStudentFormPage.getAddressInSubmitModalDialog();
        assertThat("Verify Address", actualAddress,
                equalTo(studentRegistrationFormTestData.getCurrentAddress()));

        String actualStateAndCity = registerStudentFormPage.getStateAndCityInSubmitModalDialog();
        assertThat("Verify State and City ", actualStateAndCity,
                equalTo(studentRegistrationFormTestData.getState() + " " + studentRegistrationFormTestData.getCity()));
    }

    @Test(description = "Scenario 1.2: Register student form with mandatory fields successfully.")
    public void registerStudentFormSuccessfullyWithMandatoryFields() {
        registerStudentFormPage.inputFirstName(studentRegistrationFormTestData.getFirstName());
        registerStudentFormPage.inputLastName(studentRegistrationFormTestData.getLastName());
        registerStudentFormPage.selectGender(studentRegistrationFormTestData.getGender());
        registerStudentFormPage.inputMobile(studentRegistrationFormTestData.getMobile());

        registerStudentFormPage.clickSubmitButton();

        String actualTitleOfSubmitModalDialog = registerStudentFormPage.getTitleInSubmitModalDialog();
        assertThat("Verify submit message in Title of Modal Dialog", actualTitleOfSubmitModalDialog,
                equalTo(MessageConstants.SUBMIT_SUCCESSFULLY_MESSAGE));

        String actualStudentName = registerStudentFormPage.getStudentNameInSubmitModalDialog();
        assertThat("Verify Student name", actualStudentName,
                equalTo(studentRegistrationFormTestData.getFirstName() + " " + studentRegistrationFormTestData.getLastName()));

        String actualGender = registerStudentFormPage.getGenderInSubmitModalDialog();
        assertThat("Verify Gender", actualGender,
                equalTo(studentRegistrationFormTestData.getGender()));

        String actualMobile = registerStudentFormPage.getMobileInSubmitModalDialog();
        assertThat("Verify Mobile", actualMobile,
                equalTo(studentRegistrationFormTestData.getMobile()));
    }
}
