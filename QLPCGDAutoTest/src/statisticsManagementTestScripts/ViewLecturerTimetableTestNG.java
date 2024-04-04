package statisticsManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ViewLecturerTimetableTestNG {

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
	public void TC_01() throws InterruptedException {
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/a")).click();
		Thread.sleep(1500);
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/ul/li[5]/a/span")).click();
		Thread.sleep(1500);

		String ExpectTitle = "Thống kê lịch giảng dạy";
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

		webDriver.close();

	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
