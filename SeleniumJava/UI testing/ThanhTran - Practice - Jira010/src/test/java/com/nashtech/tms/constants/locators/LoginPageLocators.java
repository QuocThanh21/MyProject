package com.nashtech.tms.constants.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By LBL_ERROR_INCORRECT_USERNAME_PASSWORD = By.cssSelector("div[ng-show='isError']");
    public static final By TXT_USERNAME = By.id("username");
    public static final By LBL_ERROR_REQUIRED_USERNAME = By.cssSelector("div[ng-messages='submitted && loginForm.username.$error'] > p");
    public static final By TXT_PASSWORD = By.id("password");
    public static final By LBL_ERROR_REQUIRED_PASSWORD = By.cssSelector("div[ng-messages='submitted && loginForm.password.$error'] > p");
    public static final By BTN_LOGIN = By.cssSelector("input[value='Login']");
}
