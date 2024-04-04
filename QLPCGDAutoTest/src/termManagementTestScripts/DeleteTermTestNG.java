package termManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DeleteTermTestNG {

	// ERROR!!!!

	private WebDriver webDriver;
	private LoginPage loginPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);

		loginPage.loginToWebsite();
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void TestCase1() throws InterruptedException {
		// Chọn mục Học Kỳ và Ngành
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
		Thread.sleep(2000);

		// Nhấn nút xóa học kỳ
		webDriver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr[1]/td[9]/a[2]")).click();
		Thread.sleep(2000);

		// Nhấn xóa
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
	}

	@Test
	public void TestCase2() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(2000);

		// Nhấn nút xóa học kỳ
		webDriver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr[1]/td[9]/a[2]")).click();
		Thread.sleep(2000);

		// Nhấn hủy
		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]")).click();

	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
	}
}
