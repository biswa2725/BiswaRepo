package com.calender.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Example7 {

	WebDriver driver;

	String month = "January 2022";
	String date = "20";

	@Test
	public void enterText() throws InterruptedException {

		// First step set the driver location
		// For Window user
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/bsingh5/Documents/coreJava/selenium/drivers/chromedriver.exe");

		driver = new ChromeDriver();

		// navigate to site
		driver.get("http://www.phptravels.net/");

		// click on calendar
		driver.findElement(By.xpath("//input[@id='checkin']")).click();

		// get web element of month
		WebElement mon = driver.findElement(
				By.xpath("//div[@class='datepicker dropdown-menu'][1]//div[1]//table//thead//tr[1]//th[2]"));
		while (true) {
			// if given month matches break the while loop
			if (mon.getText().equals(month)) {
				break;
			}
			// if given month matches click on next
			else {
				driver.findElement(
						By.xpath("//div[@class='datepicker dropdown-menu'][1]/div[1]/table/thead/tr[1]/th[3]")).click();
				Thread.sleep(1000);
			}
		}

		// click on date
		driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][1]/div[1]/table/tbody/tr/td[contains(text(),'"+date+"')]")).click();

	}
}
