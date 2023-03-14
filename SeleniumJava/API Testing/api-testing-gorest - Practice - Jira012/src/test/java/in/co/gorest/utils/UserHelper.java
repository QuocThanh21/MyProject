package in.co.gorest.utils;

import in.co.gorest.constants.APIConstants;
import in.co.gorest.testdatas.UserData;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

//RequestHelper giống thư viện nên k nên xài extends mà nên bỏ biến vô xài
public class UserHelper extends RequestHelper{
    private String prefixURL = APIConstants.HOST + APIConstants.USER_PREFIX;
    private UserData userData = new UserData();

    public Response createNewUser(UserData userData) {
        String url = prefixURL;

        //Nên thêm get token vào phần create header để tránh duplicated
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + APIConstants.TOKEN);
        Headers headers = createHeaders(map);

        JSONObject body = new JSONObject();
        body.put("name", userData.getName());
        body.put("email", userData.getEmail());
        body.put("gender", userData.getGender());
        body.put("status", userData.getStatus());

        Response response = sendRequest(
                APIConstants.RequestType.POST,
                url,
                headers,
                body.toString());
        return response;
    }

    public Response getUsers(String page) {
        //By default, it will retrieve users in page 1 if page is blank
        String url = prefixURL;

        //It will retrieve users in exactly page 1 if page is not blank
        if (!page.isBlank()) {
            url += String.format(APIConstants.GET_USERS_ENDPOINT, page);
        }

        Response response = sendRequest(
                APIConstants.RequestType.GET,
                url,
                null,
                "");
        return response;
    }

    public Response getUserDetails(String userId) {
        String url = prefixURL + String.format(APIConstants.USER_ID_ENDPOINT, userId);

        Map<String ,String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + APIConstants.TOKEN);
        Headers headers = createHeaders(map);

        Response response = sendRequest(
                APIConstants.RequestType.GET,
                url,
                headers,
                "");
        return response;
    }

    public Response updateUserDetails(String userId, UserData userData) {
        String url = prefixURL + String.format(APIConstants.USER_ID_ENDPOINT, userId);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + APIConstants.TOKEN);
        Headers headers = createHeaders(map);

        JSONObject body = new JSONObject();
        body.put("name", userData.getName());
        body.put("email", userData.getEmail());
        body.put("gender", userData.getGender());
        body.put("status", userData.getStatus());

        Response response = sendRequest(
                APIConstants.RequestType.PUT,
                url,
                headers,
                body.toString());
        return response;
    }

    public Response deleteUser(String userId) {
        String url = prefixURL + String.format(APIConstants.USER_ID_ENDPOINT, userId);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", "Bearer " + APIConstants.TOKEN);
        Headers headers = createHeaders(map);

        Response response = sendRequest(
                APIConstants.RequestType.DELETE,
                url,
                headers,
                "");
        return response;
    }

    public void verifyUpdateUserWithSchema(Response response, String path) {
        verifySchema(response, path);
    }
}
