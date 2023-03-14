package com.demoqa.steps;

import com.demoqa.constants.UrlConstants;
import com.demoqa.models.Student;
import com.demoqa.pages.RegisterStudentFormPage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegisterStudentSteps {
    private RegisterStudentFormPage registerStudentFormPage = new RegisterStudentFormPage();
    private Student studentData;

    @DataTableType
    public Student studentEntry(Map<String,String> entry) {
        return new Student(
                entry.get("First Name"),
                entry.get("Last Name"),
                entry.get("User Email"),
                entry.get("Gender"),
                entry.get("Mobile"),
                entry.get("Date of Birth"),
                entry.get("Subjects"),
                entry.get("Hobbies"),
                entry.get("Picture"),
                entry.get("Current Address"),
                entry.get("State"),
                entry.get("City")
        );
    }

    @Given("the user is on Student Registration Form")
    public void theUserIsOnStudentRegistrationForm() {
        registerStudentFormPage.navigateToUrl(UrlConstants.STUDENT_REGISTRATION_FORM_URL);
    }

    @When("the user input valid data into fields")
    public void theUserInputValidDataIntoAllFields(List<Student> dataTable) {
        studentData = dataTable.get(0);
        registerStudentFormPage.inputFirstName(studentData.firstName);
        registerStudentFormPage.inputLastName(studentData.lastName);

        if(studentData.userEmail != null) {
            registerStudentFormPage.inputEmail(studentData.userEmail);
        }

        registerStudentFormPage.selectGender(studentData.gender);
        registerStudentFormPage.inputMobile(studentData.mobile);

        if(studentData.dateOfBirth != null) {
            registerStudentFormPage.selectDateOfBirth(studentData.dateOfBirth);
        }

        if(studentData.subjects != null) {
            registerStudentFormPage.selectSubjects(studentData.subjects);
        }

        if(studentData.hobbies != null) {
            registerStudentFormPage.selectHobbies(studentData.hobbies);
        }

        if(studentData.picture != null) {
            registerStudentFormPage.uploadPicture(studentData.picture);
        }

        if(studentData.currentAddress != null) {
            registerStudentFormPage.inputCurrentAddress(studentData.currentAddress);
        }

        if(studentData.state != null) {
            registerStudentFormPage.selectState(studentData.state);
        }

        if(studentData.city != null) {
            registerStudentFormPage.selectCity(studentData.city);
        }
    }

    @And("the user clicks on Submit button")
    public void theUserClicksOnSubmitButton() {
        registerStudentFormPage.clickSubmitButton();
    }

    @Then("a successful message {string} is shown")
    public void aSuccessfulMessageIsShown(String successfulMsg) {
        String actualTitleOfSubmitModalDialog = registerStudentFormPage.submitRegisterFormModal.getTitle();
        assertThat("Verify submit message in Title of Modal Dialog", actualTitleOfSubmitModalDialog,
                equalTo(successfulMsg));
    }

    @And("all information of the student form is shown correctly")
    public void allInformationOfTheStudentFormIsShownCorrectly() {
        String actualStudentName = registerStudentFormPage.submitRegisterFormModal.getStudentName();
        assertThat("Verify Student name", actualStudentName,
                equalTo( studentData.firstName + " " + studentData.lastName));

        if(studentData.userEmail != null) {
            String actualStudentEmail = registerStudentFormPage.submitRegisterFormModal.getStudentEmail();
            assertThat("Verify Student email", actualStudentEmail,
                    equalTo(studentData.userEmail));
        }

        String actualGender = registerStudentFormPage.submitRegisterFormModal.getGender();
        assertThat("Verify Gender", actualGender,
                equalTo(studentData.gender));

        String actualMobile = registerStudentFormPage.submitRegisterFormModal.getMobile();
        assertThat("Verify Mobile", actualMobile,
                equalTo(studentData.mobile));

        if(studentData.dateOfBirth != null) {
            String actualDateOfBirth = registerStudentFormPage.submitRegisterFormModal.getDateOfBirth();
            assertThat("Verify Date of Birth", actualDateOfBirth,
                    equalTo(studentData.dateOfBirth));
        }

        if(studentData.subjects != null) {
            String actualSubjects = registerStudentFormPage.submitRegisterFormModal.getSubjects();
            assertThat("Verify Subjects", actualSubjects,
                    equalTo(studentData.subjects));
        }

        if(studentData.hobbies != null) {
            String actualHobbies = registerStudentFormPage.submitRegisterFormModal.getHobbies();
            assertThat("Verify Hobbies", actualHobbies,
                    equalTo(studentData.hobbies));
        }

        if(studentData.picture != null) {
            String actualPicture = registerStudentFormPage.submitRegisterFormModal.getPicture();
            String[] filePicture = StringUtils.split(studentData.picture,"/");
            String expectPicture = filePicture[filePicture.length - 1];
            assertThat("Verify Picture", actualPicture,
                    equalTo(expectPicture));
        }

        if(studentData.currentAddress != null) {
            String actualAddress = registerStudentFormPage.submitRegisterFormModal.getAddress();
            assertThat("Verify Address", actualAddress,
                    equalTo(studentData.currentAddress));
        }

        if(studentData.state != null && studentData.city != null) {
            String actualStateAndCity = registerStudentFormPage.submitRegisterFormModal.getStateAndCity();
            assertThat("Verify State and City ", actualStateAndCity,
                    equalTo(studentData.state + " " + studentData.city));
        }
    }
}
