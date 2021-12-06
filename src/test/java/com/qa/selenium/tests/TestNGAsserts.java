package com.qa.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestNGAsserts {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		// Test Condition 1: If Page title matches with actualTitle then it finds email
		// title and enters the value which we pass
		driver.get("https://www.gmail.com");
		String actualTitle = "Gmail";
		Assert.assertEquals(driver.getTitle(), actualTitle);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("SoftwareTestingMaterial.com");
		// Test Condition 2: If page title didnt match with actualTitle then script
		// throws an exception
		Thread.sleep(2000);
		driver.get("https://www.gmail.com");
		actualTitle = "GoogleMail";
		Thread.sleep(2000);
		// Assert.assertEquals(driver.getTitle(), actualTitle, "Title not matched");
		Assert.assertEquals(driver.getTitle(), actualTitle);

	}

}
