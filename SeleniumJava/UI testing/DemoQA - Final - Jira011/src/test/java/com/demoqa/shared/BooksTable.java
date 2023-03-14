package com.demoqa.shared;

import com.demoqa.pages.BasePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BooksTable extends BasePage {
    /** ---------------------- Elements ------------------------ */

    /** Paging */
    private static final By BTN_NEXT_PAGE = By.xpath("//div[@class='-next']//button[text()='Next']");
    private static final By LBL_TOTAL_PAGES = By.xpath("//span[@class='-totalPages']");
    private static final By LNK_TITLE = By.xpath("//div[contains(@class,'tbody')]//div[@role='row']//a");
    private static final By BTN_DELETE = By.cssSelector("span[title='Delete']");

    /** ---------------------- Constructor ------------------------ */
    public BooksTable(WebDriver driver) {
        super(driver);
    }

    /** ---------------------- Methods -----------------------*/
    private int getTotalPages() {
        return Integer.parseInt(getText(this.LBL_TOTAL_PAGES));
    }

    //To get list title of books that matches with search keyword
    public List<WebElement> getListTitleOfBooks() {
        int totalPages = getTotalPages();
        int currentPage = 1;
        List<WebElement> titleOfBooks = new ArrayList<WebElement>();

        try {
            titleOfBooks = findAllWebElements(this.LNK_TITLE);
        } catch (Exception e) {
            return titleOfBooks;
        }

        //Get data
        while (currentPage < totalPages) {
            //Go to the next page
            clickElement(this.BTN_NEXT_PAGE);
            currentPage++;

            //Get and all attribute of books in this page to list
            titleOfBooks.addAll(findAllWebElements(this.LNK_TITLE));
        }
        return titleOfBooks;
    }

    public void clickTitleBookLink() {
        clickElement(this.LNK_TITLE);
    }

    public void clickDeleteButton() {
        clickElement(this.BTN_DELETE);
    }

    //  Define method to verify whether book is found in table
    public boolean haveBookInTable(String titleBook) {
        if (getListTitleOfBooks().isEmpty()) {
            return false;
        }
        else {
            for (WebElement title : getListTitleOfBooks()) {
                if (StringUtils.containsIgnoreCase(title.getText(), titleBook)) { // book is still in table
                    return true;
                }
            }
        }
        return false;
    }

    // Define method to verify search results
    public boolean isMatchedSearchResults(String keyword) {
        if (getListTitleOfBooks().isEmpty()) {
            return false;
        }
        else {
            for (WebElement title : getListTitleOfBooks()) {
                if (!StringUtils.containsIgnoreCase(title.getText(),keyword)) {
                    return false;
                }
            }
        }
        return true;
    }
}
