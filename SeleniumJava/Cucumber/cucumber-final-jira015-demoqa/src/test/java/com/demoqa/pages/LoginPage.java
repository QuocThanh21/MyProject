package com.demoqa.pages;

import com.demoqa.steps.StepHooks;
import org.openqa.selenium.Cookie;

public class LoginPage extends BasePage{
    //Define login with valid account to make pre-condition
    public void loginWithValidAccount(String userID, String username, String token, String expires) {
        StepHooks.driver.manage().addCookie(new Cookie("userID", userID));
        StepHooks.driver.manage().addCookie(new Cookie("userName", username));
        StepHooks.driver.manage().addCookie(new Cookie("token", token));
        StepHooks.driver.manage().addCookie(new Cookie("expires", expires));
    }
}
