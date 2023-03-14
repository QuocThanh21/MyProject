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

public class DeleteBookTest extends BaseTest{
    private ProfilePage profilePage;
    private LoginPage loginPage;
    private BookStorePage bookStorePage;
    private BookDetailPage bookDetailPage;
    private String expectedTitleBook = "Git Pocket Guide";

    @BeforeMethod
    public void beforeMethod() throws AWTException, FileNotFoundException {
        profilePage = new ProfilePage(driver);
        loginPage = new LoginPage(driver);
        bookStorePage = new BookStorePage(driver);
        bookDetailPage = new BookDetailPage(driver);

        //Login
        loginPage.loginWithValidAccount();
        //Zoom out browser
        bookStorePage.zoomOutBrowser(6);

        //Check book isn't added and shown in Profile page
        // If true, add book in to your collection
        if (!profilePage.haveBookInTable(expectedTitleBook)) {
            profilePage.navigateToUrl(UrlConstants.BOOK_STORE_URL);
            bookStorePage.inputSearchBox(expectedTitleBook);
            bookStorePage.clickTitleBookLink();
            bookDetailPage.clickAddToYourCollectionButton();
            bookDetailPage.acceptAddAlertDialog();
        }

        //Navigate to Book Store page
        profilePage.navigateToUrl(UrlConstants.PROFILE_URL);
    }

    @Test(description = "Scenario 4: Delete book successfully")
    public void deleteBookInYourCollectionSuccessfully() {
        profilePage.inputSearchBox(expectedTitleBook);
        profilePage.clickDeleteButton();
        profilePage.clickOkButtonOfDeleteModalDialog();

        String actualTitleOfDeleteAlertDialog = profilePage.getTitleOfDeleteAlertDialog();
        assertThat("Verify delete message in Title of Delete Alert Dialog", actualTitleOfDeleteAlertDialog,
                equalTo(MessageConstants.DELETE_SUCCESSFULLY_MESSAGE));
        profilePage.acceptDeleteAlertDialog();

        bookDetailPage.navigateToUrl(UrlConstants.PROFILE_URL);
        //Verify that book is not shown in Profile page
        assertThat("Verify that book is not shown in Profile page",
                profilePage.haveBookInTable(expectedTitleBook), is(false));
    }
}
