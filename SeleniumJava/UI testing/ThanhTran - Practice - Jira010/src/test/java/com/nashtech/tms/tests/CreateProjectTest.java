package com.nashtech.tms.tests;

import com.nashtech.tms.pages.CreateProjectPopup;
import com.nashtech.tms.pages.LoginPage;
import com.nashtech.tms.pages.ViewProjectPage;
import com.nashtech.tms.constants.MessageConstants;
import com.nashtech.tms.pages.NavigationBar;
import com.nashtech.tms.testdatas.CreateProjectTestData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateProjectTest extends BaseTest {
    private CreateProjectPopup createProjectPopup;
    private LoginPage loginPage;
    private ViewProjectPage viewProjectPage;
    private NavigationBar navigationBar;
    private CreateProjectTestData projectTestData;

    @BeforeMethod
    public void beforeMethod() throws FileNotFoundException {
        loginPage = new LoginPage(driver);
        createProjectPopup = new CreateProjectPopup(driver);
        viewProjectPage = new ViewProjectPage(driver);
        navigationBar = new NavigationBar(driver);

        //Get test data
        projectTestData = new CreateProjectTestData("create_project_with_all_fields_test_data.json");

        //Login
        loginPage.loginWithValidAccount();
        //Open Create project popup
        navigationBar.navigateToCreateProjectPopup();
    }

    @Test(description = "Create project with all fields successfully" )
    public void createProjectWithAllFieldsSuccessfully() {
        createProjectPopup.inputProjectName(projectTestData.getProjectName());
        createProjectPopup.selectProjectType(projectTestData.getProjectType());
        createProjectPopup.selectProjectStatus(projectTestData.getProjectStatus());
        createProjectPopup.selectStartDate(projectTestData.getStartDate());
        createProjectPopup.selectEndDate(projectTestData.getEndDate());
        createProjectPopup.inputSizeDay(projectTestData.getSizeDay());
        createProjectPopup.selectLocation(projectTestData.getLocation());
        createProjectPopup.selectProjectManager(projectTestData.getProjectManager());
        createProjectPopup.selectDeliveryManager(projectTestData.getDeliveryManager());
        createProjectPopup.selectEngagementManager(projectTestData.getEngagementManager());
        createProjectPopup.inputShortDescription(projectTestData.getShortDescription());
        createProjectPopup.inputLongDescription(projectTestData.getLongDescription());
        createProjectPopup.inputTechnologies(projectTestData.getTechnologies());
        createProjectPopup.inputClientName(projectTestData.getClientName());
        createProjectPopup.selectClientIndustry(projectTestData.getClientIndustry());
        createProjectPopup.inputClientDescription(projectTestData.getClientDescription());

        createProjectPopup.clickCreateButton();

        assertThat("Verify message create project successfully",
                createProjectPopup.getCreateProjectSuccessfullyMessage(),
                equalTo(MessageConstants.EXPECTED_CREATE_PROJECT_SUCCESSFULLY_MESSAGE));

        assertThat("Verify Project Name", viewProjectPage.getProjectName(), equalTo(projectTestData.getProjectName()));
        assertThat("Verify Project Type", viewProjectPage.getProjectType(), equalTo(projectTestData.getProjectType()));
        assertThat("Verify Project Status", viewProjectPage.getProjectStatus(), equalTo(projectTestData.getProjectStatus()));
        assertThat("Verify Start Date", viewProjectPage.getStartDate(), equalTo(projectTestData.getStartDate()));
        assertThat("Verify End Date", viewProjectPage.getEndDate(), equalTo(projectTestData.getEndDate()));
        assertThat("Verify Size Day", viewProjectPage.getSizeDay(), equalTo(projectTestData.getSizeDay()));
        assertThat("Verify Location", viewProjectPage.getLocation(), equalTo(projectTestData.getLocation()));

        //Replace to ignore username: Ex: Hoang Le (pinky) -> only get Hoang Le to verify
        assertThat("Verify Project Manager", viewProjectPage.getProjectManager(),
                equalTo(projectTestData.getProjectManager().replaceAll(" \\(.*?\\) ?", "")));
        assertThat("Verify Delivery Manager", viewProjectPage.getDeliveryManager(),
                equalTo(projectTestData.getDeliveryManager().replaceAll(" \\(.*?\\) ?", "")));
        assertThat("Verify Engagement Manager", viewProjectPage.getEngagementManager(),
                equalTo(projectTestData.getEngagementManager().replaceAll(" \\(.*?\\) ?", "")));

        assertThat("Verify Short Description", viewProjectPage.getShortDescription(), equalTo(projectTestData.getShortDescription()));
        assertThat("Verify Long Description", viewProjectPage.getLongDescription(), equalTo(projectTestData.getLongDescription()));
        assertThat("Verify Technologies", viewProjectPage.getTechnologies(), equalTo(projectTestData.getTechnologies()));
        assertThat("Verify Client Name", viewProjectPage.getClientName(), equalTo(projectTestData.getClientName()));
        assertThat("Verify Client Industry", viewProjectPage.getClientIndustry(), equalTo(projectTestData.getClientIndustry()));
        assertThat("Verify Client Description", viewProjectPage.getClientDescription(), equalTo(projectTestData.getClientDescription()));
    }
}
