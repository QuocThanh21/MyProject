package com.nashtech.tms.tests;

import com.nashtech.tms.pages.LoginPage;
import com.nashtech.tms.pages.NavigationBar;
import com.nashtech.tms.pages.SearchProjectCriteria;
import com.nashtech.tms.pages.SearchResultSection;
import com.nashtech.tms.testdatas.SearchProjectTestData;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;


public class SearchProjectTest extends BaseTest{
    private LoginPage loginPage;
    private SearchProjectCriteria searchProjectCriteria;
    private SearchResultSection searchResultSection;
    private NavigationBar navigationBar;
    private SearchProjectTestData searchProjectTestData;

    @BeforeMethod
    public void beforeMethod() throws FileNotFoundException {
        loginPage = new LoginPage(driver);
        searchProjectCriteria = new SearchProjectCriteria(driver);
        searchResultSection = new SearchResultSection(driver);
        navigationBar = new NavigationBar(driver);

        //Get test data
        searchProjectTestData = new SearchProjectTestData("search_project_test_data.json");

        //Login
        loginPage.loginWithValidAccount();
        //Navigate to Search project
        navigationBar.navigateToSearchProjectPage();
    }

    @Test(description = "Search project with criteria (Name,Location,Type) successfully" )
    public void searchProjectWithNameLocationTypeSuccessfully() {
        searchProjectCriteria.inputProjectName(searchProjectTestData.getProjectName());
        searchProjectCriteria.selectLocation(searchProjectTestData.getLocation());
        searchProjectCriteria.selectProjectType(searchProjectTestData.getProjectType());
        searchProjectCriteria.clickSearchProjectButton();

        //Get all projects
        List<WebElement> listProjects = searchResultSection.getAllProjectResults();

        //Verify each project in Search results section
        for(WebElement project : listProjects) {
            assertThat("Verify Project Name", searchResultSection.getProjectName(project),
                    containsStringIgnoringCase(searchProjectTestData.getProjectName()));
            assertThat("Verify Location", searchResultSection.getLocation(project),
                    equalTo(searchProjectTestData.getLocation()));
            assertThat("Verify Project Type", searchResultSection.getProjectType(project),
                    equalTo(searchProjectTestData.getProjectType()));
        }
    }
}
