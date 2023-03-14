package com.demoqa.pages;

import com.demoqa.pages.shared.AlertDialog;
import org.openqa.selenium.By;

public class BookDetailPage extends BasePage{
    private AlertDialog addAlertDialog;
    /** ---------------------- Elements ------------------------ */
    private static final By BTN_ADD_TO_YOUR_COLLECTION = By.xpath("//button[@id='addNewRecordButton' and text()='Add To Your Collection']");

    /**  ---------------------- Constructor ------------------------ */
    public BookDetailPage() {
        addAlertDialog = new AlertDialog();
    }

    /** ---------------------- Methods -----------------------*/
    public void clickAddToYourCollectionButton() {
        clickElement(this.BTN_ADD_TO_YOUR_COLLECTION);
    }

    public String getTitleOfAddAlertDialog() {
        return addAlertDialog.getTitleAlertDialog();
    }

    public void acceptAddAlertDialog() {
        addAlertDialog.acceptAlertDialog();
    }
}
