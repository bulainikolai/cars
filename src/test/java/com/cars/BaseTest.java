package com.cars;

import com.cars.framework.utils.Logger;
import com.cars.framework.browser.Browser;
import com.cars.framework.utils.WaitersUtil;
import com.cars.framework.utils.ReadProperty;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    @BeforeMethod
    protected void browserFactory() {
        WaitersUtil.setImplicitWait(Integer.valueOf(ReadProperty.readValueDataWaiters("TIME_OF_IMPLICIT")));
        Browser.maximizeWindow();
        Browser.navigate(ReadProperty.readValueProp("mainUrl"));
    }

    @AfterMethod
    protected void tearDown() {
        Logger.info("call tearDown in BeforeMethod");
        Browser.close();
    }
}
