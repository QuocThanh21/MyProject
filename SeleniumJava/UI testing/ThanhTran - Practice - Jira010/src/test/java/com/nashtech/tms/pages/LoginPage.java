package com.nashtech.tms.pages;

import com.nashtech.tms.constants.locators.LoginPageLocators;
import com.nashtech.tms.constants.UrlConstants;
import com.nashtech.tms.testdatas.LoginTestData;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;


public class LoginPage extends BasePage{
    /** ---------------------- Constructor ------------------------ */
    public LoginPage(WebDriver driver){
        super(driver);
    }

    /** ---------------------- Page Methods -----------------------*/
    /** Input element */
    public void inputUsername(String username) {
        inputText(LoginPageLocators.TXT_USERNAME, username);
    }

    public void inputPassword(String password) {
        inputText(LoginPageLocators.TXT_PASSWORD, password);
    }

    /** Click element */
    public void clickLoginButton() {
        clickElement(LoginPageLocators.BTN_LOGIN);
    }

    /** Get text */
//    public String getActualErrorRequiredPasswordMessage() {
//        return getErrorMessage(LoginPageLocators.LBL_ERROR_REQUIRED_PASSWORD);
//    }

    public String getActualErrorRequiredPasswordMessage() {
        return getText(LoginPageLocators.LBL_ERROR_REQUIRED_PASSWORD);
    }

    public String getActualErrorRequiredUsernameMessage() {
        return getErrorMessage(LoginPageLocators.LBL_ERROR_REQUIRED_USERNAME);
    }

    public String getActualIncorrectMessage() {
        return getErrorMessage(LoginPageLocators.LBL_ERROR_INCORRECT_USERNAME_PASSWORD);
    }

    //define login method to make pre-condition for create and search project
    public void loginWithValidAccount() throws FileNotFoundException {
        //Get test data
        LoginTestData loginTestData = new LoginTestData("login_test_data.json");

        navigateToUrl(UrlConstants.LOGIN_URL);
        inputUsername(loginTestData.getValidUsername());
        inputPassword(loginTestData.getValidPassword());
        clickLoginButton();
    }
}
