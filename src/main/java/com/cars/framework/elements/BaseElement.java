package com.cars.framework.elements;

import com.cars.framework.browser.Browser;
import com.cars.framework.utils.Logger;
import com.cars.framework.utils.WaitersUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class BaseElement {
    protected By locator;
    protected WebElement element;
    protected String nameOfElement;

    public BaseElement(By locator, String nameOfElement) {
        this.locator = locator;
        this.nameOfElement = nameOfElement;
        Logger.info("create object of " + nameOfElement);
        this.element = Browser.getDriver().findElements(locator).size() > 0 ? Browser.getDriver().findElement(locator) : null;
    }

    public void moveToElement() {
        if (isPresent()) {
            Actions actions = new Actions(Browser.getDriver());
            Logger.info("move to element " + locator);
            WaitersUtil.waitElementToBeVisible(locator);
            actions.moveToElement(element).build().perform();
        }
    }

    public boolean isPresent() {
        Logger.info("check is present " + locator + " WebElement");
        boolean elementPresent = false;
        if (element != null) {
            WaitersUtil.waitElementToBeVisible(locator);
            elementPresent = true;
        }
        return elementPresent;
    }

    public String getAttribute(String attribute) {
        String attributeText = null;
        if (isPresent()) {
            Logger.info("get attribute-" + attribute + " of WebElement in Label");
            attributeText = element.getAttribute(attribute);
        }
        return attributeText;
    }

    public String getText() {
        String text = null;
        if (isPresent()) {
            Logger.info("get text of Label in Label");
            WaitersUtil.waitElementToBeVisible(locator);
            text = element.getText();
        }
        return text;
    }
}