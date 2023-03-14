package com.demoqa.pages.shared;

import com.demoqa.pages.BasePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DataTable extends BasePage {
    /** ---------------------- Elements ------------------------ */

    /** Paging */
    private static final By BTN_NEXT_PAGE = By.xpath("//div[@class='-next']//button[text()='Next']");
    private static final By LNK_TITLE = By.xpath("//div[contains(@class,'tbody')]//div[@role='row']//a");
    private static final By BTN_DELETE = By.cssSelector("span[title='Delete']");

    /** ---------------------- Methods -----------------------*/
    public void clickNextPageBtn() {
        clickElement(BTN_NEXT_PAGE);
    }

    public boolean isNextPageBtnDisabled() {
        return Boolean.parseBoolean(getAttributeOfElement(BTN_NEXT_PAGE,"disabled"));
    }

    public void clickTitleBookLink() {
        clickElement(this.LNK_TITLE);
    }

    public void clickDeleteButton() {
        clickElement(this.BTN_DELETE);
    }

    // Define method to verify search results
    public boolean isMatchedSearchResults(String keyword) {
        while (true) {
            List<WebElement> titleOfBooks = findAllWebElements(LNK_TITLE);
            for (WebElement title : titleOfBooks) {
                if (!StringUtils.containsIgnoreCase(title.getText(), keyword)) {
                    return false;
                }
            }
            //Go to the next page
            if (!isNextPageBtnDisabled()) {
                clickNextPageBtn();
            }
            else {
                break;
            }
        }
        return true;
    }
}
