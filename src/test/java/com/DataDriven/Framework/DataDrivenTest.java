package com.DataDriven.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataDrivenTest {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void initialization() {
		// To set the path of the Chrome driver.
		/*
		 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		 * + "\\src\\test\\java\\drivers\\chromedriver.exe");
		 */
		driver = new ChromeDriver();

		// To launch facebook
		driver.get("https://www.browserstack.com/users/sign_in");
		// To maximize the browser
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void fbLoginLogout() throws IOException, InterruptedException {
		// Import excel sheet.
		File src = new File(
				"C:\\Users\\biswajit\\Desktop\\eclipse-workspace3\\testngMaven\\src\\test\\java\\com\\DataDriven\\Framework\\TestData.xlsx");
		// Load the file.
		FileInputStream fis = new FileInputStream(src);
		// Load he workbook.
		workbook = new XSSFWorkbook(fis);
		// Load the sheet in which data is stored.
		sheet = workbook.getSheetAt(0);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			/*
			 * I have added test data in the cell A2 as "testemailone@test.com" and B2 as
			 * "password" Cell A2 = row 1 and column 0. It reads first row as 0, second row
			 * as 1 and so on and first column (A) as 0 and second column (B) as 1 and so on
			 */

			// Import data for Email.
			cell = sheet.getRow(i).getCell(0);
			cell.setCellType(CellType.STRING);
			// System.out.println(cell);
			driver.findElement(By.name("user[login]")).clear();
			driver.findElement(By.name("user[login]")).sendKeys(cell.getStringCellValue());

			// Import data for password.
			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(CellType.STRING);

			driver.findElement(By.name("user[password]")).clear();
			driver.findElement(By.name("user[password]")).sendKeys(cell.getStringCellValue());
			// To click on Login button
			driver.findElement(By.name("commit")).click();
			Thread.sleep(5000);
			String title = driver.getTitle();
			System.out.println(title);
			// Assert.assertTrue(driver.getTitle().contains("BrowserStack"));
			if (title.contains("Dashboard")) {
				// To write data in the excel
				FileOutputStream fos = new FileOutputStream(src);
				// Message to be written in the excel sheet
				String message = "Pass";
				// Create cell where data needs to be written.
				sheet.getRow(i).createCell(2).setCellValue(message);

				// finally write content
				workbook.write(fos);
				// To click on Account settings dropdown
				WebElement mainMenu = driver.findElement(By.id("account-menu-toggle"));
				Actions actions = new Actions(driver);
				actions.moveToElement(mainMenu);
				WebElement logout = driver.findElement(By.id("sign_out_link"));
				actions.moveToElement(logout);
				actions.click().build().perform();
				driver.findElement(By.xpath(
						"//li[@class='sign-in-link hide-xs hide-sm']//a[@title='Sign In'][normalize-space()='Sign in']"))
						.click();
				// close the file
				fos.close();
				continue;

			} else {
				// To write data in the excel
				FileOutputStream fos = new FileOutputStream(src);
				// Message to be written in the excel sheet
				String message = "Fail";
				// Create cell where data needs to be written.
				sheet.getRow(i).createCell(2).setCellValue(message);

				// finally write content
				workbook.write(fos);
				// close the file
				fos.close();
				//break;
				driver.navigate().refresh();
				Thread.sleep(5000);

			}
			/*
			 * //System.out.println("Login successful"); WebElement mainMenu =
			 * driver.findElement(By.id("account-menu-toggle")); Actions actions = new
			 * Actions(driver); actions.moveToElement(mainMenu); WebElement logout =
			 * driver.findElement(By.id("sign_out_link")); actions.moveToElement(logout);
			 * actions.click().build().perform(); driver.findElement(By.xpath(
			 * "//li[@class='sign-in-link hide-xs hide-sm']//a[@title='Sign In'][normalize-space()='Sign in']"
			 * )) .click();
			 */
		}
	}

}