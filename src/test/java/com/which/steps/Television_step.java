package com.which.steps;

import com.which.Web.pages.Television_page;
import com.which.helpers.Log;
import com.which.helpers.WebCommonAction;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by roscian.frank on 05/04/2017.
 */
public class Television_step extends WebCommonAction {
    private String site = System.getProperty("site");

    @Given("^I am on television page$")
    public void iAmOnTelevisionPage() throws InterruptedException {
        driver.get(site);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, Television_page.class);
        Television_page.televisionSpan.click();
        Television_page.televisionPageLink.click();
        Assert.assertTrue(Television_page.allTelevisionTab.isDisplayed());
        Log.info("I am on television page");


    }

    @When("^I select screen size \"([^\"]*)\"$")
    public void iSelectScreenSize(String screenSize) throws Throwable {
        PageFactory.initElements(driver, Television_page.class);
        String xpathStr;
        switch (screenSize) {
            case "17-22":
                xpathStr = Television_page.screenXpath.replace("#", "54");
                driver.findElement(By.xpath(xpathStr)).click();
                break;
            case "24-32":
                xpathStr = Television_page.screenXpath.replace("#", "61");
                driver.findElement(By.xpath(xpathStr)).click();
                break;
            case "39-46":
                xpathStr = Television_page.screenXpath.replace("#", "68");
                driver.findElement(By.xpath(xpathStr)).click();
                break;
            case "47-50":
                xpathStr = Television_page.screenXpath.replace("#", "75");
                driver.findElement(By.xpath(xpathStr)).click();
                break;
            case "51-55":
                xpathStr = Television_page.screenXpath.replace("#", "82");
                driver.findElement(By.xpath(xpathStr)).click();
                break;
            case "60-65":
                xpathStr = Television_page.screenXpath.replace("#", "89");
                driver.findElement(By.xpath(xpathStr)).click();
                break;

            default:
                Assert.assertTrue("television size not found", false);
                break;
        }


    }

    @Then("^I check the correct \"([^\"]*)\" result are displayed$")
    public void iCheckTheCorrectResultAreDisplayed(String screenSize) throws Throwable {
        PageFactory.initElements(driver, Television_page.class);
        String xpathStr;
        switch (screenSize) {
            case "17-22":
                xpathStr = Television_page.modelNO.replace("#", "22HYC06U");
                Assert.assertTrue("Television not found", driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;
            case "24-32":
                xpathStr = Television_page.modelNO.replace("#", "32PFS6401/12");
                Assert.assertTrue("Television not found", driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;
            case "39-46":
                xpathStr = Television_page.modelNO.replace("#", "UE40KU6100");
                Assert.assertTrue("Television not found", driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;
            case "47-50":
                xpathStr = Television_page.modelNO.replace("#", "UE49KU6100");
                Assert.assertTrue("Television not found", driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;
            case "51-55":
                xpathStr = Television_page.modelNO.replace("#", "OLED55B6V");
                Assert.assertTrue("Television not found", driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;
            case "60-65":
                xpathStr = Television_page.modelNO.replace("#", "65UH615V");
                Assert.assertTrue("Television not found", driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;
            case "OLED":
                xpathStr = Television_page.modelNO.replace("#", "OLED55B6V");
                Assert.assertTrue("Television not found", driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;
            case "Plasma":
                xpathStr = Television_page.modelNO.replace("#", "PE43H4500");
                Assert.assertTrue("Television not found", driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;
            case "LED":
                xpathStr = Television_page.modelNO.replace("#", "UE55KU6020");
                Assert.assertTrue("Television not found", driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;
            case "Curved":
                xpathStr = Television_page.modelNO.replace("#", "UE40KU6100");
                Assert.assertTrue("Television not found", driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Correct television is displayed");
                break;

            default:
                Assert.assertTrue("television size not found", false);
                break;
        }
    }

    @When("^I select screen type \"([^\"]*)\"$")
    public void iSelectScreenType(String screenType) throws Throwable {
        PageFactory.initElements(driver, Television_page.class);
        String xpathStr;
        switch (screenType) {
            case "OLED":
                xpathStr = Television_page.screenXpath.replace("#", "373");
                driver.findElement(By.xpath(xpathStr)).click();
                Log.info("Television type selected");
                break;
            case "Plasma":
                xpathStr = Television_page.screenXpath.replace("#", "380");
                driver.findElement(By.xpath(xpathStr)).click();
                Log.info("Television type selected");
                break;
            case "LED":
                xpathStr = Television_page.screenXpath.replace("#", "387");
                driver.findElement(By.xpath(xpathStr)).click();
                Log.info("Television type selected");
                break;
            case "Curved":
                xpathStr = Television_page.screenXpath.replace("#", "394");
                driver.findElement(By.xpath(xpathStr)).click();
                Log.info("Television type selected");
                break;
            default:
                Assert.assertTrue("television type not found", false);
                break;
        }

    }

    @When("^I search television by \"([^\"]*)\"$")
    public void iSearchTelevisionBy(String sortBy) throws Throwable {
        PageFactory.initElements(driver, Television_page.class);
        Select dropdown = new Select(Television_page.product_listing_sorter);
        dropdown.selectByVisibleText(sortBy);
        Log.info("Product is selected from dropdown");

    }

    @Then("^I check the correct \"([^\"]*)\" result$")
    public void iCheckTheCorrectResult(String sortBy) throws Throwable {
        PageFactory.initElements(driver, Television_page.class);
        String xpathStr;
        switch (sortBy) {
            case "Price (low to high)":
                xpathStr = Television_page.productPrice.replace("#", "£99.99");
                Assert.assertTrue("Television not found", driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Television type selected");
                break;
            case "Price (high to low)":
                xpathStr = Television_page.productPrice.replace("#", "£24,999.00");
                Assert.assertTrue("Television not found", driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Television type selected");
                break;
            case "Screen size (high to low)":
                xpathStr = Television_page.productPrice.replace("#", "£9,999.00");
                Assert.assertTrue("Television not found", driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Television type selected");
                break;
            case "Most-recently launched":
                xpathStr = Television_page.productPrice.replace("#", "£629.00");
                Assert.assertTrue("Television not found", driver.findElement(By.xpath(xpathStr)).isDisplayed());
                Log.info("Television type selected");
                break;
            default:
                Assert.assertTrue("television type not found", false);
                break;
        }
    }

    @When("^I add product to compare$")
    public void iAddProductToCompare() throws Throwable {
        PageFactory.initElements(driver, Television_page.class);
        String WebStr = "(//*[@class='_3sLz3 action-add'])[";

        if(Television_page.addToCompare.size()>0){
            for(int i=1;i<5;i++){
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                        driver.findElement(By.xpath((WebStr+i+"]"))));
             driver.findElement(By.xpath((WebStr+i+"]"))).click();
             Thread.sleep(500);
            }

        }else{
            Assert.assertTrue("Not able to add product to comparision",false);
        }
        Log.info("Products are added to compare");
    }

    @Then("^I check the comparision$")
    public void iCheckTheComparision() throws Throwable {
        PageFactory.initElements(driver, Television_page.class);
        int arraySize = Television_page.compareArray.size();
        Assert.assertEquals(4,arraySize);
        Assert.assertTrue(isElementDisplay(Television_page.comparebutton));
        Log.info("Product compare model displayed");
    }
}
