package com.qa.test;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.ous.jtoml.ParseException;

public class LinksInaPage {
	WebDriver driver;

	@SuppressWarnings("deprecation")
	@Test
	public void enterText() throws InterruptedException, ParseException {

		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver",
				"/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver");

		driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> links = driver.findElements(By.xpath("//a"));

		System.out.println(links.size());
		ArrayList<String> data = new ArrayList<String>();
		for (int i = 0; i < links.size(); i++) {

			System.out.println(links.get(i).getText());

			data.add(links.get(i).getAttribute("href"));

			System.out.println(links.get(i).getAttribute("href"));
		}

		System.out.println(data.size());

	}
}