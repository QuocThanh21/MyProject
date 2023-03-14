package com.demoqa.tests.BookStoreTests;

import com.demoqa.constants.UserConstants;
import com.demoqa.tests.BaseTest;
import com.demoqa.utils.BookStoreHelper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddBookTest extends BaseTest{
    BookStoreHelper bookstoreHelper = new BookStoreHelper();

    @Test
    public void addNewBookToCollectionSuccessfully() {
        //add 'Learning JavaScript Design Patterns', 'Understanding ECMAScript' book (defined in book_test_data.json)

        Response response = bookstoreHelper.addBooksToCollection(
                BaseTest.userToken,
                UserConstants.USER_ID,
                bookTestData.isbnListOfBookToAdd
        );

        assertThat(
                "Verify status code",
                response.getStatusCode(),
                equalTo(201)
        );

        //Verify list isbn of book
        //Get list of books
        List<String> actualIsbnList = response.jsonPath().getList("books.isbn", String.class);

        assertThat(
                "Verify body: books.isbn",
                actualIsbnList,
                equalTo(bookTestData.isbnListOfBookToAdd)
        );
    }

    @Test
    public void addNewBookToCollectionUnsuccessfullyDueToMissingIsbn() {
        List<String> nullList = Collections.singletonList((""));

        Response response = bookstoreHelper.addBooksToCollection(
                BaseTest.userToken,
                UserConstants.USER_ID,
                nullList
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
    public void addNewBookToCollectionUnsuccessfullyDueToExistingBook() {
        //Add again a book already existing in collection (add again Speaking JavaScript book)
        List<String> isbnOfAddedBookList = new ArrayList<>(Collections.singleton(BaseTest.bookTestData.bookAlreadyInCollection.get(1).isbn));

        Response response = bookstoreHelper.addBooksToCollection(
                BaseTest.userToken,
                UserConstants.USER_ID,
                isbnOfAddedBookList
        );

        assertThat(
                "Verify status code",
                response.getStatusCode(),
                equalTo(400)
        );
        assertThat(
                "Verify body: code",
                response.getBody().jsonPath().get("code"),
                equalTo("1210")
        );
        assertThat(
                "Verify body: message",
                response.getBody().jsonPath().get("message"),
                equalTo("ISBN already present in the User's Collection!")
        );
    }

    @Test
    public void addNewBookToCollectionUnsuccessfullyDueToIncorrectUserId() {
        //add 'Learning JavaScript Design Patterns', 'Understanding ECMAScript' book (defined in book_test_data.json)

        Response response = bookstoreHelper.addBooksToCollection(
                BaseTest.userToken,
                UserConstants.INCORRECT_USER_ID,
                bookTestData.isbnListOfBookToAdd
        );

        assertThat(
                "Verify status code",
                response.getStatusCode(),
                equalTo(401)
        );
        assertThat(
                "Verify body: code",
                response.getBody().jsonPath().get("code"),
                equalTo("1207")
        );
        assertThat(
                "Verify body: message",
                response.getBody().jsonPath().get("message"),
                equalTo("User Id not correct!")
        );
    }
}
