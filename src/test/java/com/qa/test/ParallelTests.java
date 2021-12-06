package com.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ParallelTests {

	@Test
	public void getChrome() { //
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe path"); //
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
		System.setProperty("webdriver.chrome.driver", "/Users/biswajit/Desktop/chromedriver.exe");
		System.out.println("GetChrome Method is running on Thread : " + Thread.currentThread().getId());
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.softwaretestingmaterial.com");
		driver.close();
	}

	@Test
	public void getFirefox() {
		// System.setProperty("webdriver.gecko.driver", "geckodriver.exe path");
		System.setProperty("webdriver.gecko.driver", "/Users/biswajit/Desktop/geckodriver.exe");
		System.out.println("GetFirefox Method is running on Thread : " + Thread.currentThread().getId());
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.softwaretestingmaterial.com");
		driver.close();
	}

}
