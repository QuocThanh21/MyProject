package com.demoqa.utils;

import com.google.gson.stream.JsonReader;
import java.io.*;

public class JsonUtil {
    /** ---------------------- Constructor ------------------------ */
    public JsonUtil() {}

    /** ---------------------- Methods ------------------------ */
    public JsonReader readJsonFile(String nameOfJsonFile) throws FileNotFoundException {
        String filePath = System.getProperty("TEST_DATA_DIR") + nameOfJsonFile;
        JsonReader reader = new JsonReader(new FileReader(filePath));
        return reader;
    }
}
