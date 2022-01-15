package com.tsetng.param.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClassLevelDataProvider {
	WebDriver driver;

	@Test(dataProvider = "searchText", dataProviderClass = DataProviderClass.class)
	public void paramByDataProvider(String monument, String city) throws InterruptedException {
		// Initializing Driver
		// System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new ChromeDriver();
		// Opening search engine
		driver.get("https://google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys(monument + " " + city);
		System.out.println("You are trying to search " + monument + " which is in " + city);

		WebElement srchBtn = driver.findElement(By.name("btnK"));
		srchBtn.submit();
		Thread.sleep(3000);
		System.out.println("The page title is: " + driver.getTitle());
		driver.quit();
	}
}