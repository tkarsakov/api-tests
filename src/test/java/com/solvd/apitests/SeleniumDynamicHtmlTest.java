package com.solvd.apitests;

import com.solvd.apitests.web.pages.common.SeleniumDynamicPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SeleniumDynamicHtmlTest implements IAbstractTest {

    private SeleniumDynamicPageBase seleniumDynamicPage = null;

    @BeforeSuite
    public void startDriver() {
        seleniumDynamicPage = initPage(getDriver(), SeleniumDynamicPageBase.class);
    }

    @Test(dataProvider = "DP1")
    public void testBoxes(int times) {
        SoftAssert softAssert = new SoftAssert();
        seleniumDynamicPage.open();
        Assert.assertTrue(seleniumDynamicPage.isPageOpened());

        seleniumDynamicPage.clickAddBoxButton(times);

        softAssert.assertEquals(seleniumDynamicPage.getBoxes().size(), times);
        softAssert.assertEquals(seleniumDynamicPage.getLastBox().getAttribute("id"), "box" + (times - 1));
        softAssert.assertAll();
    }

    @DataProvider(name = "DP1")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {3},
                {2},
                {5}
        };
    }
}
