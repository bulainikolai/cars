package com.cars.application.pages;

import com.cars.application.forms.MakeModelYearCompareForm;
import org.openqa.selenium.By;

public class CompareSideBySidePage extends BaseCarsComPage {
    private static final By UNIQUE_ELEMENT_LOCATOR = By.xpath("//h1[contains(@class, 'compare-head-h1-semi')]");
    private MakeModelYearCompareForm makeModelYearCompareForm = new MakeModelYearCompareForm();

    public CompareSideBySidePage() {
        super(UNIQUE_ELEMENT_LOCATOR, "CompareSideBySideForm");
    }

    public MakeModelYearCompareForm getMakeModelYearCompareForm() {
        return makeModelYearCompareForm;
    }
}