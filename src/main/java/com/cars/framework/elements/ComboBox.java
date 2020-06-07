package com.cars.framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.Collections;
import java.util.List;

public class ComboBox extends BaseElement {
    private final Select selectObject = new Select(element);

    public ComboBox(By locator, String nameOfElement) {
        super(locator, nameOfElement);
    }

    public String chooseRandomOption() {
        List<WebElement> listOptions = selectObject.getOptions();
        listOptions.remove(0);
        Collections.shuffle(listOptions);
        String chosenOption = listOptions.get(0).getText();
        selectObject.selectByVisibleText(chosenOption);
        return chosenOption;
    }

    public void chooseOption(String option) {
        selectObject.selectByVisibleText(option);
    }
}