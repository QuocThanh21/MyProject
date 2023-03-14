package com.demoqa.pages;

import com.demoqa.shared.BooksTable;
import com.demoqa.shared.SearchBox;
import org.openqa.selenium.WebDriver;

public class BookStorePage extends BasePage{
    private BooksTable booksTable;
    private SearchBox searchBox;

    /** ---------------------- Constructor ------------------------ */
    public BookStorePage(WebDriver driver) {
        super(driver);
        booksTable = new BooksTable(driver);
        searchBox = new SearchBox(driver);
    }

    /** ---------------------- Methods ------------------------ */
    public void inputSearchBox(String keyword) {
        searchBox.inputSearchBox(keyword);
    }

    // Define method to verify that title of books in search results matches with search keyword
    public boolean isMatchedSearchResults(String keyword) {
        return booksTable.isMatchedSearchResults(keyword);
    }

    public void clickTitleBookLink() {
        booksTable.clickTitleBookLink();
    }
}
