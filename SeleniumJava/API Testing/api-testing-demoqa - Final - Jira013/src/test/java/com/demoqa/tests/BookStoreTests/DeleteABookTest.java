package com.demoqa.tests.BookStoreTests;

import com.demoqa.constants.APIConstants;
import com.demoqa.constants.UserConstants;
import com.demoqa.tests.BaseTest;
import com.demoqa.utils.BookStoreHelper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteABookTest extends BaseTest {
    BookStoreHelper bookstoreHelper = new BookStoreHelper();

    @Test
    public void deleteABookFromCollectionSuccessfully() {
        //delete 'Speaking JavaScript' book (defined in book_test_data.json)

        Response response = bookstoreHelper.deleteABook(
                BaseTest.userToken,
                UserConstants.USER_ID,
                BaseTest.bookTestData.isbnOfBookToDelete
        );

        assertThat(
                "Verify status code",
                response.getStatusCode(),
                equalTo(204)
        );
    }

    @Test
    public void deleteABookFromCollectionUnsuccessfullyDueToWrongToken() {
        //delete 'Speaking JavaScript' book (defined in book_test_data.json)

        Response response = bookstoreHelper.deleteABook(
                APIConstants.WRONG_TOKEN,
                UserConstants.USER_ID,
                BaseTest.bookTestData.isbnOfBookToDelete
        );

        assertThat(
                "Verify status code",
                response.getStatusCode(),
                equalTo(401)
        );
        assertThat(
                "Verify body: code",
                response.getBody().jsonPath().get("code"),
                equalTo("1200")
        );
        assertThat(
                "Verify body: message",
                response.getBody().jsonPath().get("message"),
                equalTo("User not authorized!")
        );
    }

    @Test
    public void deleteABookFromCollectionUnsuccessfullyDueToUnexistingIsbn() {
        Response response = bookstoreHelper.deleteABook(

                BaseTest.userToken,
                UserConstants.USER_ID,
                APIConstants.UNEXISTING_ISBN
        );

        assertThat(
                "Verify status code",
                response.getStatusCode(),
                equalTo(400)
        );
        assertThat(
                "Verify body: code",
                response.getBody().jsonPath().get("code"),
                equalTo("1206")
        );
        assertThat(
                "Verify body: message",
                response.getBody().jsonPath().get("message"),
                equalTo("ISBN supplied is not available in User's Collection!")
        );
    }
}
