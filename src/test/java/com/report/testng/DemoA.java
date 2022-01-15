package com.report.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoA {

	@Test
	public void run() {
		WebDriver driver = new ChromeDriver();
		Reporter.log("The is opened now");
		driver.manage().window().maximize();
		Reporter.log("Browser window maximized");
		driver.get("https://www.google.com");
		Reporter.log("Google lunched");
		driver.findElement(By.name("q")).sendKeys("Hi");
		Reporter.log("The data \"Hi\" is entered.");
	}
}
