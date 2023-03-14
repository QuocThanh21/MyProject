package com.nashtech.tms.pages;

import com.nashtech.tms.constants.locators.NavigationBarLocators;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends BasePage {
    /** ---------------------- Constructor ------------------------ */
    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    /** ---------------------- Page Methods -----------------------*/
    /** Get text element */
    public String getUsername(){
        return getText(NavigationBarLocators.LBL_USERNAME_IN_NAVBAR);
    }

    /** Navigate */
    public void navigateToCreateProjectPopup() {
        clickElement(NavigationBarLocators.DDL_PROJECTS_IN_NAVBAR);
        clickElement(NavigationBarLocators.OPT_CREATE_PROJECT_IN_NAVBAR);
    }

    public void navigateToSearchProjectPage() {
        clickElement(NavigationBarLocators.DDL_PROJECTS_IN_NAVBAR);
        clickElement(NavigationBarLocators.OPT_SEARCH_PROJECT_IN_NAVBAR);
    }

}
