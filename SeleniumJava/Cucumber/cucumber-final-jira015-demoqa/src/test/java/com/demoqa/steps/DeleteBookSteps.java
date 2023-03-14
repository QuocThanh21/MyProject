package com.demoqa.steps;

import com.demoqa.constants.APIConstants;
import com.demoqa.constants.UrlConstants;
import com.demoqa.context.ScenarioContext;
import com.demoqa.pages.BookDetailPage;
import com.demoqa.pages.BookStorePage;
import com.demoqa.pages.LoginPage;
import com.demoqa.pages.ProfilePage;
import com.demoqa.utils.api.AccountHelper;
import com.demoqa.utils.api.BookStoreHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DeleteBookSteps {
    private ProfilePage profilePage = new ProfilePage();
    private LoginPage loginPage = new LoginPage();
    private BookStorePage bookStorePage = new BookStorePage();
    private BookDetailPage bookDetailPage = new BookDetailPage();
    ScenarioContext scenarioContext;

    public DeleteBookSteps(ScenarioContext context) {
        scenarioContext = context;
    }

    @Given("there is a book named {string} in your collection")
    public void thereIsABookNamedInYourCollection(String nameOfBook) {
        ArrayList<String> listIsbns = new ArrayList<>();
        listIsbns.add(BookStoreHelper.getIsbnsOfBooks(nameOfBook));

        //Send request add book to your collection
        BookStoreHelper.addBooksToCollection(StepHooks.userToken, APIConstants.USER_ID, listIsbns);
    }

    @And("the user logs into the application")
    public void theUserLogsIntoTheApplication() {
        loginPage.loginWithValidAccount(APIConstants.USER_ID, System.getProperty("USERNAME"), StepHooks.userToken, StepHooks.expires);
    }

    @And("the user is on the Profile page")
    public void theUserIsOnTheProfilePage() {
        profilePage.navigateToUrl(UrlConstants.PROFILE_URL);
    }

    @When("the user search book {string}")
    public void theUserSearchBook(String nameOfBook) {
        profilePage.inputSearchBox(nameOfBook);
        scenarioContext.setContext("Name of Book", nameOfBook);
    }

    @And("the user clicks on Delete icon")
    public void theUserClicksOnDeleteIcon() {
        profilePage.clickDeleteButton();
    }

    @And("the user clicks on OK button")
    public void theUserClicksOnOKButton() {
        profilePage.clickOkButtonOfDeleteModalDialog();
    }

    @And("the user clicks on OK button of alert {string}")
    public void theUserClicksOnOKButtonOfAlert(String deleteBookSuccessfullyMsg) {
        String actualTitleOfDeleteAlertDialog = profilePage.getTitleOfDeleteAlertDialog();
        assertThat(
                "Verify delete message in Title of Delete Alert Dialog",
                actualTitleOfDeleteAlertDialog,
                equalTo(deleteBookSuccessfullyMsg)
        );

        profilePage.acceptDeleteAlertDialog();
    }

    @And("the book is not shown")
    public void theBookIsNotShown() {
        //Verify that book is not shown in Profile page
        bookDetailPage.navigateToUrl(UrlConstants.PROFILE_URL);

        ArrayList<String> listAllTitlesOfBooksInYourCollection = AccountHelper.getAllTitlesOfBooksInYourCollection(StepHooks.userToken, APIConstants.USER_ID);

        assertThat(
                "Verify that book is shown in Profile page",
                bookStorePage.isBookInListTitlesOfBooks(listAllTitlesOfBooksInYourCollection, scenarioContext.getContext("Name of Book", String.class)),
                is(false)
        );
    }
}
