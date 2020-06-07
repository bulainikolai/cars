package com.cars.application.pages;

import com.cars.application.forms.CarFirstTrimForm;
import com.cars.application.models.Car;
import com.cars.framework.elements.Label;
import org.openqa.selenium.By;

public class CarSpecificInfoPage extends BaseCarsComPage {
    private static final By UNIQUE_ELEMENT_LOCATOR = By.xpath("//div[@class = 'trim-top-section']");
    private final By INFO_ABOUT_CAR_LOCATOR = By.xpath("//div[@class = 'trim-header__title']");
    private Label infoAboutCarLabel;
    private CarFirstTrimForm carFirstTrimForm = new CarFirstTrimForm();

    public CarSpecificInfoPage() {
        super(UNIQUE_ELEMENT_LOCATOR, "CarSpecificInfoForm");
    }

    public boolean isPageOpenWithCorrectCar(Car car) {
        infoAboutCarLabel = new Label(INFO_ABOUT_CAR_LOCATOR, "infoAboutCarLabel");
        String info = infoAboutCarLabel.getText().toLowerCase();
        return info.contains(car.getMake().toLowerCase())
                && info.contains(car.getModel().toLowerCase())
                && info.contains(car.getYear().toLowerCase());
    }

    public CarFirstTrimForm getCarFirstTrimForm() {
        return carFirstTrimForm;
    }
}