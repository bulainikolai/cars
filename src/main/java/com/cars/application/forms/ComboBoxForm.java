package com.cars.application.forms;

import com.cars.application.models.Car;
import com.cars.framework.elements.Button;
import com.cars.framework.elements.ComboBox;
import com.cars.framework.forms.BaseForm;
import org.openqa.selenium.By;

public abstract class ComboBoxForm extends BaseForm {
    protected ComboBox makeComboBox;
    protected ComboBox modelComboBox;
    protected ComboBox yearComboBox;
    public Button button;
    private final String DEFAULT_OPTION_VALUE_ALL = "All ";
    private String selectionResultMake;
    private String selectionResultModel;
    private String selectionResultYear;
    public ComboBoxForm(By locatorUniqueElement, String nameOfClass) {
        super(locatorUniqueElement, nameOfClass);
    }

    public void selectOptionsAndClickButton(String make, String model, String year) {
        makeComboBox.chooseOption(make);
        modelComboBox.chooseOption(model);
        yearComboBox.chooseOption(year);
        button.waitAndClick();
    }

    public Car selectOptionsByRandomAndGetCarAndClickButton(int numberOfCar) {
        selectionResultMake = makeComboBox.chooseRandomOption();
        selectionResultModel = modelComboBox.chooseRandomOption();
        selectionResultYear = yearComboBox.chooseRandomOption();
        Car chosenCar = new Car();
        chosenCar.setMake(selectionResultMake);
        chosenCar.setModel(selectionResultModel);
        chosenCar.setYear(selectionResultYear);
        chosenCar.setNumberOfCar(numberOfCar);
        button.waitAndClick();
        return chosenCar;
    }

    public boolean isValueSuccessfullySelected() {
        return selectionResultMake != null && !selectionResultMake.contains(DEFAULT_OPTION_VALUE_ALL)
                && selectionResultModel != null && !selectionResultModel.contains(DEFAULT_OPTION_VALUE_ALL)
                && selectionResultYear != null && !selectionResultYear.contains(DEFAULT_OPTION_VALUE_ALL);
    }
}