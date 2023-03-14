package com.nachtech.tms.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtil {
    /** ---------------------- Constructor ------------------------ */
    public JsonUtil() {}

    /** ---------------------- Methods ------------------------ */
    public JsonReader readJsonFile(String nameOfJsonFile) throws FileNotFoundException {
        String filePath = System.getProperty("TEST_DATA_DIR") + nameOfJsonFile;
        JsonReader reader = new JsonReader(new FileReader(filePath));
        return reader;
    }

    public static  <T> T covertJsonToObject(String nameOfJsonFile, Class<T> kclass) throws FileNotFoundException {
        JsonUtil jsonUtil = new JsonUtil();
        JsonReader reader = jsonUtil.readJsonFile(nameOfJsonFile);
        Gson gson = new Gson();
        T object = gson.fromJson(reader, kclass);
        return object;
    }
}
