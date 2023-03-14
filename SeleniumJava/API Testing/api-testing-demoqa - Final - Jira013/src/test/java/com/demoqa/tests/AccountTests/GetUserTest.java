package com.demoqa.tests.AccountTests;

import com.demoqa.constants.UserConstants;
import com.demoqa.models.Book;
import com.demoqa.tests.BaseTest;
import com.demoqa.utils.AccountHelper;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetUserTest extends BaseTest {

    @Test
    public void getUserSuccessfully(){
        Response response = AccountHelper.getUser(BaseTest.userToken, UserConstants.USER_ID);

        assertThat(
                "Verify status code",
                response.getStatusCode(),
                equalTo(200)
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

        //Verify books
        //Get list of books
        List<Book> actualBookList = response.getBody().jsonPath().getList("books", Book.class);
        List<Book> expectedBookList = BaseTest.bookTestData.bookAlreadyInCollection;

        for (Book book : listAllBook) {
            System.out.println("Title " + book.title);
        }

        //Convert to JsonString to compare 2 list of books
        Gson gson = new Gson();
        String actualJson = gson.toJson(actualBookList);
        String expectedJson = gson.toJson(expectedBookList);

        assertThat(
                "Verify books",
                actualJson,
                equalTo(expectedJson)
        );
    }

    @Test
    public void getUserUnsuccessfullyDueToUnauthorized() {
        Response response = AccountHelper.getUser(UserConstants.USER_ID);

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
