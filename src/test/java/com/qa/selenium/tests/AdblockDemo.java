package com.qa.selenium.tests;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AdblockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		
		options.addExtensions(new File("/Users/biswajit/Downloads/extension_2_33_2_0.crx"));
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		options.merge(capabilities);
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		// driver.quit();
	}

}
