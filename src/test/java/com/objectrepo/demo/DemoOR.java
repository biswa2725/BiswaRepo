package com.objectrepo.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;		
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoOR {

	public static void main(String[] args) throws IOException {
		// Create WebDriver Instance
		WebDriver driver;
		// ystem.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		// Load the properties File
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\app.properties");
		obj.load(objfile);
		// Navigate to link Mobile Testing and Back
		driver.findElement(By.xpath(obj.getProperty("MobileTesting"))).click();
		driver.navigate().back();
		// Enter Data into Form
		driver.findElement(By.id(obj.getProperty("EmailTextBox"))).sendKeys("testguru99@gmail.com");
		driver.findElement(By.id(obj.getProperty("SignUpButton"))).click();
	}

}