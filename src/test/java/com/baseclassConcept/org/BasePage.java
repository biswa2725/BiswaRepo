package com.baseclassConcept.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	// Declare the WebDriver
	public static WebDriver driver;

	// constructor of base class
	public BasePage() {

		if (driver == null) {
			// Set the path for chromedriver

			driver = new ChromeDriver();

			// go to application
			driver.get("http://automationpractice.com/index.php");
			driver.manage().window().maximize();
		}

	}

}