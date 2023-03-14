package com.demoqa.tests;

import com.demoqa.constants.MessageConstants;
import com.demoqa.constants.UrlConstants;
import com.demoqa.pages.BookDetailPage;
import com.demoqa.pages.BookStorePage;
import com.demoqa.pages.LoginPage;
import com.demoqa.pages.ProfilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.FileNotFoundException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AddBookToCollectionTest extends BaseTest {
    private BookStorePage bookStorePage;
    private BookDetailPage bookDetailPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private String expectedTitleBook = "Git Pocket Guide";

    @BeforeMethod
    public void beforeMethod() throws AWTException, FileNotFoundException {
        bookStorePage = new BookStorePage(driver);
        loginPage = new LoginPage(driver);
        bookDetailPage = new BookDetailPage(driver);
        profilePage = new ProfilePage(driver);

        //Login
        loginPage.loginWithValidAccount();
        //Zoom out browser
        bookStorePage.zoomOutBrowser(6);

        //Check book is already added to collection and shown in Profile page
        // If true, delete book from collection
        if (profilePage.haveBookInTable(expectedTitleBook)) {
            bookDetailPage.navigateToUrl(UrlConstants.PROFILE_URL);
            profilePage.inputSearchBox(expectedTitleBook);
            profilePage.clickDeleteButton();
            profilePage.clickOkButtonOfDeleteModalDialog();
            profilePage.acceptDeleteAlertDialog();
        }

        //Navigate to Book Store page
        bookStorePage.navigateToUrl(UrlConstants.BOOK_STORE_URL);
    }

    @Test(description = "Scenario 2: Add book to your collection")
    public void addBookToYourCollectionSuccessfully() {
        bookStorePage.inputSearchBox(expectedTitleBook);
        bookStorePage.clickTitleBookLink();
        bookDetailPage.clickAddToYourCollectionButton();

        String actualTitleOfAddAlertDialog = bookDetailPage.getTitleOfAddAlertDialog();
        assertThat("Verify add message in Title of Add Modal Dialog", actualTitleOfAddAlertDialog,
                equalTo(MessageConstants.ADD_BOOK_SUCCESSFULLY_MESSAGE));
        bookDetailPage.acceptAddAlertDialog();

        bookDetailPage.navigateToUrl(UrlConstants.PROFILE_URL);
        //Verify that book is shown in Profile page
        assertThat("Verify that book is shown in Profile page",
                profilePage.haveBookInTable(expectedTitleBook), is(true));
    }
}
