package com.solvd.apitests.web.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SeleniumDynamicPageBase extends AbstractPage {
    public SeleniumDynamicPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickAddBoxButton(int times);

    public abstract List<ExtendedWebElement> getBoxes();

    public abstract ExtendedWebElement getLastBox();
}
