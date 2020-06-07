package com.cars.application.forms;

import com.cars.framework.elements.Button;
import com.cars.framework.elements.ComboBox;
import org.openqa.selenium.By;

public class MakeModelYearForm extends ComboBoxForm {
    private static final By UNIQUE_ELEMENT_LOCATOR = By.xpath("//p[contains(text(), 'Research')]");
    private static final By MAKE_COMBO_BOX_LOCATOR = By.xpath("//select[@name = 'makeId']");
    private static final By MODEL_COMBO_BOX_LOCATOR = By.xpath("//select[@name = 'modelId']");
    private static final By YEAR_COMBO_BOX_LOCATOR = By.xpath("//select[@name = 'year']");
    private static final By SEARCH_BUTTON_LOCATOR = By.xpath("//input[@value = 'Search']");
    private static final String NAME_OF_BUTTON = "searchButton";

    public MakeModelYearForm() {
        super(UNIQUE_ELEMENT_LOCATOR,"MakeModelYearMenu");
        makeComboBox = new ComboBox(MAKE_COMBO_BOX_LOCATOR, "makeComboBox");
        modelComboBox = new ComboBox(MODEL_COMBO_BOX_LOCATOR, "modelComboBox");
        yearComboBox = new ComboBox(YEAR_COMBO_BOX_LOCATOR, "yearComboBox");
        button = new Button(SEARCH_BUTTON_LOCATOR, NAME_OF_BUTTON);
    }
}