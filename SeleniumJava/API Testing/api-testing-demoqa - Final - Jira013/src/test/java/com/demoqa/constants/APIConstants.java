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

    //Account APIs
    public static String DEMOQA_ACCOUNT_PREFIX = "/Account/v1";
    public static String ENDPOINT_GET_USER = "/User/%s";
    public static String ENDPOINT_GENERATE_TOKEN = "/GenerateToken";
    public static String ENDPOINT_CREATE_USER = "/User";

    //Book Store APIs
    public static String DEMOQA_BOOK_STORE_PREFIX = "/BookStore/v1";
    public static String ENDPOINT_GET_ALL_BOOKS = "/Books";
    public static String ENDPOINT_ADD_BOOK_TO_COLLECTION = "/Books";
    public static String ENDPOINT_DELETE_A_BOOK_FROM_COLLECTION = "/Book";
    public static String ENDPOINT_DELETE_ALL_BOOKS_FROM_COLLECTION = "/Books?UserId=%s";
    public static String ENDPOINT_REPLACE_A_BOOK = "/Books/%s";
    public static String WRONG_TOKEN = "00000000-0000-0000-0000-000000000000";
    public static String UNEXISTING_ISBN = "00000000";
}
