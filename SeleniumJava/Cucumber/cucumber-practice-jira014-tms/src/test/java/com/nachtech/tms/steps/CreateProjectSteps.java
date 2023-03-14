package com.nachtech.tms.steps;

import com.nachtech.tms.context.ScenarioContext;
import com.nachtech.tms.models.Project;
import com.nachtech.tms.pages.CreateProjectPopup;
import com.nachtech.tms.utils.JsonUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class CreateProjectSteps {
    CreateProjectPopup createProjectPopup = new CreateProjectPopup();
    ScenarioContext scenarioContext;

    public CreateProjectSteps(ScenarioContext context) {
        scenarioContext = context;
    }

    @When("the user fills in all project information")
    public void theUserFillsInAllProjectInformation() throws FileNotFoundException {
        //Get test data
        Project newProject = JsonUtil.covertJsonToObject(
                "create_project_with_all_fields_test_data.json", Project.class
        );

        //Add local date time to make unique Project Name
        String newProjectName = newProject.projectName + LocalDateTime.now();

        //Set context
        scenarioContext.setContext("Project Name", newProjectName);
        scenarioContext.setContext("Project Type", newProject.projectType);
        scenarioContext.setContext("Project Status", newProject.projectStatus);
        scenarioContext.setContext("Start Date", newProject.startDate);
        scenarioContext.setContext("End Date", newProject.endDate);
        scenarioContext.setContext("Size Day", newProject.sizeDay);
        scenarioContext.setContext("Location", newProject.location);
        scenarioContext.setContext("Project Manager", newProject.projectManager);
        scenarioContext.setContext("Delivery Manager", newProject.deliveryManager);
        scenarioContext.setContext("Engagement Manager", newProject.engagementManager);
        scenarioContext.setContext("Short Description", newProject.shortDescription);
        scenarioContext.setContext("Long Description", newProject.longDescription);
        scenarioContext.setContext("Technologies", newProject.technologies);
        scenarioContext.setContext("Client Name", newProject.clientName);
        scenarioContext.setContext("Client Industry", newProject.clientIndustry);
        scenarioContext.setContext("Client Description", newProject.clientDescription);

        //Input all fields
        createProjectPopup.inputProjectName(newProjectName);
        createProjectPopup.selectProjectType(newProject.projectType);
        createProjectPopup.selectProjectStatus(newProject.projectStatus);
        createProjectPopup.selectStartDate(newProject.startDate);
        createProjectPopup.selectEndDate(newProject.endDate);
        createProjectPopup.inputSizeDay(newProject.sizeDay);
        createProjectPopup.selectLocation(newProject.location);
        createProjectPopup.selectProjectManager(newProject.projectManager);
        createProjectPopup.selectDeliveryManager(newProject.deliveryManager);
        createProjectPopup.selectEngagementManager(newProject.engagementManager);
        createProjectPopup.inputShortDescription(newProject.shortDescription);
        createProjectPopup.inputLongDescription(newProject.longDescription);
        createProjectPopup.inputTechnologies(newProject.technologies);
        createProjectPopup.inputClientName(newProject.clientName);
        createProjectPopup.selectClientIndustry(newProject.clientIndustry);
        createProjectPopup.inputClientDescription(newProject.clientDescription);
    }

    @And("the user clicks Create button")
    public void theUserClicksCreateButton() {
        createProjectPopup.clickCreateButton();
    }
}
