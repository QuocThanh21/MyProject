package com.demoqa.tests;

import com.demoqa.models.Book;
import com.demoqa.testdatas.BookTestData;
import com.demoqa.constants.UserConstants;
import com.demoqa.utils.AccountHelper;
import com.demoqa.utils.BookStoreHelper;
import com.demoqa.utils.JsonUtil;
import com.google.gson.Gson;
import org.testng.annotations.BeforeTest;
import java.io.FileNotFoundException;
import java.util.List;

public class BaseTest {
    public static String userToken;
    public static BookTestData bookTestData;
    public static List<Book> listAllBook;

    @BeforeTest
    public void beforeTest() throws FileNotFoundException {
        //Get token
        userToken = AccountHelper.generateToken(UserConstants.USER_NAME, UserConstants.PASSWORD);

        //Get test data
        Gson gson = new Gson();
        bookTestData = gson.fromJson(JsonUtil.readJsonFile("book_test_data.json"), BookTestData.class);

        listAllBook = BookStoreHelper.getAllBooksInTheSystem();

        /** Make pre-condition */
        //Delete all books in collection
        BookStoreHelper.deleteAllBooks(userToken, UserConstants.USER_ID);

        //Add all books in bookAlreadyInCollection into collection
        // Add 'Git Pocket Guide'; 'Speaking JavaScript'; 'Eloquent JavaScript, Second Edition' book (defined in book_test_data.json)
        BookStoreHelper.addBooksToCollection(
                userToken,
                UserConstants.USER_ID,
                bookTestData.getIsbnListOfBookAlreadyInCollection()
        );
    }
}
