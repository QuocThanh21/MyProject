package com.demoqa.pages;

import com.demoqa.shared.AlertDialog;
import com.demoqa.shared.BooksTable;
import com.demoqa.shared.ModalDialog;
import com.demoqa.shared.SearchBox;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage{
    private BooksTable booksTable;
    private SearchBox searchBox;
    private ModalDialog deleteModalDialog;
    private AlertDialog deleteAlertDialog;

    /** ---------------------- Constructor ------------------------ */
    public ProfilePage(WebDriver driver) {
        super(driver);
        booksTable = new BooksTable(driver);
        searchBox = new SearchBox(driver);
        deleteModalDialog = new ModalDialog(driver);
        deleteAlertDialog = new AlertDialog(driver);
    }

    /** ---------------------- Methods ------------------------ */
    public void inputSearchBox(String keyword) {
        searchBox.inputSearchBox(keyword);
    }

    public void clickDeleteButton() {
        booksTable.clickDeleteButton();
    }

    public void clickOkButtonOfDeleteModalDialog() {
        deleteModalDialog.clickOkButton();
    }

    //  Define method to verify whether book is found in table
    public boolean haveBookInTable(String titleBook) {
        return booksTable.haveBookInTable(titleBook);
    }

    public String getTitleOfDeleteAlertDialog() {
        return deleteAlertDialog.getTitleAlertDialog();
    }

    public void acceptDeleteAlertDialog() {
        deleteAlertDialog.acceptAlertDialog();
    }
}
