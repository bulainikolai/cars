package com.cars.framework.forms;

import com.cars.framework.elements.Label;
import com.cars.framework.utils.Logger;
import org.openqa.selenium.By;

public abstract class BaseForm {
    protected By uniqueElementLocator;
    protected String nameOfForm;

    public BaseForm(By locatorUniqueElement, String nameOfClass) {
        Logger.info("create object of " + nameOfClass);
        nameOfForm = nameOfClass;
        uniqueElementLocator = locatorUniqueElement;
    }

    public String nameOfCorrectForm() {
        Logger.info("get name of " + nameOfForm + " in BaseForm");
        return new Label(uniqueElementLocator, "label of form").getText().trim();
    }

    public boolean isDisplayed() {
        Logger.info("check is " + nameOfForm + " in BaseForm");
        return new Label(uniqueElementLocator, "label of form").isPresent();
    }
}
