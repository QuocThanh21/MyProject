package com.demoqa.tests;

import com.demoqa.constants.UrlConstants;
import com.demoqa.pages.BookStorePage;
import com.demoqa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.FileNotFoundException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchBookTest extends BaseTest{
    private BookStorePage bookStorePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() throws AWTException, FileNotFoundException {
        bookStorePage = new BookStorePage(driver);
        loginPage = new LoginPage(driver);

        //Login
        loginPage.loginWithValidAccount();
        //Zoom out browser
        bookStorePage.zoomOutBrowser(6);

        //Navigate to Book Store page
        bookStorePage.navigateToUrl(UrlConstants.BOOK_STORE_URL);
    }

    @Test(description = "Scenario 3: Search book with multiple results")
    public void searchBookInYourCollectionSuccessfully() {
        String[] keywords = {"Design", "design"};
        for (String keyword : keywords ) {
            bookStorePage.inputSearchBox(keyword);

            // Verify that title of books in search results matches with search keyword
            assertThat("Verify that title of books in search results matches with search keyword",
                    bookStorePage.isMatchedSearchResults(keyword), is(true));
        }
    }
}
