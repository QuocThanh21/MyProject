package com.nashtech.tms.constants.locators;

import org.openqa.selenium.By;

public class SearchPageLocators {
    /** ---------------------- Search project criteria------------------------ */
    public static final By BTN_SEARCH_PROJECT = By.cssSelector("search-project button[ng-click='search(input)']");
    public static final By TXT_PROJECT_NAME_CRITERIA = By.cssSelector("input[ng-model='input.projectname']");
    public static final By DDL_LOCATION_CRITERIA = By.id("ddl-location");

    /** Maybe bug in here with 'final' is constant */
    public static final By getOPT_LOCATION_LOCATOR(String location) {
        return By.xpath(String.format("//select[@id='ddl-location']//option[text()='%s']", location));
    }

    public static final By DDL_PROJECT_TYPE_CRITERIA = By.id("ddl-projecttype");

    public static final By getOPT_PROJECT_TYPE_LOCATOR(String projectType) {
        return By.xpath(String.format("//select[@id='ddl-projecttype']//option[text()='%s']", projectType));
    }

    /** ---------------------- Search result section ------------------------ */
    public static By TR_PROJECT_SEARCH_RESULT = By.xpath("//div[@ui-view='projectsresult']//tbody//tr[@total-items]");
    public static final By LNK_PROJECT_NAME_SEARCH_RESULT = By.xpath(".//a[contains(@href,'/#!/project/')]");
    public static final By LBL_PROJECT_TYPE_SEARCH_RESULT = By.xpath("./td[@class='break-word ng-binding'][2]");
    public static final By LBL_LOCATION_SEARCH_RESULT = By.xpath("./td[@class='break-word ng-binding'][5]");
    public static final By LBL_TOTAL_RESULTS = By.cssSelector("#div-total-results label[ng-show='total_count']");
    public static final By BTN_NEXT_PAGE = By.xpath("//ul[contains(@class,'pagination')]//a[text()='›']");
}
