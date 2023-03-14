package com.nachtech.tms.steps;

import com.nachtech.tms.context.ScenarioContext;
import com.nachtech.tms.pages.NavigationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NavigationSteps {
    NavigationPage navigationPage = new NavigationPage();
    ScenarioContext scenarioContext;

    public NavigationSteps(ScenarioContext context) {
        scenarioContext = context;
    }

    @Then("the user is logged into the system successfully")
    public void theUsernameIsDisplayedCorrectly() {
        String expectedUsername = scenarioContext.getContext("username", String.class);
        assertThat("Verify username",
                navigationPage.getUsername(), equalTo(expectedUsername)
        );
    }

    @And("the user navigate to Create Project page")
    public void theUserNavigateToCreateProjectPage() {
        navigationPage.navigateToCreateProjectPopup();
    }

    @And("the user navigate the Search Project page")
    public void theUserNavigateTheSearchProjectPage() {
        navigationPage.navigateToSearchProjectPage();
    }
}
