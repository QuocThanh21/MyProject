package com.demoqa.shared;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModalDialog extends BasePage {
    /** ---------------------- Elements ------------------------ */
    private static final By BTN_OK = By.id("closeSmallModal-ok");

    /** ---------------------- Constructor ------------------------ */
    public ModalDialog(WebDriver driver) {
        super(driver);
    }

    /** ---------------------- Methods -----------------------*/
    public void clickOkButton() {
        clickElement(this.BTN_OK);
    }
}
