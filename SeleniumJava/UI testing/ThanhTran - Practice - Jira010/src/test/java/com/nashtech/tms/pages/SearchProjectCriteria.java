package com.nashtech.tms.pages;

import com.nashtech.tms.constants.locators.SearchPageLocators;
import org.openqa.selenium.WebDriver;

public class SearchProjectCriteria extends BasePage{
    /** ---------------------- Constructor ------------------------ */
    public SearchProjectCriteria(WebDriver driver) {
        super(driver);
    }

    /** ---------------------- Page Methods -----------------------*/
    /** Input element */
    public void inputProjectName(String projectName) {
        inputText(SearchPageLocators.TXT_PROJECT_NAME_CRITERIA, projectName);
    }

    public void selectLocation(String location) {
        clickElement(SearchPageLocators.DDL_LOCATION_CRITERIA);
        clickElement(SearchPageLocators.getOPT_LOCATION_LOCATOR(location));
    }

    public void selectProjectType(String projectType) {
        clickElement(SearchPageLocators.DDL_PROJECT_TYPE_CRITERIA);
        clickElement(SearchPageLocators.getOPT_PROJECT_TYPE_LOCATOR(projectType));
    }

    /** Click element */
    public void clickSearchProjectButton() { clickElement(SearchPageLocators.BTN_SEARCH_PROJECT); }

}
