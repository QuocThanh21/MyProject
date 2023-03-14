package com.nashtech.tms.pages;

import com.nashtech.tms.constants.locators.SearchPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultSection extends BasePage{
    /** ---------------------- Constructor ------------------------ */
    public SearchResultSection(WebDriver driver) {
        super(driver);
    }

    /** ---------------------- Page Methods -----------------------*/
    /** Get text element */
    public String getProjectName(WebElement project) {
        return getText(project.findElement(SearchPageLocators.LNK_PROJECT_NAME_SEARCH_RESULT));
    }

    public String getProjectType(WebElement project) {
        return getText(project.findElement(SearchPageLocators.LBL_PROJECT_TYPE_SEARCH_RESULT));
    }

    public String getLocation(WebElement project) {
        return getText(project.findElement(SearchPageLocators.LBL_LOCATION_SEARCH_RESULT));
    }

    public int getTotalResults() {
        String totalResultsString = getText(SearchPageLocators.LBL_TOTAL_RESULTS);
        return Integer.parseInt(totalResultsString.split(": ")[1]);
    }

    /** Get all project results */
    public List<WebElement> getAllProjectResults() {
        int totalResults = getTotalResults();
        int totalPages = (int) Math.ceil(totalResults/ Float.parseFloat(System.getProperty("ITEMS_PER_PAGE")));
        int currentPage = 1;
        List<WebElement> listProjects;

        //Add all projects in the first page into listProject
        listProjects = findAllWebElements(SearchPageLocators.TR_PROJECT_SEARCH_RESULT);

        while (currentPage < totalPages) {
            //Go to the next page
            clickElement(SearchPageLocators.BTN_NEXT_PAGE);
            currentPage++;

            //Add all projects in the next page into listProject
            listProjects.addAll(findAllWebElements(SearchPageLocators.TR_PROJECT_SEARCH_RESULT));
        };
        return listProjects;
    }
}
