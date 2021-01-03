package com.cars.framework.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
    public static void createAllureProperties(String browser) {
        Properties properties = new Properties();
        properties.setProperty("BROWSER", browser);
        FileWriter writer = null;
        try {
            writer = new FileWriter("target/allure-results/environment.properties");
            properties.store(writer, "Steam");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
