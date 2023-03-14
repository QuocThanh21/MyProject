package com.demoqa.shared;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class AlertDialog extends BasePage {
    private WebDriver driver;
    /** ---------------------- Constructor ------------------------ */
    public AlertDialog(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /** ---------------------- Methods -----------------------*/
    public String getTitleAlertDialog() {
        waitAlertIsPresent();
        return driver.switchTo().alert().getText();
    }

    public void acceptAlertDialog() {
        waitAlertIsPresent();
        driver.switchTo().alert().accept();
    }
}
