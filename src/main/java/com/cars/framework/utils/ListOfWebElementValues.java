package com.cars.framework.utils;

import com.cars.framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListOfWebElementValues {
    public static List<String> getListOfWebElementValues(By locator) {
        WaitersUtil.waitElementToBeVisible(locator);
        List<String> listOfValues = new ArrayList<>();
        List<WebElement> listOfElement = Browser.getDriver().findElements(locator);
        for (WebElement element : listOfElement) {
            System.out.println("getListOfWebElementValues element: " + element.getText());
            listOfValues.add(element.getText());
        }
        return listOfValues;
    }
}