package com.which.helpers;

import org.openqa.selenium.WebDriver;

public class HelperBase {

	protected WebDriver driver;

	// public static Properties prop;

	public HelperBase(WebDriver driver) {
		this.driver = driver;
	}

}
