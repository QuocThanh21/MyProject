package com.nachtech.tms.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    /** ---------------------- Locators of Web elements ------------------------ */
    public static final By LBL_ERROR_INCORRECT_USERNAME_PASSWORD = By.cssSelector("div[ng-show='isError']");
    public static final By TXT_USERNAME = By.id("username");
    public static final By LBL_ERROR_REQUIRED_USERNAME = By.cssSelector("div[ng-messages='submitted && loginForm.username.$error'] > p");
    public static final By TXT_PASSWORD = By.id("password");
    public static final By LBL_ERROR_REQUIRED_PASSWORD = By.cssSelector("div[ng-messages='submitted && loginForm.password.$error'] > p");
    public static final By BTN_LOGIN = By.cssSelector("input[value='Login']");

    /** ---------------------- Methods ------------------------ */
    public void inputUsername(String username) {
        inputText(this.TXT_USERNAME, username);
    }

    public void inputPassword(String password) {
        inputText(this.TXT_PASSWORD, password);
    }

    public void clickLoginButton() {
        clickElement(this.BTN_LOGIN);
    }

    public String getActualErrorRequiredPasswordMessage() {
        return getText(LBL_ERROR_REQUIRED_PASSWORD);
    }

    public String getActualErrorRequiredUsernameMessage() {
        return getText(LBL_ERROR_REQUIRED_USERNAME);
    }

    public String getActualIncorrectAccountMessage() {
        return getText(LBL_ERROR_INCORRECT_USERNAME_PASSWORD);
    }

    //Define login with valid account to make pre-condition
    public void loginWithValidAccount(String username, String password){
        navigateToUrl(System.getProperty("LOGIN_URL"));
        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
    }
}
