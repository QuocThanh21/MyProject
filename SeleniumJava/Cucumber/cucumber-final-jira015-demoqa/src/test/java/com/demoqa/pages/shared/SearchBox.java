package com.demoqa.pages.shared;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.By;

public class SearchBox extends BasePage {
    /** ---------------------- Elements ------------------------ */
    private static final By TXT_SEARCH_BOX = By.id("searchBox");

    /** ---------------------- Methods -----------------------*/
    public void inputSearchBox(String keyword) {
        inputText(this.TXT_SEARCH_BOX, keyword);
    }
}
