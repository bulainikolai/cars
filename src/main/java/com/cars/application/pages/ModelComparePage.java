package com.cars.application.pages;

import com.cars.application.models.Car;
import com.cars.framework.elements.Button;
import com.cars.framework.utils.ListOfWebElementValues;
import com.cars.framework.utils.ListUtil;
import com.cars.framework.utils.WaitersUtil;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ModelComparePage extends BaseCarsComPage {
    private static final By UNIQUE_ELEMENT_LOCATOR = By.xpath("//h1[@id = 'main-headline']");
    private final By ADD_CAR_BUTTON_LOCATOR = By.xpath("//div[@id = 'icon-div']");
    private final By INFO_MAKE_MODEL_YEAR_CARS_LOCATOR = By.xpath("//a[@id = 'compare-ymmt']/h4");
    private final By FIRST_CAR_ENGINE_LOCATOR = By.xpath("//*[@header = 'Engine']//span[@index='0']//p");
    private final By SECOND_CAR_ENGINE_LOCATOR = By.xpath("//*[@header = 'Engine']//span[@index='1']//p");
    private final By FIRST_CAR_TRANSMISSION_LOCATOR = By.xpath("//*[@header = 'Transmission']//span[@index='0']//p");
    private final By SECOND_CAR_TRANSMISSION_LOCATOR = By.xpath("//*[@header = 'Transmission']//span[@index='1']//p");
    private Button addCarButton;

    public ModelComparePage() {
        super(UNIQUE_ELEMENT_LOCATOR, "ModelCompareForm");
    }

    public void clickAddCarButton() {
        addCarButton = new Button(ADD_CAR_BUTTON_LOCATOR, "addCarButton");
        addCarButton.waitAndClick();
    }

    public boolean isPageOpenWithCorrectCar(Car car) {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//
//        }
        WaitersUtil.fluentWaitVisibility(By.xpath("//div[@data-linkname = 'customize-comparison-bottom']//a"));
        List<String> makeModelYearInfoCars = ListOfWebElementValues.getListOfWebElementValues(INFO_MAKE_MODEL_YEAR_CARS_LOCATOR);
        System.out.println("size: " + makeModelYearInfoCars.size());
        makeModelYearInfoCars.forEach(n -> System.out.println("makeModelYearInfoCars: " + n));
        String currentCarInfo = makeModelYearInfoCars.get(car.getNumberOfCar() - 1).toLowerCase();
        System.out.println("currentCarInfo: " + currentCarInfo);
        return currentCarInfo.contains(car.getMake().toLowerCase())
                && currentCarInfo.contains(car.getModel().toLowerCase())
                && currentCarInfo.contains(car.getYear().toLowerCase());
    }

    public boolean isEngineAndTransmissionCorrect(Car ...cars) {
        WaitersUtil.fluentWaitVisibility(By.xpath("//div[@data-linkname = 'customize-comparison-bottom']//a"));
        boolean resultComparison = true;
        Car[] presentCars = getPresentCars();
        for (Car chosenCar: cars) {
            for (Car presentCar : presentCars) {
                if (chosenCar.getNumberOfCar() == presentCar.getNumberOfCar()) {
                    System.out.println("chosenCar-eng" + chosenCar.getEngine());
                    System.out.println("presentCar-eng" + presentCar.getEngine());
                    System.out.println("chosenCar-trans" + chosenCar.getTransmission());
                    System.out.println("presentCar-trans" + presentCar.getTransmission());
                    if (!chosenCar.getEngine().containsAll(presentCar.getEngine())
                            || !chosenCar.getTransmission().containsAll(presentCar.getTransmission())) {
                        resultComparison = false;
                        break;
                    }
                }
            }
        }
        return resultComparison;
    }

    private Car[] getPresentCars() {
        ArrayList<String> enginesFirstCar = new ArrayList<>(ListOfWebElementValues.getListOfWebElementValues(FIRST_CAR_ENGINE_LOCATOR));
        ArrayList<String> enginesSecondCar = new ArrayList<>(ListOfWebElementValues.getListOfWebElementValues(SECOND_CAR_ENGINE_LOCATOR));
        ArrayList<String> transmissionsFirstCar = new ArrayList<>(ListOfWebElementValues.getListOfWebElementValues(FIRST_CAR_TRANSMISSION_LOCATOR));
        ArrayList<String> transmissionsSecondCar = new ArrayList<>(ListOfWebElementValues.getListOfWebElementValues(SECOND_CAR_TRANSMISSION_LOCATOR));
        Car firstCarPresent = new Car();
        Car secondCarPresent = new Car();
        return new Car[]{
                setValuesOfCar(
                        firstCarPresent,
                        ListUtil.removeFromElementsOfListLastComma(enginesFirstCar),
                        ListUtil.removeFromElementsOfListLastComma(transmissionsFirstCar),
                        1
                ),
                setValuesOfCar(
                        secondCarPresent,
                        ListUtil.removeFromElementsOfListLastComma(enginesSecondCar),
                        ListUtil.removeFromElementsOfListLastComma(transmissionsSecondCar),
                        2
                )
        };
    }

    private Car setValuesOfCar(Car car, List<String> engine, List<String> transmission, int numberOfCar) {
        car.setEngine(engine);
        car.setTransmission(transmission);
        car.setNumberOfCar(numberOfCar);
        return car;
    }
}