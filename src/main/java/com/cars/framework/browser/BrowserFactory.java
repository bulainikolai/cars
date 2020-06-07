package com.cars.framework.browser;

import com.cars.framework.utils.Logger;
import com.cars.framework.utils.ReadProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class BrowserFactory {
    private static WebDriver instance;

    public static WebDriver getInstance() {
        Logger.info("get instance of Web browser in BrowserFactory");
        if (instance == null) {
            instance = BrowserFactory.initBrowser();
        }
        return instance;
    }

    private static WebDriver initBrowser() {
        Logger.info("init browser in BrowserFactory");
        WebDriver instance;

        String nameOfBrowser = ReadProperty.readValueProp("browserName");
        switch (nameOfBrowser) {
            case "fireFox":
                Logger.info("init fireFox browser in BrowserFactory");
                WebDriverManager.firefoxdriver().setup();
                instance = new FirefoxDriver();
                break;
            case "chrome":
                Logger.info("init chrome browser in BrowserFactory");
                WebDriverManager.chromedriver().setup();
                instance = new ChromeDriver();
                break;
            default:
                Logger.warn("throw IllegalArgumentException in BrowserFactory because of test started with invalid browser");
                throw new IllegalArgumentException("test started with invalid browser");
        }
        return instance;
    }

    public static void setInstanceNull() {
        Logger.info("set Instance of web browser = Null");
        instance = null;
    }
}