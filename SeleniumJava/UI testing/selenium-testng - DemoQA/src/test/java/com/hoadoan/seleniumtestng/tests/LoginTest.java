package com.hoadoan.seleniumtestng.tests;

import com.hoadoan.seleniumtestng.constants.ConfigConstants;
import com.hoadoan.seleniumtestng.constants.UrlConstants;
import com.hoadoan.seleniumtestng.pages.LoginPage;
import com.hoadoan.seleniumtestng.pages.NavigationPage;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import static com.hoadoan.seleniumtestng.utils.extentreports.ExtentTestManager.startTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest extends BaseTest{
    LoginPage loginPage;
    NavigationPage navigationPage;

    @Test(priority = 0, description = "Login successfully with valid account.")
    public void loginSuccessfullyWithValidAccount(Method method) {
        //ExtentReports Description
        startTest(method.getName(), "Login successfully with valid account.");

        loginPage = new LoginPage(driver);
        navigationPage = new NavigationPage(driver);
        loginPage.navigate(UrlConstants.LOGIN_URL);

        loginPage.inputUserName(ConfigConstants.CORRECT_USERNAME);
        loginPage.inputPassword(ConfigConstants.CORRECT_PASSWORD);
        loginPage.clickLoginButton();

        String actualUsername = navigationPage.getUserName();
        assertThat("Verify username", actualUsername, equalTo(ConfigConstants.CORRECT_USERNAME));
    }

    @Test(priority = 1, description = "Login unsuccessfully with invalid account.")
    public void loginUnsuccessfullyWithInvalidAccount(Method method) {
        //ExtentReports Description
        startTest(method.getName(), "Login unsuccessfully with invalid account.");

        loginPage = new LoginPage(driver);
        navigationPage = new NavigationPage(driver);
        loginPage.navigate(UrlConstants.LOGIN_URL);

        loginPage.inputUserName(ConfigConstants.WRONG_USERNAME);
        loginPage.inputPassword(ConfigConstants.WRONG_PASSWORD);
        loginPage.clickLoginButton();

        String actualErrorMessage = loginPage.getErrorMessage();
        assertThat("Verify error message", actualErrorMessage, equalTo(ConfigConstants.ERROR_MESSAGE_LOGIN));
    }
}
