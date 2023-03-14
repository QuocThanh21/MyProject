package com.demoqa.shared;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage {
    /** ---------------------- Elements ------------------------ */
    private static final By TXT_SEARCH_BOX = By.id("searchBox");

    /**  ---------------------- Constructor ------------------------ */
    public SearchBox(WebDriver driver) {
        super(driver);
    }

    /** ---------------------- Methods -----------------------*/
    public void inputSearchBox(String keyword) {
        inputText(this.TXT_SEARCH_BOX, keyword);
    }
}
