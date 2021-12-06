package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Log4jTest {

	WebDriver driver;
	// Define the Logger object to create own logs
	Logger log = Logger.getLogger(Log4jTest.class);

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setup() {
		// System.setProperty("webdriver.chrome.driver",
		// "E:chromedriverchromedriver.exe");
		driver = new ChromeDriver();
		log.info("Chrome Opened");
		driver.manage().window().maximize(); // maximize the browser
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); // define default page time out. Till this
																			// time selenium will wait for the element
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com");
	}

	@Test
	public void testContactUsLink() {
		boolean isLinkPresent = driver.findElement(By.xpath("//a[@title='Contact Us']")).isDisplayed();
		try {
			if (!isLinkPresent) {
				log.error("Not Found");
			} else {
				Assert.assertTrue(isLinkPresent);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testCartValue() {
		String cartValue = driver.findElement(By.xpath("//span[@class='ajax_cart_no_product']")).getText();
		Assert.assertEquals(cartValue, "(empty)");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}