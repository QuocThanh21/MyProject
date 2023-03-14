package com.nashtech.tms.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesFileUtil {
    /** ---------------------- Constructor ------------------------ */
    private PropertiesFileUtil() {}

    /** ---------------------- Methods ------------------------ */
    public static Properties loadPropertiesFromFile(String filePath) throws IOException {
        try (InputStream input = new FileInputStream(filePath)) {
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        }
    }

    public static void appendSystemProperties(Properties properties) {
        for (String name : properties.stringPropertyNames()) {
            String value = properties.getProperty(name);
            System.setProperty(name, value);
        }
    }
}
