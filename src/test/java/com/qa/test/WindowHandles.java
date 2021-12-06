package com.qa.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

class WindowHandles {

	@SuppressWarnings("deprecation")
	@Test
	public void windowHandle() throws Exception {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.tutorialspoint.com/index.htm");
		// getting the current window handle id
		String currentwindow = driver.getWindowHandle();
		// getting all the window handles in Set data structure
		Set<String> allWindows = driver.getWindowHandles();
		// traversing each ids with the help of iterator()
		Iterator<String> i = allWindows.iterator();
		// Iterating through the window handle ids
		while (i.hasNext()) {
			String childwindow = i.next();
			if (!childwindow.equalsIgnoreCase(currentwindow)) {
				driver.switchTo().window(childwindow);
				System.out.println("The child window is " + childwindow);
			} else {
				System.out.println("There are no children");
			}
		}
		driver.quit();
	}
}
