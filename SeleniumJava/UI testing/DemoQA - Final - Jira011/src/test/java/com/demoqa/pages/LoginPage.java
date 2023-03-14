package com.demoqa.pages;

import com.demoqa.constants.UrlConstants;
import com.demoqa.testdatas.LoginTestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;

public class LoginPage extends BasePage{
    /** ---------------------- Elements ------------------------ */
    private static final By TXT_USERNAME = By.id("userName");
    private static final By TXT_PASSWORD = By.id("password");
    private static final By BTN_LOGIN = By.id("login");

    /** ---------------------- Constructor ------------------------ */
    public LoginPage(WebDriver driver){
        super(driver);
    }

    /** ---------------------- Methods ------------------------ */
    public void inputUserName(String username) {
        inputText(this.TXT_USERNAME, username);
    }

    public void inputPassword(String password) {
        inputText(this.TXT_PASSWORD, password);
    }

    public void clickLoginButton() {
        clickElement(this.BTN_LOGIN);
    }

    //Define login with valid account to make pre-condition
    public void loginWithValidAccount() throws FileNotFoundException {
        //Get test data
        LoginTestData loginTestData = new LoginTestData("login_test_data.json");

        navigateToUrl(UrlConstants.LOGIN_URL);
        inputUserName(loginTestData.getUsername());
        inputPassword(loginTestData.getPassword());
        clickLoginButton();
    }
}
