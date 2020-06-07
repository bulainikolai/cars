package com.cars.framework.utils;

import com.cars.framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitersUtil {
    private static final int TIME_OF_EXPLICIT = Integer.valueOf(ReadProperty.readValueDataWaiters("TIME_OF_EXPLICIT"));
    private static final int TIME_OF_IMPLICIT = Integer.valueOf(ReadProperty.readValueDataWaiters("TIME_OF_IMPLICIT"));
    private static final int TIME_OF_IMPLICIT_ZERO = Integer.valueOf(ReadProperty.readValueDataWaiters("TIME_OF_IMPLICIT_ZERO"));
    private static final int TIME_OF_FLUENT_WAIT_TIMEOUT = Integer.valueOf(ReadProperty.readValueDataWaiters("TIME_OF_FLUENT_WAIT_TIMEOUT"));
    private static final int TIME_OF_FLUENT_WAIT_POLLING = Integer.valueOf(ReadProperty.readValueDataWaiters("TIME_OF_FLUENT_WAIT_POLLING"));

    public static void waitElementToBeVisible(By locator) {
        Logger.info("wait - explicit - until the item is visible in WaitersUtil");
        setImplicitWait(TIME_OF_IMPLICIT_ZERO);
        new WebDriverWait(Browser.getDriver(), TIME_OF_EXPLICIT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        setImplicitWait(TIME_OF_IMPLICIT);
    }

    public static void waitElementToBeClickable(By locator) {
        Logger.info("wait - explicit - until the item is clickable in WaitersUtil");
        setImplicitWait(TIME_OF_IMPLICIT_ZERO);
        new WebDriverWait(Browser.getDriver(), TIME_OF_EXPLICIT)
                .until(ExpectedConditions.elementToBeClickable(locator));
        setImplicitWait(TIME_OF_IMPLICIT);
    }

    public static void fluentWaitVisibility(By locator) {
        Logger.info("wait - fluentWait - until the item is visible in WaitersUtil");
        setImplicitWait(TIME_OF_IMPLICIT_ZERO);
        new FluentWait<>(Browser.getDriver())
                .withTimeout(Duration.ofSeconds(TIME_OF_FLUENT_WAIT_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(TIME_OF_FLUENT_WAIT_POLLING))
                .ignoring(NoSuchElementException.class)
                .until(
                        ExpectedConditions.visibilityOfElementLocated(
                                locator
                        )
                );
        setImplicitWait(TIME_OF_IMPLICIT);
    }

    public static void setImplicitWait(int timeOfWait) {
        Logger.info("set ImplicitWait in WaitersUtil");
        Browser.getDriver().manage().timeouts().implicitlyWait(timeOfWait, TimeUnit.SECONDS);
    }
}