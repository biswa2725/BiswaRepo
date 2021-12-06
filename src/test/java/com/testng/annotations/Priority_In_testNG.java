package com.testng.annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority_In_testNG {
	WebDriver driver;

	// Method 1: Open Browser say Chrome
	@Test(priority = 1, description = "Method 1: Open Browser say Chrome")
	public void openBrowser() {
		Reporter.log("\n Open Browser say Chrome", true);
		driver = new ChromeDriver();
	}

	// Method 2: Launch Google.com
	@Test(priority = 2, description = " Method 2: Launch Google.com")
	public void launchGoogle() {
		Reporter.log("\n Launch Google.com", true);
		driver.get("http://www.google.co.in");
	}

	// Method 3: Perform a search using "Facebook"
	@Test(priority = 3, description = " Method 3: Perform a search using \"Facebook\"")
	public void peformSeachAndClick1stLink() {
		Reporter.log("\n  Perform a search using \"Facebook\"", true);
		driver.findElement(By.xpath(".//*[@title='Search']")).sendKeys("Facebook");
	}

	// Method 4: Verify Google search page title.
	@Test(priority = 4, description = " Method 4: Verify Google search page title.")
	public void FaceBookPageTitleVerification() throws Exception {
		Reporter.log("\n  Verify Google search page title", true);
		driver.findElement(By.xpath(".//*[@title='Search']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle().contains("Facebook - Google Search"), true);
	}
}
