package com.demoqa.utils.api;

import com.demoqa.constants.APIConstants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestHelper {
    public static Response sendRequest(APIConstants.RequestType method, String url, Headers headers, Object body){
        RestAssured.baseURI = APIConstants.DEMOQA_HOST;

        if (headers == null){
            Map<String, String> map = new HashMap<>();
            headers = createHeaders(map);
        }
        RequestSpecification request = RestAssured.given()
                .contentType(ContentType.JSON)
                .headers(headers);
        Response response = getResponse(request, method, url, body);

        return response;
    }

    private static Response getResponse(RequestSpecification reqSpec, APIConstants.RequestType method, String url, Object body) {
        Response response;
        System.setProperty("com.sun.security.enableAIAcaIssuers", "true");
        switch (method){
            case POST:
                if (null == body || body.toString().isEmpty()){
                    response = reqSpec.when().post(url);
                } else {
                    response = reqSpec.body(body.toString()).when().post(url);
                }
                break;
            case PUT:
                response = reqSpec.body(body).when().put(url);
                break;
            case PATCH:
                response = reqSpec.body(body).when().patch(url);
                break;
            case DELETE:
                response = reqSpec.body(body).when().delete(url);
                break;
            case GET:
                response = reqSpec.get(url);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + method);
        }
        System.out.println(String.format("\nMethod: %s\n", method));
        System.out.println(String.format("URL: %s\n", url));
        System.out.println(String.format("The request is sent with: %s\n", body.toString()));
        System.out.println(String.format("The response is return with: \nStatus code: %s\nResponse body:", response.statusCode()));

        response.prettyPrint();
        return response;
    }

    private static Headers getHeaders() {return new Headers(new Header("Content-Type","application/json"));}

    protected static Headers createHeaders(Map<String, String> headersToAdd) {
        List<Header> headerList = new ArrayList<>();
        Headers requestHeaders = getHeaders();
        if(requestHeaders.exist()){
            for (Header requestHeader: requestHeaders) {
                headerList.add(requestHeader);
            }
        }
        for (Map.Entry<String, String> stringEntry : headersToAdd.entrySet()){
            headerList.add(new Header(stringEntry.getKey(), stringEntry.getValue()));
        }
        return new Headers(headerList);
    }
}
