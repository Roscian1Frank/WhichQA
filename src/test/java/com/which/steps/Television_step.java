package com.which.steps;

import com.which.Web.pages.Television_page;
import com.which.helpers.Log;
import com.which.helpers.WebCommonAction;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by roscian.frank on 05/04/2017.
 */
public class Television_step extends WebCommonAction {
    private String site = System.getProperty("site");
    @Given("^I am on television page$")
    public void iAmOnTelevisionPage() throws InterruptedException {
        driver.get(site);
        PageFactory.initElements(driver,Television_page.class);
        Television_page.televisionSpan.click();
        Television_page.televisionPageLink.click();
        Assert.assertTrue(Television_page.allTelevisionTab.isDisplayed());
        Log.info("I am on television page");


    }

    @When("^I select screen size \"([^\"]*)\"$")
    public void iSelectScreenSize(String screenSize) throws Throwable {
        PageFactory.initElements(driver,Television_page.class);
        String xpathStr;
        switch (screenSize) {
            case "17-22":
                xpathStr=Television_page.screenXpath.replace("#","54");
                driver.findElement(By.xpath(xpathStr)).click();
                break;
            case "24-32":
                xpathStr=Television_page.screenXpath.replace("#","61");
                driver.findElement(By.xpath(xpathStr)).click();
                break;
            case "39-46":
                xpathStr=Television_page.screenXpath.replace("#","68");
                driver.findElement(By.xpath(xpathStr)).click();
                break;
            case "47-50":
                xpathStr=Television_page.screenXpath.replace("#","75");
                driver.findElement(By.xpath(xpathStr)).click();
                break;
            case "51-55":
                xpathStr=Television_page.screenXpath.replace("#","82");
                driver.findElement(By.xpath(xpathStr)).click();
                break;
            case "60-65":
                xpathStr=Television_page.screenXpath.replace("#","89");
                driver.findElement(By.xpath(xpathStr)).click();
                break;

                default:
                    Assert.assertTrue("television size not found",false);
                    break;
        }


    }

    @Then("^I check the correct \"([^\"]*)\" result are displayed$")
    public void iCheckTheCorrectResultAreDisplayed(String screenSize) throws Throwable {
        PageFactory.initElements(driver,Television_page.class);
        String xpathStr;
        switch (screenSize) {
            case "17-22":
                xpathStr=Television_page.modelNO.replace("#","22HYC06U");
                Assert.assertTrue("Television not found",driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;
            case "24-32":
                xpathStr=Television_page.modelNO.replace("#","32PFS6401/12");
                Assert.assertTrue("Television not found",driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;
            case "39-46":
                xpathStr=Television_page.modelNO.replace("#","UE40KU6100");
                Assert.assertTrue("Television not found",driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;
            case "47-50":
                xpathStr=Television_page.modelNO.replace("#","UE49KU6100");
                Assert.assertTrue("Television not found",driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;
            case "51-55":
                xpathStr=Television_page.modelNO.replace("#","OLED55B6V");
                Assert.assertTrue("Television not found",driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;
            case "60-65":
                xpathStr=Television_page.modelNO.replace("#","65UH615V");
                Assert.assertTrue("Television not found",driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;

            default:
                Assert.assertTrue("television size not found",false);
                break;
        }
    }

    @When("^I select screen type \"([^\"]*)\"$")
    public void iSelectScreenType(String screenType) throws Throwable {
        PageFactory.initElements(driver,Television_page.class);
        String xpathStr;
        switch (screenType) {
            case "OLED":
                xpathStr = Television_page.screenXpath.replace("#", "54");
                driver.findElement(By.xpath(xpathStr)).click();
                break;
            case "Plasma":
                xpathStr = Television_page.screenXpath.replace("#", "61");
                driver.findElement(By.xpath(xpathStr)).click();
                break;
            case "LED":
                xpathStr = Television_page.screenXpath.replace("#", "68");
                driver.findElement(By.xpath(xpathStr)).click();
                break;
            case "Curved":
                xpathStr = Television_page.screenXpath.replace("#", "75");
                driver.findElement(By.xpath(xpathStr)).click();
                break;


            default:
                Assert.assertTrue("television type not found", false);
                break;
        }
    }
}
