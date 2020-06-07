package com.cars.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
    private static final String PATH_TO_PROP = System.getProperty("user.dir") + "/src/main/resources/dr.properties";
    private static final String PATH_TO_DATA_WAITERS = System.getProperty("user.dir") + "/src/main/resources/waiters.properties";
    private static final String PATH_TO_TEST_DATA = System.getProperty("user.dir") + "/src/main/resources/testData.properties";
    private static final File FILE_PROP = new File(PATH_TO_PROP);
    private static final File FILE_DATA_WAITERS = new File(PATH_TO_DATA_WAITERS);
    private static final File FILE_TEST_DATA = new File(PATH_TO_TEST_DATA);
    private static final Properties PROPERTIES = getProperties(FILE_PROP);
    private static final Properties PROPERTIES_DATA_WAITERS = getProperties(FILE_DATA_WAITERS);
    private static final Properties PROPERTIES_TEST_DATA = getProperties(FILE_TEST_DATA);

    public static String readValueProp(String property) {
        return PROPERTIES.getProperty(property);
    }

    public static String readValueDataWaiters(String propWait) {
        return PROPERTIES_DATA_WAITERS.getProperty(propWait);
    }

    public static String readValueTestData(String propTestData) {
        return PROPERTIES_TEST_DATA.getProperty(propTestData);
    }

    private static FileInputStream getFileInputStream(File file) {
        FileInputStream result = null;
        try {
            result = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static Properties getProperties(File file) {
        Properties prop = new Properties();
        try {
            prop.load(getFileInputStream(file));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return prop;
    }
}