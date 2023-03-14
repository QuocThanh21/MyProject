package com.demoqa.pages;

import com.demoqa.pages.shared.AlertDialog;
import com.demoqa.pages.shared.DataTable;
import com.demoqa.pages.shared.ModalDialog;
import com.demoqa.pages.shared.SearchBox;

public class ProfilePage extends BasePage{
    private DataTable booksTable;
    private SearchBox searchBox;
    private ModalDialog deleteConfirmationModalDialog;
    private AlertDialog alertDialog;

    /** ---------------------- Constructor ------------------------ */
    public ProfilePage() {
        booksTable = new DataTable();
        searchBox = new SearchBox();
        deleteConfirmationModalDialog = new ModalDialog();
        alertDialog = new AlertDialog();
    }

    /** ---------------------- Methods ------------------------ */
    public void inputSearchBox(String keyword) {
        searchBox.inputSearchBox(keyword);
    }

    public void clickDeleteButton() {
        booksTable.clickDeleteButton();
    }

    public void clickOkButtonOfDeleteModalDialog() {
        deleteConfirmationModalDialog.clickOkButton();
    }

    public String getTitleOfDeleteAlertDialog() {
        return alertDialog.getTitleAlertDialog();
    }

    public void acceptDeleteAlertDialog() {
        alertDialog.acceptAlertDialog();
    }
}
