package com.which.helpers;

import com.which.steps.WebTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.concurrent.TimeUnit;

public class WebCommonAction {

    public WebDriver driver;
    public WebCommonAction() {
        driver = WebTestBase.driver;
    }
    public boolean isElementDisplay(WebElement display_ele) {
        try {
            Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);
            // .until(ExpectedConditions.visibilityOf(display_ele));
            wait1.until(ExpectedConditions.visibilityOf(display_ele));

            if (display_ele.isDisplayed())
                return true;
            else
                return false;

        } catch (Exception e) {
            return false;
        }

    }
}
