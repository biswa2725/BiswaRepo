package com.baseclassConcept.org;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class InvalidLogin extends BaseClass {

	@Test(description = "This TC will perform valid login")
	public void loginToApplication() throws Throwable {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("biswajit.bishoyee@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("lucky_2725");
		driver.findElement(By.xpath("//button[@id='login-button']")).click();
		driver.findElement(By.xpath("//a[@id='profile__dropdown']")).click();
		driver.findElement(By.xpath("//a[@id='app__logout']")).click();
		Thread.sleep(5000);
	}

	@Test(description = "This TC will perform invalid login")
	public void loginToApplication1() {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("biswajit.bishoyee@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("lucky_275");
		driver.findElement(By.xpath("//button[@id='login-button']")).click();
	}

}