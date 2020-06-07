package com.cars.framework.elements;

import com.cars.framework.utils.Logger;
import com.cars.framework.utils.WaitersUtil;
import org.openqa.selenium.By;

public class Button extends BaseElement {
    public Button(By locator, String nameOfElement) {
        super(locator, nameOfElement);
    }

    public void waitAndClick() {
        Logger.info("click on Button-" + nameOfElement);
        WaitersUtil.waitElementToBeClickable(locator);
        element.click();
    }
}
