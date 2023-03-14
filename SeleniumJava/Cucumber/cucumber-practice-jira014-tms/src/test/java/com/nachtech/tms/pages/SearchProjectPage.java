package com.nachtech.tms.pages;

import com.nachtech.tms.models.Project;
import com.nachtech.tms.utils.Pair;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;

public class SearchProjectPage extends BasePage{
    /** ---------------------- Locators of Web elements ------------------------ */
    //Search project criteria
    private static final By BTN_SEARCH_PROJECT = By.cssSelector("search-project button[ng-click='search(input)']");
    private static final By TXT_PROJECT_NAME_CRITERIA = By.cssSelector("input[ng-model='input.projectname']");
    private static final By DDL_LOCATION_CRITERIA = By.id("ddl-location");
    private static final Pair<String, String> OPT_LOCATION_LOCATOR = Pair.of("xpath", "//select[@id='ddl-location']//option[text()='%s']");
    private static final By DDL_PROJECT_TYPE_CRITERIA = By.id("ddl-projecttype");
    private static final Pair<String, String> OPT_PROJECT_TYPE_LOCATOR = Pair.of("xpath", "//select[@id='ddl-projecttype']//option[text()='%s']");

    //Search result section
    private static final Pair<String, String> LBL_COL_PROJECT_NAME_ITEM_BY_ORDER = Pair.of("xpath", "//div[@ui-view='projectsresult']//div[@id='tbl-results']//tbody//tr[%s]//td[1]//a");
    private static final Pair<String, String> LBL_COL_PROJECT_NAME_ITEM_BY_TEXT = Pair.of("xpath", "//div[@ui-view='projectsresult']//div[@id='tbl-results']//tbody//tr[1]//td[1]//a[text()='%s']");
    private static final Pair<String, String> LBL_COL_ITEM_BY_ORDER_ROW_AND_COL = Pair.of("xpath", "//div[@ui-view='projectsresult']//div[@id='tbl-results']//tbody//tr[%s]//td[%s]");
    public static final By LBL_TOTAL_RESULTS = By.cssSelector("#div-total-results label[ng-show='total_count']");
    private static final Pair<String, String> BTN_PAGE_NUMBER = Pair.of("xpath", "//ul[contains(@class,'pagination')]//a[text()='%s']");

    /** ---------------------- Methods ------------------------ */
    //Search project criteria
    /** Input element */
    public void inputProjectName(String projectName) {
        inputText(TXT_PROJECT_NAME_CRITERIA, projectName);
    }

    public void selectLocation(String location) {
        clickElement(DDL_LOCATION_CRITERIA);
        clickElement(getByLocator(OPT_LOCATION_LOCATOR,location));
    }

    public void selectProjectType(String projectType) {
        clickElement(DDL_PROJECT_TYPE_CRITERIA);
        clickElement(getByLocator(OPT_PROJECT_TYPE_LOCATOR, projectType));
    }

    /** Click element */
    public void clickSearchProjectButton() { clickElement(BTN_SEARCH_PROJECT); }

    //Wait page load new elements - wait the Project Name of the first element in the previous page change (element is invisibility)
    public void waitPageLoadResults(String projectNameOfTheFirstElement) {
        waitForInvisibilityOfElementLocated(getByLocator(LBL_COL_PROJECT_NAME_ITEM_BY_TEXT,
                projectNameOfTheFirstElement)
        );
    }

    public void clickPageNumberBtn(int pageNumber) {
        clickElement(getByLocator(BTN_PAGE_NUMBER, Integer.toString(pageNumber)));
    }

    //Search result section
    public int getTotalResults() {
        String totalResultsString = getText(LBL_TOTAL_RESULTS);
        return Integer.parseInt(totalResultsString.split(": ")[1]);
    }

    public int getToTalPages() {
        return (int) Math.ceil(getTotalResults()/ Float.parseFloat(System.getProperty("ITEMS_PER_PAGE")));
    }

    public String getValueOfColumItemAtRow(String columnName, int row) {
        switch (columnName) {
            case "Project Name":
                return getText(getByLocator(LBL_COL_PROJECT_NAME_ITEM_BY_ORDER, Integer.toString(row)));
            case "Client Name":
                return getText(getByLocator(LBL_COL_ITEM_BY_ORDER_ROW_AND_COL, Integer.toString(row), "2"));
            case "Project Type":
                return getText(getByLocator(LBL_COL_ITEM_BY_ORDER_ROW_AND_COL, Integer.toString(row), "3"));
            case "Project Status":
                return getText(getByLocator(LBL_COL_ITEM_BY_ORDER_ROW_AND_COL, Integer.toString(row), "4"));
            case "Project Manager":
                return getText(getByLocator(LBL_COL_ITEM_BY_ORDER_ROW_AND_COL, Integer.toString(row), "5"));
            case "Location":
                return getText(getByLocator(LBL_COL_ITEM_BY_ORDER_ROW_AND_COL, Integer.toString(row), "6"));
            default:
                //Navigate to View Project Page to get text of those columns
                return null;
        }
    }

    public void verifyProjectAtRowMatchesWithCriteria(Project projectCriteria, int row){
        if(projectCriteria.projectName != null) {
            assertThat("Verify Project Name",
                    getValueOfColumItemAtRow("Project Name", row),
                    containsStringIgnoringCase(projectCriteria.projectName)
            );
        }
        if(projectCriteria.projectType != null) {
            assertThat("Verify Project Type",
                    getValueOfColumItemAtRow("Project Type", row),
                    equalTo(projectCriteria.projectType)
            );
        }
        if(projectCriteria.projectStatus != null) {
            assertThat("Verify Project Status",
                    getValueOfColumItemAtRow("Project Status", row),
                    equalTo(projectCriteria.projectStatus)
            );
        }
        if(projectCriteria.location != null) {
            assertThat("Verify Location",
                    getValueOfColumItemAtRow("Location", row),
                    equalTo(projectCriteria.location)
            );
        }
        if(projectCriteria.projectManager != null) {
            assertThat("Verify Project Manager",
                    getValueOfColumItemAtRow("Project Manager", row),
                    containsStringIgnoringCase(projectCriteria.projectManager)
            );
        }
        if(projectCriteria.clientName != null) {
            assertThat("Verify Client Name",
                    getValueOfColumItemAtRow("Client Name", row),
                    containsStringIgnoringCase(projectCriteria.clientName)
            );
        }
        //Handle for the remaining cases with same way
    }

    //Verify each row in each page
    public void verifySearchResultsMatchesWithCriteria(Project projectCriteria) {
        int totalPages = getToTalPages();
        int totalResults = getTotalResults();
        int itemsPerPage = Integer.parseInt(System.getProperty("ITEMS_PER_PAGE"));
        int currentPage = 1;
        String projectNameOfTheFirstElement;

        if(totalPages == 1 && totalResults <= itemsPerPage) {
            //Verify results in each row of only page 1
            for (int i = 1; i <= totalResults; i++) { //Total items in this page = totalResults
                //Verify results in current row
                verifyProjectAtRowMatchesWithCriteria(projectCriteria, i);
            }
        } else {
            //Verify results in each page (more than 1 page)
            while (currentPage < totalPages) {
                //Verify results in each row of current page
                for (int i = 1; i <= itemsPerPage; i++) {
                    //Verify results in current row
                    verifyProjectAtRowMatchesWithCriteria(projectCriteria, i);
                    System.out.println("\n");
                }
                currentPage++;
                if(currentPage < totalPages) {
                    //Get project name of the first element in current page before navigating next page to wait
                    projectNameOfTheFirstElement = getText(getByLocator(LBL_COL_PROJECT_NAME_ITEM_BY_ORDER, "1"));
                    //Go to the next page
                    clickPageNumberBtn(currentPage);
                    //Wait page load new elements after navigating page to ensure get new data
                    waitPageLoadResults(projectNameOfTheFirstElement);

                }
            }
            //Get project name of the first element in current page before navigating next page to wait
            projectNameOfTheFirstElement = getText(getByLocator(LBL_COL_PROJECT_NAME_ITEM_BY_ORDER, "1"));
            //Go to the last page
            clickPageNumberBtn(currentPage);
            //Wait page load new elements after navigating page to ensure get new data
            waitPageLoadResults(projectNameOfTheFirstElement);

            //Verify results in the last page (Because in the last page may have total items < itemsPerPage)
            //Get total items in the last page
            int itemsInLastPage = totalResults - itemsPerPage*(currentPage - 1);
            for (int i = 1; i <= itemsInLastPage; i++) {
                //Verify results in current row
                verifyProjectAtRowMatchesWithCriteria(projectCriteria, i);
            }
        }
    }
}
