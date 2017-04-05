package com.which.Web.pages;

import com.which.helpers.HelperBase;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.cert.X509Certificate;

/**
 * Created by roscian.frank on 05/04/2017.
 */
public class Television_page extends HelperBase {
    public Television_page(WebDriver driver) {
        super(driver);
    }
    String screnSize;

    //Navigation tab
    @FindBy(xpath = "//*[@class='gn-top-level-menu__link-title'][contains(.,\"Technology\")]")
    public static WebElement televisionSpan;

    @FindBy(xpath = "//*[@class='gn-link-group__link'][contains(.,\"Televisions\")]")
    public static WebElement televisionPageLink;

    @FindBy(xpath = "//*[@class='_1lOYS _2vMJc'][contains(.,\"All Televisions\")]")
    public static WebElement allTelevisionTab;

    @FindBy(xpath = "//*[@data-reactid='"+"#"+"']")
    public static WebElement screenSize;

    public static String screenXpath = "//*[@data-reactid='"+"#"+"']";

    public static String modelNO="//*[@class='_2NkKN'][contains(.,'"+"#"+"')]";
}
