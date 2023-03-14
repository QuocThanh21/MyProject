package com.demoqa.utils;

import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtil {

    public static JsonReader readJsonFile(String nameOfJsonFile) throws FileNotFoundException {
        String filePath = "src/test/resources/testdatas/" + nameOfJsonFile;
        JsonReader reader = new JsonReader(new FileReader(filePath));
        return reader;
    }
}
