package com.cars;

import com.cars.framework.parameters.ParametersJenkins;
import com.cars.framework.utils.FileUtil;
import com.cars.framework.utils.Logger;
import com.cars.framework.browser.Browser;
import com.cars.framework.utils.WaitersUtil;
import com.cars.framework.utils.ReadProperty;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
    protected ParametersJenkins parametersJenkins;

    @Parameters({"browser"})
    @BeforeMethod
    protected void browserFactory(@Optional("chrome") String browser) {
        parametersJenkins = new ParametersJenkins();
        parametersJenkins.setBrowser(browser);
        WaitersUtil.setImplicitWait(Integer.valueOf(ReadProperty.readValueDataWaiters("TIME_OF_IMPLICIT")));
        Browser.maximizeWindow();
        Browser.navigate(ReadProperty.readValueProp("mainUrl"));
    }

    @AfterMethod
    protected void tearDown() {
        Logger.info("call tearDown in BeforeMethod");
        FileUtil.createAllureProperties(parametersJenkins.getBrowser());
        Browser.close();
    }
}
