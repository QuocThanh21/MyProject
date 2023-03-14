package com.hoadoan.seleniumtestng.pages;

import com.hoadoan.seleniumtestng.utils.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private static final By TXT_USERNAME = By.id("userName");
    private static final By TXT_PASSWORD = By.id("password");
    private static final By BTN_LOGIN = By.id("login");
    private static final By LBL_ERROR = By.id("name");

    /**
     * Constructor
     */
    public LoginPage(WebDriver driver){
        super(driver);
    }

    /**
     * Page Methods
     */
    public void inputUserName(String username) {
        Log.info("Input username: " + username);
        inputText(TXT_USERNAME, username);
    }

    public void inputPassword(String password) {
        Log.info("Input password: " + password);
        inputText(TXT_PASSWORD, password);
    }

    public void clickLoginButton() {
        Log.info("Click Login button");
        clickElement(BTN_LOGIN);
    }

    public String getErrorMessage() {
        return getText(LBL_ERROR);
    }

}
