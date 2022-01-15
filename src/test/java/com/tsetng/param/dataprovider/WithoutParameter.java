package com.tsetng.param.dataprovider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WithoutParameter {
	WebDriver driver;

	@SuppressWarnings("deprecation")
	@Test
	public void noParam() {
		// Declaring our first keyword
		String keyWord = "Selenium";
		// Initializing Driver
		// System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// Opening search engine
		driver.get("https://google.com");
		// Finding search text box
		WebElement searchBox = driver.findElement(By.name("q"));
		// Sending keyword value
		searchBox.sendKeys(keyWord);
		System.out.println("The search keyword entered is : " + keyWord);
		// Verifying the keyword on UI
		Assert.assertTrue(searchBox.getAttribute("value").equalsIgnoreCase(keyWord));
		driver.quit();
	}
}