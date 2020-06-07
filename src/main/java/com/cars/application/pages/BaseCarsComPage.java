package com.cars.application.pages;

import com.cars.application.menu.TopMainMenu;
import com.cars.framework.forms.BaseForm;
import org.openqa.selenium.By;

public abstract class BaseCarsComPage extends BaseForm {
    private TopMainMenu topMainMenu = new TopMainMenu();

    public BaseCarsComPage(By locatorUniqueElement, String nameOfClass) {
        super(locatorUniqueElement, nameOfClass);
    }

    public TopMainMenu getTopMainMenu() {
        return topMainMenu;
    }
}