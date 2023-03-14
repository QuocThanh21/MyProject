package in.co.gorest.constants;

public class APIConstants {

    public enum RequestType {
        POST,
        PUT,
        PATCH,
        DELETE,
        GET
    }

    public static final String HOST = "https://gorest.co.in";
    public static final String TOKEN = "c0cbf883972eebea83e2d00cce2177e7e6e4193f5dee3ccd4756d8e7aeb7e7f3";

    //User APIs
    public static final String USER_PREFIX = "/public-api/users";
    public static final String GET_USERS_ENDPOINT = "?page=%s";

    //Nên đặt endpoint dạng ENDPOINT_USER_DETAILS_UPDATE, ENDPOINT_USER_CREATE
    public static final String USER_ID_ENDPOINT = "/%s";
}
