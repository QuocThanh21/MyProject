package com.demoqa.utils.api;

import com.demoqa.constants.APIConstants;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AccountHelper {
    private static String prefixUrl = APIConstants.DEMOQA_HOST + APIConstants.DEMOQA_ACCOUNT_PREFIX;

    public static Response getAllBooksInYourCollection(String userToken, String userId) {
        String url = prefixUrl + String.format(APIConstants.ENDPOINT_GET_USER, userId);

        Map<String,String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + userToken);
        Headers headers = RequestHelper.createHeaders(map);

        Response response = RequestHelper.sendRequest(
                APIConstants.RequestType.GET,
                url,
                headers,
                "");

        return response;
    }

    public static ArrayList<String> getAllTitlesOfBooksInYourCollection(String userToken, String userId) {
        Response response = AccountHelper.getAllBooksInYourCollection(userToken, userId);
        org.json.JSONObject allBooksJsonObject = new org.json.JSONObject(response.body().asString());
        JSONArray allBooksJsonArray = allBooksJsonObject.getJSONArray("books");

        ArrayList<String> listAllTitlesOfBooksInYourCollection = new ArrayList<>();
        for (int i = 0; i < allBooksJsonArray.length(); i++) {
            listAllTitlesOfBooksInYourCollection.add(allBooksJsonArray.getJSONObject(i).getString("title"));
        }
        return listAllTitlesOfBooksInYourCollection;
    }

    public static Response generateToken(String userName, String password) {
        String url = prefixUrl + APIConstants.ENDPOINT_GENERATE_TOKEN;

        JSONObject body = new JSONObject();
        body.put("userName", userName);
        body.put("password", password);

        Response response = RequestHelper.sendRequest(
                APIConstants.RequestType.POST,
                url,
                null,
                body.toString());
        return response;
    }
}
