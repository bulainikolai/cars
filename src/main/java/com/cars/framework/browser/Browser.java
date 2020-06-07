package com.cars.framework.browser;

import com.cars.framework.utils.Logger;
import org.openqa.selenium.WebDriver;

public final class Browser {
    private Browser() {
    }

    public static WebDriver getDriver() {
        Logger.info("get Driver in Browser");
        return BrowserFactory.getInstance();
    }

    public static void navigate(String url) {
        Logger.info("navigate to " + url + " in Browser");
        BrowserFactory.getInstance().get(url);
    }

    public static void maximizeWindow() {
        Logger.info("maximize window of Web browser in Browser");
        BrowserFactory.getInstance().manage().window().maximize();
    }

    public static void close() {
        Logger.info("close window in Browser");
        getDriver().quit();
        BrowserFactory.setInstanceNull();
    }
}
