package com.nachtech.tms.steps;

import com.nachtech.tms.context.ScenarioContext;
import com.nachtech.tms.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    ScenarioContext scenarioContext;

    public LoginSteps(ScenarioContext context) {
        scenarioContext = context;
    }

    @Given("the user visits the TMS website")
    public void theUserVisitsTheTMSWebsite() {
        loginPage.navigateToUrl(System.getProperty("LOGIN_URL"));
    }

    @When("the user inputs an account")
    public void theUserInputsAnAccount(List<Map<String, String>> table) {
        //Get data from Data table to input
        String username = table.get(0).get("username");
        String password = table.get(0).get("password");

        if(username != null) {
            loginPage.inputUsername(username);
            //Set context
            scenarioContext.setContext("username", username);
        }

        if(password != null) {
            loginPage.inputPassword(password);
        }
    }

    @And("the user clicks on Login button")
    public void theUserClicksOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the error message {string} will be displayed below username field")
    public void theErrorMessageWillBeDisplayedBelowUsernameField(String requiredFieldMsg) {
        assertThat("Verify error required username message",
                loginPage.getActualErrorRequiredUsernameMessage(), equalTo(requiredFieldMsg)
        );

    }

    @Then("the error message {string} will be displayed below password field")
    public void theErrorMessageWillBeDisplayedBelowPasswordField(String requiredFieldMsg) {
        assertThat("Verify error required password message",
                loginPage.getActualErrorRequiredPasswordMessage(), equalTo(requiredFieldMsg)
        );
    }

    @Then("the error message {string} will be displayed")
    public void theErrorMessageWillBeDisplayed(String errorMsg) {
        assertThat("Verify error incorrect username & password message",
                loginPage.getActualIncorrectAccountMessage(), equalTo(errorMsg)
        );
    }

    @Given("the user is logged into the system with valid account")
    public void theUserIsLoggedIntoTheSystemWithValidAccount(List<Map<String, String>> table) {
        String username = table.get(0).get("username");
        String password = table.get(0).get("password");

        loginPage.loginWithValidAccount(username, password);
    }
}
