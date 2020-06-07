package com.cars.application.forms;

import com.cars.framework.elements.Button;
import com.cars.framework.elements.ComboBox;
import org.openqa.selenium.By;

public class AddCarForm extends ComboBoxForm {
    private static final By UNIQUE_ELEMENT_LOCATOR = By.xpath("//div[@class = 'modal-content']");
    private static final By MAKE_COMBO_BOX_LOCATOR = By.xpath("//select[@id = 'make-dropdown']");
    private static final By MODEL_COMBO_BOX_LOCATOR = By.xpath("//select[@id = 'model-dropdown']");
    private static final By YEAR_COMBO_BOX_LOCATOR = By.xpath("//select[@id = 'year-dropdown']");
    private static final By DONE_BUTTON_LOCATOR = By.xpath("//button[@data-linkname = 'add-car-select']");
    private static final String NAME_OF_BUTTON = "doneButton";

    public AddCarForm() {
        super(UNIQUE_ELEMENT_LOCATOR,"MakeModelYearAddCarForm");
        makeComboBox = new ComboBox(MAKE_COMBO_BOX_LOCATOR, "makeComboBox");
        modelComboBox = new ComboBox(MODEL_COMBO_BOX_LOCATOR, "modelComboBox");
        yearComboBox = new ComboBox(YEAR_COMBO_BOX_LOCATOR, "yearComboBox");
        button = new Button(DONE_BUTTON_LOCATOR, NAME_OF_BUTTON);
    }

    public void fillMakeModelYearAndClickDoneButton(String make, String model, String year) {
        super.selectOptionsAndClickButton(make, model, year);
    }
}