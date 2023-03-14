package com.hoadoan.seleniumtestng.pages;

import com.hoadoan.seleniumtestng.utils.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage{
    private static final By LBL_USERNAME = By.id("userName-value");

    /**
     * Constructor
     */
    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Page Methods
     */
    public String getUserName(){
        Log.info("Get username after logining successfully");
        return getText(LBL_USERNAME);
    }
}
