package com.which.helpers;

import com.which.steps.WebTestBase;
import com.google.common.base.Function;
import org.apache.commons.lang.RandomStringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WebCommonAction {

    public WebDriver driver;
    public Properties prop;
    private String site = System.getProperty("site");

    public WebCommonAction() {
        driver = WebTestBase.driver;
    }

    public static int minorAge = 0;
    public static String promoCodeName;
    public static String consultant_name;
    public static String appointmentTime;
    public static String userLoginPage;

    public void init() {
        if (prop == null) {
            String path = System.getProperty("user.dir")
                    + "/src/test/resources/testData/userData.properties";
            prop = new Properties();
            try {
                FileInputStream fs = new FileInputStream(path);
                prop.load(fs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public String getRandomEmail() {
        String alphaNumeric = RandomStringUtils.randomAlphanumeric(10);
        return alphaNumeric + "@example.com";
    }

    public String getRandomFirstName() {
        String[] firstName = {"Abraham", "Barry", "Casper", "Darian", "Edwin", "Floyd", "Gabriel", "Herbert", "Jerome", "Keegan", "Marvin", "Solomon"};
        int idx = new Random().nextInt(firstName.length);
        String randomFirstName = (firstName[idx]);
        return randomFirstName;
    }

    public String getRandomLastName() {
        String[] lastName = {"Wright", "Johnson", "Rogers", "Cook", "Simmons", "Carter", "Thomas", "Taylor", "Parker", "Russell", "Gonzales", "Watson"};
        int idx = new Random().nextInt(lastName.length);
        String randomLastName = (lastName[idx]);
        return randomLastName;
    }

    public String getRandomRwandaPhoneno() {
        Random rnd = new Random();
        int phoneNoInt = 100000 + rnd.nextInt(899999);
        String phoneNoStr = "788" + Integer.toString(phoneNoInt);
        return phoneNoStr;
    }

    public static String getRandomNID() {
        Random rnd = new Random();
        int nid = 100000 + rnd.nextInt(899999);
        String nid_Str = "788" + Integer.toString(nid);
        return nid_Str;
    }

    public void driverWaitClick(WebElement mobEle, int waitSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(mobEle));
    }


    public void click(WebElement web_ele) {
        try {
            new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.elementToBeClickable(web_ele));
            web_ele.click();

        } catch (Exception e) {
            Assert.assertTrue("Not able to find the element", false);
        }
    }

    public void input_text(WebElement inputEle, String inputStr) {

        try {
            new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOf(inputEle));
            inputEle.click();
            inputEle.clear();
            inputEle.sendKeys(inputStr);
        } catch (Exception e) {
            Assert.assertTrue("Not able to find the element", false);
        }
    }

    public boolean isElementDisplayFluentWait(WebElement obj_ele) {
        try {
            new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOf(obj_ele));
            return true;

        } catch (Exception e) {
            Assert.assertTrue("Element not found ", false);
            return false;
        }

    }

    public void clickTickMark(WebElement mobile_ele) {

        mobile_ele.click();
    }

    // web action commands


    public void inputBox(WebDriver driver, WebElement web_ele, String inputText) {
        web_ele.sendKeys(inputText);
    }


    public String getTomorrowDate() {
        Date dt = new Date();
        DateTime dtOrg = new DateTime(dt);
        DateTime dtPlusOne = dtOrg.plusDays(1);
        String appDate = changeDateFormat(dtPlusOne.toString(), new Locale("zh", "UK"));
        return appDate;
    }

    public String getTomorrowDayNumber() {
        Date dt = new Date();
        DateTime dtOrg = new DateTime(dt);
        DateTime dtPlusOne = dtOrg.plusDays(1);
        String tomorrowDate = changeDateFormat(dtPlusOne.toString(), new Locale("zh", "UK"));

        String[] appDateBuf2 = tomorrowDate.split("/");
        String appDateBufStr = appDateBuf2[0];
        int appDayInt = Integer.parseInt(appDateBufStr);
        //System.out.println(appDateBufStr);
        return appDateBufStr;
    }

    public int getTomorrowMonthNumber() {

        Date dt = new Date();
        DateTime dtOrg = new DateTime(dt);
        DateTime dtPlusOne = dtOrg.plusDays(1);
        String tomorrowDate = changeDateFormat(dtPlusOne.toString(), new Locale("zh", "UK"));
        String[] appDateBuf2 = tomorrowDate.split("/");
        String appDateBufStr = appDateBuf2[1];
        int appMonInt = Integer.parseInt(appDateBufStr);
        int i = (int) Math.round(appMonInt);
        return i;
    }

    public String addHour() {
        Log.info("Add a hour to current time hours");
        String currentTimeStr = getTodayDate();
        String[] timeStrBuf = currentTimeStr.split(" ");
        String dateStr1 = timeStrBuf[0];
        String timeStr = timeStrBuf[1];
        String[] timeStr1Buf = timeStr.split(":");
        String hourStr = timeStr1Buf[0];
        int hourInt = Integer.parseInt(hourStr);
        int setHour;
//        if(hourInt>=23){
//            setHour = 0;
//            String passHourStr = String.valueOf(setHour);
//            return passHourStr;
//
//        }else{
        setHour = hourInt + 1;
        String passHourStr = String.valueOf(setHour);
        if (passHourStr.length() == 1)
            passHourStr = "0" + passHourStr;
        return passHourStr;

        //}
        //return "null";

    }

    public String addHour(String hhmm, int hours) {
        Log.info("Add a hour to time parameter");
        String timeStr = hhmm;
        String[] timeStr1Buf = timeStr.split(":");
        String hourStr = timeStr1Buf[0];
        int hourInt = Integer.parseInt(hourStr);
        int setHour;

        setHour = hourInt + hours;
        String passHourStr = String.valueOf(setHour);
        if (passHourStr.length() == 1)
            passHourStr = "0" + passHourStr;
        passHourStr = passHourStr + ":" + timeStr1Buf[1];
        return passHourStr;

    }

    public String hourTime(int noOfHrs) {
        Log.info("Add a hour to current time hours");
        Random random = new Random();
        String currentTimeStr = getTodayDate();
        String[] timeStrBuf = currentTimeStr.split(" ");
        String dateStr1 = timeStrBuf[0];
        String timeStr = timeStrBuf[1];

        String[] timeStr1Buf = timeStr.split(":");
        String hourStr = timeStr1Buf[0];
        int hourInt = Integer.parseInt(hourStr);
        int setHour;
        setHour = hourInt + noOfHrs;
        int minutesInt = random.nextInt(5) * 10;
        String minutesStr = Integer.toString(minutesInt);
        if (minutesStr.length() == 1) {
            minutesStr = "0" + minutesStr;
        }
        String passHourStr = setHour + ":" + minutesStr;
        Log.info("Appointment time: " + passHourStr);
        return passHourStr;


    }


    public BigDecimal percentage_cal(String promoCode, String pcodePrice) {

        // init();
        String proCode = promoCode;
        double disPrecentage = Float.parseFloat(proCode);
        String atualPriceStr = pcodePrice;
        Float atualPrice = Float.parseFloat(atualPriceStr);
        // double disPrecEquation = disPrecentage/100;
        double disPrice = (disPrecentage / 1) * atualPrice;
        double totalDisPrice = atualPrice - disPrice;

        System.out.println(disPrice);
        System.out.println(totalDisPrice);

        BigDecimal afterDiscount = new BigDecimal(
                Double.toString(totalDisPrice));
        afterDiscount = afterDiscount.setScale(2, BigDecimal.ROUND_HALF_UP);

        return afterDiscount;

    }

    public Boolean isTodaydateGreaterThanAppointmentDate(String tomorrowDate) {
        //String appDate = "16/01/2016";
        String[] appDateBuf2 = tomorrowDate.split("/");
        String appDateBufStr = appDateBuf2[0];
        int appDayInt = Integer.parseInt(appDateBufStr);

        Date dt = new Date();
        DateTime dtOrg = new DateTime(dt);
        String curDate = changeDateFormat(dtOrg.toString(), new Locale("zh", "UK"));
        String[] todayDateBuf2 = curDate.split("/");
        String todayDateBufStr = todayDateBuf2[0];
        int todayDayInt = Integer.parseInt(todayDateBufStr);
        System.out.println("App Date = " + appDayInt + "  Today Date = " + todayDayInt);

        if (appDayInt > todayDayInt)
            return true;
        else
            return false;


    }

    public String changeDateFormat(String inputdate, Locale locale) {

        Date date = new Date();
        SimpleDateFormat dateFormatCN = new SimpleDateFormat("dd/MM/yyyy", locale);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        try {
            date = dateFormat.parse(inputdate);
        } catch (ParseException e) {
            //log.warn("Input date was not correct. Can not localize it.");
            return inputdate;
        }
        return dateFormatCN.format(date);
    }


    public Integer calculateAge(String dateOfBirth)
            throws ParseException {

        SimpleDateFormat formaterIn = new SimpleDateFormat("dd/MM/yyyy");
        Date d = formaterIn.parse(dateOfBirth);

        // String strDate = new SimpleDateFormat("dd/MMM/yyyy").format(d);
        String month = new SimpleDateFormat("MM").format(d);
        String day = new SimpleDateFormat("dd").format(d);
        String year = new SimpleDateFormat("yyyy").format(d);
        System.out.println(day + month + year);
        int ageYear = Integer.parseInt(year);
        int ageMonth = Integer.parseInt(month);
        int ageDay = Integer.parseInt(day);

        LocalDate birthdate = new LocalDate(ageYear, ageMonth, ageDay);
        LocalDate now = new LocalDate();
        Years age = Years.yearsBetween(birthdate, now);
        String ageStr = age.toString();

        String[] ageStrBuf = ageStr.split("P");
        String ageStr2 = ageStrBuf[1];
        String[] age2StrBuf = ageStr2.split("Y");
        String ageStr3 = age2StrBuf[0];

        int ageInt = Integer.parseInt(ageStr3);
        System.out.println("Age = " + age);
        minorAge = ageInt;
        return ageInt;

    }

    public String todayDay() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String dateStr = dateFormat.format(date);
        String str1[] = dateStr.split("/");
        String str2 = str1[0];
        System.out.println(str2);
        return str2;
    }

    public String getTodayDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateStr = dateFormat.format(date);
        return dateStr;
    }

    public String getCurrentDateDDMY() {
        //e.g Tue, 07 Jun 2016

        DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getCurrentDateDMY() {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String changeTimetoAMPM(String time) throws ParseException {
        SimpleDateFormat displayFormat = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat parseFormat = new SimpleDateFormat("HH:mm");
        Date date = parseFormat.parse(time);
        System.out.println(parseFormat.format(date) + " = " + displayFormat.format(date));
        String timeChange = displayFormat.format(date);
        //replace 0 in time
        //String timeChange = displayFormat.format(date);
        char c = timeChange.charAt(0);

        String string1 = Character.toString(c);
        if (string1.equals("0")) {
            System.out.println(timeChange.substring(1));
            return timeChange.substring(1);
        } else
            return timeChange;

    }

    public String changeTime(String time) throws ParseException {
        SimpleDateFormat displayFormat = new SimpleDateFormat("hh:mm");
        SimpleDateFormat parseFormat = new SimpleDateFormat("HH:mm");
        Date date = parseFormat.parse(time);
        System.out.println(parseFormat.format(date) + " = " + displayFormat.format(date));
        String timeChange = displayFormat.format(date);
        //replace 0 in time
        //String timeChange = displayFormat.format(date);
        char c = timeChange.charAt(0);

        String string1 = Character.toString(c);
        if (string1.equals("0")) {
            System.out.println(timeChange.substring(1));
            return timeChange.substring(1);
        } else
            return timeChange;

    }

    public Boolean isLoaded(WebElement mobEle) {
        Boolean loaded = false;
        try {
            loaded = mobEle.isDisplayed();
        } catch (NotFoundException e) {
            System.out.print(e);
        }
        return loaded;
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

    public boolean isElementClickable(WebElement display_ele) {
        try {
            Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);
            wait1.until(ExpectedConditions.elementToBeClickable(display_ele));

            if (display_ele.isDisplayed())
                return true;
            else
                return false;

        } catch (Exception e) {
            return false;
        }

    }

    // Login using Email ID
    public void doLoging(String emailID, String login_pass) throws Throwable {


    }


    public static void clickByElementAcceptRefreshAlert(WebDriver driver, By byElement) throws InterruptedException {

        WebElement webElement = driver.findElement(byElement);
        clickWebElementAcceptRefreshAlert(driver, webElement);
    }


    public static void clickWebElementAcceptRefreshAlert(WebDriver driver, WebElement webElement) throws InterruptedException {
        try {
            try {
                Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS)
                        .pollingEvery(1, TimeUnit.SECONDS)
                        .ignoring(NoSuchElementException.class);
                wait1.until(ExpectedConditions.visibilityOf(webElement));

                if (webElement.isDisplayed())
                    Assert.assertTrue(true);
                else
                    Assert.assertTrue(false);

            } catch (Exception e) {

            }
            webElement.click();
            Thread.sleep(3000);
        } catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                if (alertText.equalsIgnoreCase("An error ocurred, please refresh the page and try again.")) {
                    alert.accept();
                    driver.navigate().refresh();
                } else
                    Assert.assertTrue(alertText, false);
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }

    }

    public void waitForPageToLoad() {

        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return (document.readyState == 'complete')")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return (document.readyState == 'complete')"))
                        .equals("true");
            }
        });
    }

    public boolean compareCheckBoxValue(String cellValue) {
        if (cellValue.contains("0")) {
            return false;
        } else if (cellValue.contains("1")) {
            return true;
        } else {
            Assert.assertTrue("Wrong value on Excel sheet :->" + cellValue, false);
            return Boolean.parseBoolean(null);
        }
    }

    public void pageLoadComplete() {

        try {
            Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(5, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);
            wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className(".loading-spinner-container")));
        } catch (Exception e) {

        }
    }


}
