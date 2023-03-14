package com.nachtech.tms.pages;

import org.openqa.selenium.By;

public class NavigationPage extends BasePage{
    /** ---------------------- Locators of Web elements ------------------------ */
    public static final By LBL_USERNAME_IN_NAVBAR = By.xpath("//img[@id='ava']/..");
    public static final By DDL_PROJECTS_IN_NAVBAR = By.xpath("//a[@data-target='#modalCreateProject']/ancestor::ul/preceding-sibling::a");
    public static final By OPT_CREATE_PROJECT_IN_NAVBAR = By.xpath("//a[@data-target='#modalCreateProject']");
    public static final By OPT_SEARCH_PROJECT_IN_NAVBAR = By.xpath("//a[@data-target='#modalCreateProject']/../following-sibling::li/child::a");

    /** ---------------------- Methods ------------------------ */
    public String getUsername() {
        return getText(LBL_USERNAME_IN_NAVBAR);
    }

    public void navigateToCreateProjectPopup() {
        clickElement(DDL_PROJECTS_IN_NAVBAR);
        clickElement(OPT_CREATE_PROJECT_IN_NAVBAR);
    }
    public void navigateToSearchProjectPage() {
        clickElement(DDL_PROJECTS_IN_NAVBAR);
        clickElement(OPT_SEARCH_PROJECT_IN_NAVBAR);
    }
}
