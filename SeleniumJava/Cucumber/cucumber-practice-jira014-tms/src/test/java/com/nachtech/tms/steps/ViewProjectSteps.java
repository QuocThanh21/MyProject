package com.nachtech.tms.steps;

import com.nachtech.tms.context.ScenarioContext;
import com.nachtech.tms.pages.CreateProjectPopup;
import com.nachtech.tms.pages.ViewProjectPage;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ViewProjectSteps {
    ScenarioContext scenarioContext;
    CreateProjectPopup createProjectPopup = new CreateProjectPopup();
    ViewProjectPage viewProjectPage = new ViewProjectPage();

    public ViewProjectSteps(ScenarioContext context) {
        scenarioContext = context;
    }

    @Then("the successful message {string} will be displayed")
    public void theSuccessfulMessageWillBeDisplayed(String successfulMsg) {
        assertThat("Verify message create project successfully",
                createProjectPopup.getCreateProjectSuccessfullyMessage(),
                equalTo(successfulMsg)
        );
    }

    @Then("all information of the project is shown correctly")
    public void allInformationOfTheProjectIsShownCorrectly() {
        assertThat("Verify Project Name",
                viewProjectPage.getProjectName(),
                equalTo(scenarioContext.getContext("Project Name", String.class))
        );
        assertThat("Verify Project Type",
                viewProjectPage.getProjectType(),
                equalTo(scenarioContext.getContext("Project Type", String.class))
        );
        assertThat("Verify Project Status",
                viewProjectPage.getProjectStatus(),
                equalTo(scenarioContext.getContext("Project Status", String.class))
        );
        assertThat("Verify Start Date",
                viewProjectPage.getStartDate(),
                equalTo(scenarioContext.getContext("Start Date", String.class))
        );
        assertThat("Verify End Date",
                viewProjectPage.getEndDate(),
                equalTo(scenarioContext.getContext("End Date", String.class))
        );
        assertThat("Verify Size Day",
                viewProjectPage.getSizeDay(),
                equalTo(scenarioContext.getContext("Size Day", String.class))
        );
        assertThat("Verify Location",
                viewProjectPage.getLocation(),
                equalTo(scenarioContext.getContext("Location", String.class))
        );

        //Replace to ignore username: Ex: Hoang Le (pinky) -> only get Hoang Le to verify
        // Because TMS don't save username of manager in Project Information (save Hoang Le)
        //    but when selecting manager in Create Project Popup, options contain username of manager (Hoang Le (pinky))
        assertThat("Verify Project Manager",
                viewProjectPage.getProjectManager(),
                equalTo(scenarioContext.getContext("Project Manager", String.class)
                        .replaceAll(" \\(.*?\\) ?", ""))
        );
        assertThat("Verify Delivery Manager",
                viewProjectPage.getDeliveryManager(),
                equalTo(scenarioContext.getContext("Delivery Manager", String.class)
                        .replaceAll(" \\(.*?\\) ?", ""))
        );
        assertThat("Verify Engagement Manager",
                viewProjectPage.getEngagementManager(),
                equalTo(scenarioContext.getContext("Engagement Manager", String.class)
                        .replaceAll(" \\(.*?\\) ?", ""))
        );

        assertThat("Verify Short Description",
                viewProjectPage.getShortDescription(),
                equalTo(scenarioContext.getContext("Short Description", String.class))
        );
        assertThat("Verify Long Description",
                viewProjectPage.getLongDescription(),
                equalTo(scenarioContext.getContext("Long Description", String.class))
        );
        assertThat("Verify Technologies",
                viewProjectPage.getTechnologies(),
                equalTo(scenarioContext.getContext("Technologies", String.class))
        );
        assertThat("Verify Client Name",
                viewProjectPage.getClientName(),
                equalTo(scenarioContext.getContext("Client Name", String.class))
        );
        assertThat("Verify Client Industry",
                viewProjectPage.getClientIndustry(),
                equalTo(scenarioContext.getContext("Client Industry", String.class))
        );
        assertThat("Verify Client Description",
                viewProjectPage.getClientDescription(),
                equalTo(scenarioContext.getContext("Client Description", String.class))
        );
    }
}
