package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ViewListOfRemunerationCoefficientInYearTestNG {

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
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Nhấn vào mục Thù lao
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a")).click();
		Thread.sleep(2000);
		// Chọn vào mục Đơn giá & hệ số
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[2]/a/span")).click();
		Thread.sleep(2000);
		String ExpectTitle = "Quản lý đơn giá & hệ số";
		String ActualTitle = webDriver.getTitle().toString();
		if (ActualTitle.contentEquals(ExpectTitle)) {
			System.out.println("Pass");
			System.out.println("Title mong đợi là: " + ExpectTitle);
			System.out.println("Title thực tế là: " + ActualTitle);
		} else {
			System.out.println("Fail");
			System.out.println("Title mong đợi là: " + ExpectTitle);
			System.out.println("Title thực tế là: " + ActualTitle);
		}
		;
	}

	@Test
	public void TestCase2() throws InterruptedException {
		// Tải lại trang
		webDriver.navigate().refresh();
		Thread.sleep(2000);

		// Scroll page xuống và lên theo chiều dọc
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 4000)", "");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -2000)", "");
		Thread.sleep(2000);
	}

	@Test
	public void TestCase3() throws InterruptedException {
		// Tải lại trang
		webDriver.navigate().refresh();
		Thread.sleep(2000);

		// Scroll page xuống theo chiều dọc và nhấn nút Trở lại đầu trang
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 4000)", "");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[2]/button")).click();
		Thread.sleep(2000);
	}

	@Test
	public void TestCase4() throws InterruptedException {
		// Tải lại trang
		webDriver.navigate().refresh();
		Thread.sleep(2000);

		// Nhấn nút Full Screen
		webDriver.findElement(By.xpath("/html/body/div[2]/nav/div/div/ul[2]/li/a/i")).click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
