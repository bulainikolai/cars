package com.cars.application.forms;

import com.cars.application.models.Car;
import com.cars.framework.forms.BaseForm;
import com.cars.framework.utils.ListOfWebElementValues;
import org.openqa.selenium.By;

public class CarFirstTrimForm extends BaseForm {
    private static final By UNIQUE_ELEMENT_LOCATOR = By.xpath("/descendant::div[@id='trim-table'][1]");
    private final By ENGINE_LOCATOR = By.xpath("//label[@for='tab-0']/following-sibling::div//div[contains(@class, 'cell-bg grow-2')]");
    private final By TRANSMISSION_LOCATOR = By.xpath("//label[@for='tab-0']/following-sibling::div//div[contains(@class, 'cell grow-2')]");

    public CarFirstTrimForm() {
        super(UNIQUE_ELEMENT_LOCATOR, "CarFirstTrimForm");
    }

    public void saveFeaturesOfCar(Car car) {
        car.setEngine(ListOfWebElementValues.getListOfWebElementValues(ENGINE_LOCATOR));
        car.setTransmission(ListOfWebElementValues.getListOfWebElementValues(TRANSMISSION_LOCATOR));
    }
}