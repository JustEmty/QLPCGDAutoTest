package timetableManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ImportTimetableTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);

		loginPage.loginToWebsite();
	}

	@Test
	public void TestCase1() throws InterruptedException {

		String filePath = "C:\\Users\\OS\\Downloads\\CNTT UIS-ThoiKhoaBieu_TieuChuan_Mau.xlsx";
		// Nhấn vào mục Thời khóa biểu
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[4]/a/span")).click();
		Thread.sleep(2000);
		// Chọn vào mục Phân Công
		webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[4]/ul/li[1]/a/span")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"select2-term-container\"]")).click();
		Thread.sleep(2000);
		WebElement chon_hk = webDriver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span[2]/span/span[1]/input"));
		Thread.sleep(2000);
		chon_hk.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
		Thread.sleep(2000);
		WebElement chon_nganh = webDriver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span[2]/span/span[1]/input"));
		Thread.sleep(2000);
		chon_nganh.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"dpz-single-file\"]/div")).click();
		Thread.sleep(2000);
		// Khởi tạo Robot class
		Robot rb = null;
		try {
			rb = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		// Copy File path vào Clipboard
		StringSelection str = new StringSelection
				(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		Thread.sleep(2000);

		// Nhấn Control+V để dán
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		// Xác nhận Control V trên
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		Thread.sleep(2000);

		// Nhấn Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(4000);
		webDriver.findElement(By.xpath("//*[@id=\"submit-all\"]")).click();

	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
