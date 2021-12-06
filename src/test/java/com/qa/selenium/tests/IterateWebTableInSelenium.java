package com.qa.selenium.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class IterateWebTableInSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a new Instance for Chrome Browser
		WebDriver driver = new ChromeDriver();

		driver.get("https://myskillpoint.com/handle-dynamic-web-tables-in-selenium-webdriver/");

		List<WebElement> rowElements = driver.findElements(By.xpath("//table[@id='tablepress-7']//tbody/tr"));
		int iRowCount = rowElements.size();

		List<WebElement> headerElements = driver.findElements(By.xpath("//table[@id='tablepress-7']//thead/tr/th"));
		int icolCount = headerElements.size();

		for (int i = 1; i <= iRowCount; i++) {
			System.out.println("Printing values for Row Number: " + i);
			for (int j = 1; j <= icolCount; j++) {
				System.out.println("Table Cell Values for row column (" + i + "," + j + "): "
						+ driver.findElement(By.xpath("//table[@id='tablepress-7']//tbody/tr[" + i + "]/td[" + j + "]"))
								.getText());
			}
		}

	}
}
