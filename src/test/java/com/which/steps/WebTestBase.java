package com.which.steps;


import com.which.helpers.Log;
import com.which.helpers.WebCommonAction;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;



public class WebTestBase extends WebCommonAction{

	public static WebDriver driver;
	private static String chromeDriverMacPath = System.getProperty("user.dir")
			+ "/src/test/resources/chromeDriver/mac/chromedriver";
	private static String geckoDriver = System.getProperty("user.dir")
			+ "/src/test/resources/chromeDriver/mac/geckodriver";


	public static final String USERNAME = "roscianfrank1";
	public static final String AUTOMATE_KEY = "NsgsGgWfk5HDvA4gzQyV";
	public static final String url = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";

	public static boolean scenarioResult; public static String sessionId;


	@Before

	public void startApp() throws IOException, ParseException{
		//BrowserStackTesting();
		LocalTesting();

	}

	@After
	public void closeApp(Scenario scenario) throws IOException, URISyntaxException {

		if (scenarioResult=scenario.isFailed()) {
			try {
				sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
				System.out.println("Failed scenario ----->> "+scenario.getSourceTagNames());
				Log.info(("Failed scenario ----->> "+scenario.getSourceTagNames()));
				byte[] screenshot = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				Log.info("********************** -- TEST STOPPED ERROR OCCURED -- **************************");

			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots
						.getMessage());
			}
		}
		System.out.println("Reaching Closing BaseDriver");
		Log.info("********************** -- TEST END -- **************************");
		driver.quit();
	}


	public void BrowserStackTesting()throws IOException, ParseException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "firefox");
		capabilities.setCapability("resolution", "1920x1080");
		capabilities.setCapability("version", "46.0");
		capabilities.setCapability("os", "OS X");
		capabilities.setCapability("os_version", "El Capitan");
		capabilities.setCapability("browserstack.debug", "true");
		capabilities.setCapability("build", "QA-Web "+getCurrentDateDMY());
 		capabilities.setCapability("name", "Parallel Run");

		capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		try {
			driver = new RemoteWebDriver(new URL(url), capabilities);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		} catch (Exception e) {

		}
		driver.manage().window().maximize();
		Log.info("********************** -- TEST START -- **************************");
		System.out.println("reaching hooks / browserstack");
	}
	public void LocalTesting(){
		DesiredCapabilities dc = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", chromeDriverMacPath);
		driver = new ChromeDriver(dc);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Log.info("********************** -- TEST START -- **************************");
		System.out.println("reaching hooks / local");
	}

}
