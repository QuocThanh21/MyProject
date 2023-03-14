package com.demoqa.utils;

import com.demoqa.constants.APIConstants;
import com.demoqa.models.Book;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookStoreHelper{
    private static String prefixUrl = APIConstants.DEMOQA_HOST + APIConstants.DEMOQA_BOOK_STORE_PREFIX;

    public static Response addBooksToCollection(String userToken, String userId, List<String> isbn) {
        String url = prefixUrl + APIConstants.ENDPOINT_ADD_BOOK_TO_COLLECTION;

        JSONObject body = new JSONObject();
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + userToken);
        Headers headers = RequestHelper.createHeaders(map);

        JSONArray collectionIsbns = new JSONArray();
        for (String id : isbn) {
            JSONObject bookId = new JSONObject();
            bookId.put("isbn", id);
            collectionIsbns.add(bookId);
        }
        body.put("userId", userId);
        body.put("collectionOfIsbns", collectionIsbns);

        Response response = RequestHelper.sendRequest(
                APIConstants.RequestType.POST,
                url,
                headers,
                body.toString());
        return response;
    }

    public Response deleteABook(String userToken, String userId, String isbn) {
        String url = prefixUrl + String.format(APIConstants.ENDPOINT_DELETE_A_BOOK_FROM_COLLECTION);

        Map<String,String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + userToken);
        Headers headers = RequestHelper.createHeaders(map);

        JSONObject body = new JSONObject();
        body.put("isbn", isbn);
        body.put("userId", userId);

        Response response = RequestHelper.sendRequest(
                APIConstants.RequestType.DELETE,
                url,
                headers,
                body.toString());
        return response;
    }

    public static Response deleteAllBooks(String userToken, String userId) {
        String url = prefixUrl + String.format(APIConstants.ENDPOINT_DELETE_ALL_BOOKS_FROM_COLLECTION, userId);

        Map<String,String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + userToken);
        Headers headers = RequestHelper.createHeaders(map);

        Response response = RequestHelper.sendRequest(
                APIConstants.RequestType.DELETE,
                url,
                headers,
                "");
        return response;
    }

    public Response replaceABook(String userToken, String userId, String currentIsbn, String newIsbn) {
        String url = prefixUrl + String.format(APIConstants.ENDPOINT_REPLACE_A_BOOK, currentIsbn);

        Map<String,String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + userToken);
        Headers headers = RequestHelper.createHeaders(map);

        JSONObject body = new JSONObject();
        body.put("isbn", newIsbn);
        body.put("userId", userId);

        Response response = RequestHelper.sendRequest(
                APIConstants.RequestType.PUT,
                url,
                headers,
                body.toString());
        return response;
    }

    public static List<Book> getAllBooksInTheSystem() {
        String url = prefixUrl + String.format(APIConstants.ENDPOINT_GET_ALL_BOOKS);

        Response response = RequestHelper.sendRequest(
                APIConstants.RequestType.GET,
                url,
                null,
                "");

        return response.jsonPath().getList("books", Book.class);
    }
}
