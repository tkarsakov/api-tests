package com.solvd.apitests.web.pages;

import com.solvd.apitests.web.pages.common.SeleniumDynamicPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SeleniumDynamicPageBase.class)
public class SeleniumDynamicPage extends SeleniumDynamicPageBase {

    public SeleniumDynamicPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public void clickAddBoxButton(int times) {
        ExtendedWebElement boxButton = findExtendedWebElement(By.id("adder"));
        for (int i = 0; i < times; i++) {
            boxButton.hover();
            boxButton.click();
        }
    }

    @Override
    public List<ExtendedWebElement> getBoxes() {
        return this.findExtendedWebElements(By.xpath("//div[contains(@id, 'box')]"));
    }

    @Override
    public ExtendedWebElement getLastBox() {
        return this.findExtendedWebElement(By.xpath("//div[contains(@id, 'box')][last()]"));
    }
}
