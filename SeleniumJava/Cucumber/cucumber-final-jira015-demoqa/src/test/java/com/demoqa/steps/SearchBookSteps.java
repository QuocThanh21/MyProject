package com.demoqa.steps;

import com.demoqa.constants.UrlConstants;
import com.demoqa.context.ScenarioContext;
import com.demoqa.pages.BookStorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchBookSteps {
    private BookStorePage bookStorePage = new BookStorePage();
    ScenarioContext scenarioContext;

    public SearchBookSteps(ScenarioContext context) {
        scenarioContext = context;
    }

    @Given("the user is on the Book Store page")
    public void theUserIsOnTheBookStorePage() {
        bookStorePage.navigateToUrl(UrlConstants.BOOK_STORE_URL);
    }

    @When("^the user inputs book name (.*)$")
    public void theUserInputsBookNameKeyword(String keyword) {
        bookStorePage.inputSearchBox(keyword);
        scenarioContext.setContext("keyword", keyword);
    }

    @Then("all books match with input criteria will be displayed.")
    public void allBooksMatchWithInputCriteriaWillBeDisplayed() {
        // Verify that title of books in search results matches with search keyword
        assertThat("Verify that title of books in search results matches with search keyword",
                bookStorePage.isMatchedSearchResults(scenarioContext.getContext("keyword", String.class)), is(true));

    }
}
