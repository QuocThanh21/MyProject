package com.demoqa.pages.shared;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.By;

public class ModalDialog extends BasePage {
    /** ---------------------- Elements ------------------------ */
    private static final By BTN_OK = By.id("closeSmallModal-ok");

    /** ---------------------- Methods -----------------------*/
    public void clickOkButton() {
        clickElement(this.BTN_OK);
    }
}
