package com.cars.application.pages;

import org.openqa.selenium.By;

public class MainPage extends BaseCarsComPage {
    private static final By UNIQUE_ELEMENT_LOCATOR = By.xpath("//h2[contains(text(), 'New Car Reviews')]");

    public MainPage() {
        super(UNIQUE_ELEMENT_LOCATOR, "MainForm");
    }
}