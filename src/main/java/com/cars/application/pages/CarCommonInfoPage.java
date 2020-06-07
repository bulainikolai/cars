package com.cars.application.pages;

import com.cars.application.models.Car;
import com.cars.framework.elements.Button;
import com.cars.framework.elements.Label;
import org.openqa.selenium.By;

public class CarCommonInfoPage extends BaseCarsComPage {
    private static final By UNIQUE_ELEMENT_LOCATOR = By.xpath("//a[@class = 'mmy-header__change']");
    private final By COMPARE_TRIMS_BUTTON_LOCATOR = By.xpath("//a[@data-linkname = 'trim-compare']");
    private final By INFO_ABOUT_CAR_LOCATOR = By.xpath("//h1[@class = 'cui-page-section__title']");
    private Label infoAboutCar;
    private Button compareTrimsButton;

    public CarCommonInfoPage() {
        super(UNIQUE_ELEMENT_LOCATOR, "CarInfoForm");
    }

    public boolean isCompareTrimsButtonPresent() {
        compareTrimsButton = new Button(COMPARE_TRIMS_BUTTON_LOCATOR, "compareTrimsButton");
        return compareTrimsButton.isPresent();
    }

    public boolean isPageOpenWithCorrectCar(Car car) {
        infoAboutCar = new Label(INFO_ABOUT_CAR_LOCATOR, "infoAboutCar");
        String info = infoAboutCar.getText().toLowerCase();
        return info.contains(car.getMake().toLowerCase())
                && info.contains(car.getModel().toLowerCase())
                && info.contains(car.getYear().toLowerCase());
    }

    public void clickCompareTrimsButton() {
        compareTrimsButton.waitAndClick();
    }
}