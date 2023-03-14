package com.demoqa.pages.shared;

import com.demoqa.pages.BasePage;
import com.demoqa.steps.StepHooks;

public class AlertDialog extends BasePage {

    /** ---------------------- Methods -----------------------*/
    public String getTitleAlertDialog() {
        waitAlertIsPresent();
        return StepHooks.driver.switchTo().alert().getText();
    }

    public void acceptAlertDialog() {
        waitAlertIsPresent();
        StepHooks.driver.switchTo().alert().accept();
    }
}
