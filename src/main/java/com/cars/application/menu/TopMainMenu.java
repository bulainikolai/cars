package com.cars.application.menu;

import com.cars.framework.elements.Button;
import com.cars.framework.forms.BaseForm;
import com.cars.framework.utils.Logger;
import org.openqa.selenium.By;

public class TopMainMenu extends BaseForm {
    private static final By UNIQUE_ELEMENT_LOCATOR = By.xpath("//a[@data-linkname = 'header-home']");
    private final By MAIN_PAGE_LOCATOR = By.xpath("//a[@data-linkname = 'header-home']");
    private final String FIRST_PART_CATEGORY_LOCATOR = "//ul[contains(@class, '_1U4gk')]//a[contains(text(), '";
    private final String LAST_PART_CATEGORY_LOCATOR = "')]";
    private Button categoryMenu;
    private Button mainPage;

    public TopMainMenu() {
        super(UNIQUE_ELEMENT_LOCATOR, "MainMenu");
    }

    public void clickCategory(String category) {
        Logger.info("select category - " + category + " and click on it in MainMenu");
        categoryMenu = new Button(By.xpath(String.format("%s%s%s", FIRST_PART_CATEGORY_LOCATOR, category, LAST_PART_CATEGORY_LOCATOR)), "Button-" + category);
        categoryMenu.waitAndClick();
    }

    public void returnToMainPage() {
        Logger.info("return to mainPage in MainMenu");
        mainPage = new Button(MAIN_PAGE_LOCATOR, "Button-mainPage");
        mainPage.waitAndClick();
    }
}