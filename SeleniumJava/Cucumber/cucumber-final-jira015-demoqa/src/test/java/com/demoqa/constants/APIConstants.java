package com.demoqa.constants;

public class APIConstants {

    public enum RequestType {
        POST,
        PUT,
        PATCH,
        DELETE,
        GET
    }

    public static String DEMOQA_HOST = "https://demoqa.com";
    public static String USER_ID = "b8b96bdb-d0a4-40a4-a6a1-cb318f94993a";

    //Account APIs
    public static String DEMOQA_ACCOUNT_PREFIX = "/Account/v1";
    public static String ENDPOINT_GET_USER = "/User/%s";
    public static String ENDPOINT_GENERATE_TOKEN = "/GenerateToken";

    //Book Store APIs
    public static String DEMOQA_BOOK_STORE_PREFIX = "/BookStore/v1";
    public static String ENDPOINT_GET_ALL_BOOKS = "/Books";
    public static String ENDPOINT_ADD_BOOK_TO_COLLECTION = "/Books";
    public static String ENDPOINT_DELETE_A_BOOK_FROM_COLLECTION = "/Book";
    public static String ENDPOINT_DELETE_ALL_BOOKS_FROM_COLLECTION = "/Books?UserId=%s";
    public static String ENDPOINT_REPLACE_A_BOOK = "/Books/%s";
}
