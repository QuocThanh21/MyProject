package com.demoqa.tests.BookStoreTests;

import com.demoqa.constants.APIConstants;
import com.demoqa.constants.UserConstants;
import com.demoqa.models.Book;
import com.demoqa.tests.BaseTest;
import com.demoqa.utils.BookStoreHelper;
import com.demoqa.utils.RequestHelper;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReplaceBookTest extends BaseTest{
    BookStoreHelper bookstoreHelper = new BookStoreHelper();

    @Test
    public void replaceABookInCollectionAndVerifyJsonSchemaSuccessfully() {
        //replace 'Git Pocket Guide' book
        //   with 'Designing Evolvable Web APIs with ASP.NET' book (defined in book_test_data.json)
        String currentIsbn = BaseTest.bookTestData.isbnOfBookIsReplaced;
        String replaceIsbn = BaseTest.bookTestData.bookToReplace.isbn;

        Response response = bookstoreHelper.replaceABook(
                BaseTest.userToken,
                UserConstants.USER_ID,
                currentIsbn,
                replaceIsbn
        );

        assertThat(
                "Verify body: userId",
                response.getBody().jsonPath().get("userId"),
                equalTo(UserConstants.USER_ID)
        );
        assertThat(
                "Verify body: username",
                response.getBody().jsonPath().get("username"),
                equalTo(UserConstants.USER_NAME)
        );

        //Verify book
        //Get list of books
        List<Book> actualBookList = response.jsonPath().getList("books", Book.class);
        //Replaced book is added to the last of list books in collection
        Book actualBook = actualBookList.get(actualBookList.size()-1);
        Book expectedBook = BaseTest.bookTestData.bookToReplace;

        //Convert to JsonString to compare 2 books
        Gson gson = new Gson();
        String actualJson = gson.toJson(actualBook);
        String expectedJson = gson.toJson(expectedBook);

        assertThat(
                "Verify books",
                actualJson,
                equalTo(expectedJson)
        );

        //Verify the JSON SCHEMA of the response body
        RequestHelper.verifySchema(response, "replace_book_schema.json");
    }

    @Test
    public void replaceABookInCollectionUnsuccessfullyDueToUnexistingIsbn() {
        String currentIsbn = BaseTest.bookTestData.isbnOfBookIsReplaced;
        String replaceIsbn = APIConstants.UNEXISTING_ISBN;

        Response response = bookstoreHelper.replaceABook(
                BaseTest.userToken,
                UserConstants.USER_ID,
                currentIsbn,
                replaceIsbn
        );

        assertThat(
                "Verify status code",
                response.getStatusCode(),
                equalTo(400)
        );
        assertThat(
                "Verify body: code",
                response.getBody().jsonPath().get("code"),
                equalTo("1205")
        );
        assertThat(
                "Verify body: message",
                response.getBody().jsonPath().get("message"),
                equalTo("ISBN supplied is not available in Books Collection!")
        );
    }


    @Test
    public void replaceABBookInCollectionUnsuccessfullyDueToUnauthorized() {
        String currentIsbn = BaseTest.bookTestData.isbnOfBookIsReplaced;
        String replaceIsbn = BaseTest.bookTestData.bookToReplace.isbn;

        Response response = bookstoreHelper.replaceABook(
                APIConstants.WRONG_TOKEN,
                UserConstants.USER_ID,
                currentIsbn,
                replaceIsbn
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
}
