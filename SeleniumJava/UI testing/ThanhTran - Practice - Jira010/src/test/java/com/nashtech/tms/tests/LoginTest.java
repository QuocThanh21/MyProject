package com.nashtech.tms.tests;

import com.nashtech.tms.constants.locators.LoginPageLocators;
import com.nashtech.tms.constants.UrlConstants;
import com.nashtech.tms.pages.LoginPage;
import com.nashtech.tms.constants.MessageConstants;
import com.nashtech.tms.pages.NavigationBar;
import com.nashtech.tms.testdatas.LoginTestData;
import org.testng.annotations.*;
import java.io.FileNotFoundException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest extends BaseTest{
    private LoginPage loginPage;
    private NavigationBar navigationBar;
    private LoginTestData loginTestData;

    @BeforeMethod
    public void beforeMethod() throws FileNotFoundException {
        loginPage = new LoginPage(driver);
        navigationBar = new NavigationBar(driver);

        //Get test data
        loginTestData = new LoginTestData("login_test_data.json");

        //Navigate to Login page
        loginPage.navigateToUrl(UrlConstants.LOGIN_URL);
    }

    @Test(description = "Login successfully with valid account.")
    public void loginSuccessfullyWithValidAccount() {
        loginPage.inputUsername(loginTestData.getValidUsername());
        loginPage.inputPassword(loginTestData.getValidPassword());
        loginPage.clickLoginButton();

        String actualUsername = navigationBar.getUsername();
        assertThat("Verify username", actualUsername, equalTo(loginTestData.getValidUsername()));
    }

    @Test(description = "Login unsuccessfully with empty password.")
    public void loginUnsuccessfullyWithEmptyPassword() {
        loginPage.inputUsername(loginTestData.getValidUsername());
        loginPage.clearElement(LoginPageLocators.TXT_PASSWORD);
        loginPage.clickLoginButton();

        assertThat("Verify error required password message",
                loginPage.getActualErrorRequiredPasswordMessage(), equalTo(MessageConstants.EXPECTED_REQUIRED_FIELD_MESSAGE));
    }

    @Test(description = "Login unsuccessfully with empty username.")
    public void loginUnsuccessfullyWithEmptyUsername() {
        loginPage.clearElement(LoginPageLocators.TXT_USERNAME);
        loginPage.inputPassword(loginTestData.getValidPassword());
        loginPage.clickLoginButton();

            }

    @Test(description = "Login unsuccessfully with empty username & password.")
    public void loginUnsuccessfullyWithEmptyUsernamePassword() {
        loginPage.clearElement(LoginPageLocators.TXT_USERNAME);
        loginPage.clearElement(LoginPageLocators.TXT_PASSWORD);
        loginPage.clickLoginButton();

        assertThat("Verify error required username message",
                loginPage.getActualErrorRequiredUsernameMessage(), equalTo(MessageConstants.EXPECTED_REQUIRED_FIELD_MESSAGE));

        assertThat("Verify error required password message",
                loginPage.getActualErrorRequiredPasswordMessage(), equalTo(MessageConstants.EXPECTED_REQUIRED_FIELD_MESSAGE));
    }

    @Test(description = "Login unsuccessfully with invalid account.")
    public void loginUnsuccessfullyWithInvalidAccount() {
        loginPage.inputUsername(loginTestData.getInvalidUsername());
        loginPage.inputPassword(loginTestData.getInvalidPassword());
        loginPage.clickLoginButton();

        assertThat("Verify error incorrect username & password message",
                loginPage.getActualIncorrectMessage(), equalTo(MessageConstants.EXPECTED_INCORRECT_INPUT_LOGIN_MESSAGE));
    }
}
