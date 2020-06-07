package com.cars;

import com.cars.application.forms.*;
import com.cars.application.models.Car;
import com.cars.application.pages.*;
import com.cars.framework.utils.Logger;
import com.cars.framework.utils.ReadProperty;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareCarsTest extends BaseTest {
    @Test
    public void compareCars() {
        Logger.step(1, "Open https://www.cars.com");
        MainPage mainPage = new MainPage();
        Logger.info("call assert to check is main page opened in CompareCarsTest");
        Assert.assertTrue(mainPage.isDisplayed(), "We did't get main page");

        Logger.step(2, "Go to page Research");
        mainPage.getTopMainMenu().clickCategory("Research");

        boolean isCompareTrimsButtonPresent = false;
        CarCommonInfoPage carCommonInfoPage = null;
        Car chosenCar = null;
        int countOfCheck = Integer.parseInt(ReadProperty.readValueTestData("countOfCheckPresenceCompareTrims"));
        while (!isCompareTrimsButtonPresent) {
            ResearchPage researchPage = new ResearchPage();
            Assert.assertTrue(researchPage.isDisplayed(), "We did't get ResearchForm");

            Logger.step(3, "Go to page Research");
            chosenCar = researchPage.getMakeModelYearForm().selectOptionsByRandomAndGetCarAndClickButton(1);
            Assert.assertTrue(
                    researchPage.getMakeModelYearForm().isValueSuccessfullySelected(),
                    "Some value in combo box still has default value"
            );
            carCommonInfoPage = new CarCommonInfoPage();
            Assert.assertTrue(carCommonInfoPage.isDisplayed(), "We did't get CarInfoForm");
            Assert.assertTrue(carCommonInfoPage.isPageOpenWithCorrectCar(chosenCar), "We did't get page with correct info about car");

            isCompareTrimsButtonPresent = carCommonInfoPage.isCompareTrimsButtonPresent();
            if (!isCompareTrimsButtonPresent) {
                carCommonInfoPage.getTopMainMenu().clickCategory("Research");
                --countOfCheck;
                if (countOfCheck == 0) {
                    break;
                }
            }
        }

        Logger.step(4, "Go to page Compare Trims");
        carCommonInfoPage.clickCompareTrimsButton();
        CarSpecificInfoPage carSpecificInfoPage = new CarSpecificInfoPage();
        Assert.assertTrue(carSpecificInfoPage.isDisplayed(), "We did't get CarSpecificInfoForm");
        Assert.assertTrue(
                carSpecificInfoPage.isPageOpenWithCorrectCar(chosenCar),
                "We did't get CarSpecificInfoForm with chosen Make-Model-Year info"
        );

        Logger.step(5, "Save the characteristics of the car for later comparison");
        carSpecificInfoPage.getCarFirstTrimForm().saveFeaturesOfCar(chosenCar);

        Logger.step(6, "Open main page https://www.cars.com");
        carSpecificInfoPage.getTopMainMenu().returnToMainPage();
    }
}