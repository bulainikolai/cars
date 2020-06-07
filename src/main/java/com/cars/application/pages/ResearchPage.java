package com.cars.application.pages;

import com.cars.application.forms.MakeModelYearForm;
import com.cars.framework.elements.Button;
import org.openqa.selenium.By;

public class ResearchPage extends BaseCarsComPage {
    private static final By UNIQUE_ELEMENT_LOCATOR = By.xpath("//h2[contains(text(), 'Tools and Expert Advice')]");
    private static final By SIDE_BY_SIDE_COMPARISON_BUTTON_LOCATOR = By.xpath("//h4[contains(text(), 'Side-by-side Comparisons')]");
    private MakeModelYearForm makeModelYearForm = new MakeModelYearForm();
    private Button sideBySideComparisonButton;

    public ResearchPage() {
        super(UNIQUE_ELEMENT_LOCATOR, "ResearchForm");
    }

    public MakeModelYearForm getMakeModelYearForm() {
        return makeModelYearForm;
    }

    public void clickSideBySideComparisonButton() {
        sideBySideComparisonButton = new Button(SIDE_BY_SIDE_COMPARISON_BUTTON_LOCATOR, "sideBySideComparisonButton");
        sideBySideComparisonButton.waitAndClick();
    }
}