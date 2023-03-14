package com.demoqa.utils;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import com.demoqa.constants.APIConstants;
import java.util.HashMap;
import java.util.Map;

public class AccountHelper{
    private static String prefixUrl = APIConstants.DEMOQA_HOST + APIConstants.DEMOQA_ACCOUNT_PREFIX;

    public static Response getUser(String userToken, String userId) {
        String url = prefixUrl + String.format(APIConstants.ENDPOINT_GET_USER, userId);

        //Nên thêm get token vào phần create header để tránh duplicated
        Map<String,String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + userToken);
        Headers headers = RequestHelper.createHeaders(map);

        Response response = RequestHelper.sendRequest(
                APIConstants.RequestType.GET,
                url,
                headers, "");
        return response;
    }

    public static Response getUser(String userId) {
        String url = prefixUrl + String.format(APIConstants.ENDPOINT_GET_USER, userId);

        Response response = RequestHelper.sendRequest(
                APIConstants.RequestType.GET,
                url,
                null,
                "");
        return response;
    }

    public Response createUser(String username, String password) {
        String url = prefixUrl + APIConstants.ENDPOINT_CREATE_USER;

        JSONObject body = new JSONObject();
        body.put("userName", username);
        body.put("password", password);

        Response response = RequestHelper.sendRequest(
                APIConstants.RequestType.POST,
                url,
                null,
                body.toString());
        return response;
    }

    public static String generateToken(String userName, String password) {
        String url = prefixUrl + APIConstants.ENDPOINT_GENERATE_TOKEN;

        JSONObject body = new JSONObject();
        body.put("userName", userName);
        body.put("password", password);

        Response response = RequestHelper.sendRequest(
                APIConstants.RequestType.POST,
                url,
                null,
                body.toString());
        return response.jsonPath().getString("token");
    }
}
