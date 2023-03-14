package com.nachtech.tms.steps;

import com.nachtech.tms.context.ScenarioContext;
import com.nachtech.tms.models.Project;
import com.nachtech.tms.pages.SearchProjectPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;

public class SearchProjectSteps {
    SearchProjectPage searchProjectPage = new SearchProjectPage();
    ScenarioContext scenarioContext;

    public SearchProjectSteps(ScenarioContext context) { scenarioContext = context; }

    @When("the user applies some search criteria")
    public void theUserAppliesSomeSearchCriteria(List<Map<String, String>> table) {
        //Get data from Data table to input
        Project projectCriteria = new Project();
        projectCriteria.setProjectName(table.get(0).get("Project Name"));
        projectCriteria.setLocation(table.get(0).get("Location"));
        projectCriteria.setProjectType(table.get(0).get("Project Type"));

        //Set context
        scenarioContext.setContext("Project Criteria", projectCriteria);

        //Input criteria
        searchProjectPage.inputProjectName(projectCriteria.projectName);
        searchProjectPage.selectLocation(projectCriteria.location);
        searchProjectPage.selectProjectType(projectCriteria.projectType);
    }

    @And("the user clicks on Search button")
    public void theUserClicksOnSearchButton() {
        searchProjectPage.clickSearchProjectButton();
    }

    @Then("all projects matched with input criteria will be displayed")
    public void allProjectsMatchedWithInputCriteriaWillBeDisplayed() {
        //Get context to verify
        Project projectCriteria = scenarioContext.getContext("Project Criteria", Project.class);

        //Verify search results
        searchProjectPage.verifySearchResultsMatchesWithCriteria(projectCriteria);
    }
}
