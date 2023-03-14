package com.nashtech.tms.constants.locators;

import org.openqa.selenium.By;

public class NavigationBarLocators {
    public static final By LBL_USERNAME_IN_NAVBAR = By.xpath("//img[@id='ava']/..");
    public static final By DDL_PROJECTS_IN_NAVBAR = By.xpath("//a[@data-target='#modalCreateProject']/ancestor::ul/preceding-sibling::a");
    public static final By OPT_CREATE_PROJECT_IN_NAVBAR = By.xpath("//a[@data-target='#modalCreateProject']");
    public static final By OPT_SEARCH_PROJECT_IN_NAVBAR = By.xpath("//a[@data-target='#modalCreateProject']/../following-sibling::li/child::a");
}
