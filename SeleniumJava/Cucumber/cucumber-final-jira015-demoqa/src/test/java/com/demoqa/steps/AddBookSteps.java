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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AddBookSteps {
    private BookStorePage bookStorePage = new BookStorePage();
    private BookDetailPage bookDetailPage = new BookDetailPage();
    private LoginPage loginPage = new LoginPage();
    private ProfilePage profilePage = new ProfilePage();
    ScenarioContext scenarioContext;

    public AddBookSteps(ScenarioContext context) {
        scenarioContext = context;
    }

    @Given("Book {string} is not in your collection")
    public void bookIsNotInYourCollection(String nameOfBook) {
        //Find isbn of book
        String isbnOfBook = BookStoreHelper.getIsbnsOfBooks(nameOfBook);

        //Send request delete book from your collection
        BookStoreHelper.deleteABook(StepHooks.userToken, APIConstants.USER_ID, isbnOfBook);
    }

    @Given("the user logs into application")
    public void theUserLogsIntoApplication() {
        loginPage.loginWithValidAccount(APIConstants.USER_ID, System.getProperty("USERNAME"), StepHooks.userToken, StepHooks.expires);
    }

    @And("the user is on Book Store page")
    public void theUserIsOnBookStorePage() {
        bookStorePage.navigateToUrl(UrlConstants.BOOK_STORE_URL);
    }

    @When("the user selects a book {string}")
    public void theUserSelectsABook(String nameOfBook) {
        scenarioContext.setContext("Name of Book", nameOfBook);
        bookStorePage.inputSearchBox(nameOfBook);
        bookStorePage.clickTitleBookLink();
    }

    @And("the user clicks on Add To Your Collection")
    public void theUserClicksOnAddToYourCollection() {
        bookDetailPage.clickAddToYourCollectionButton();
    }

    @Then("an alert {string} is shown")
    public void anAlertIsShown(String addBookSuccessfullyMsg) {
        String actualTitleOfAddAlertDialog = bookDetailPage.getTitleOfAddAlertDialog();
        assertThat(
                "Verify add message in Title of Add Modal Dialog",
                actualTitleOfAddAlertDialog,
                equalTo(addBookSuccessfullyMsg)
        );
        bookDetailPage.acceptAddAlertDialog();
    }

    @And("book is shown in your profile")
    public void bookIsShownInYourProfile() {
        bookDetailPage.navigateToUrl(UrlConstants.PROFILE_URL);
        //Verify that book is shown in Profile page with API
        ArrayList<String> listAllTitlesOfBooksInYourCollection = AccountHelper.getAllTitlesOfBooksInYourCollection(StepHooks.userToken, APIConstants.USER_ID);

        assertThat(
                "Verify that book is shown in Profile page",
                bookStorePage.isBookInListTitlesOfBooks(listAllTitlesOfBooksInYourCollection, scenarioContext.getContext("Name of Book", String.class)),
                is(true)
        );
    }
}
