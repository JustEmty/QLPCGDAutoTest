package termManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.TermPage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class ViewListOfTermsTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private TermPage termPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		termPage = new TermPage(webDriver);

		loginPage.loginToWebsite();
		termPage.chonMucHocKy();
	}

	@Test
	public void TC1_compareTitle() throws InterruptedException {
		// Tạo biến ExpectTitle và gán dữ liệu cho nó
		String ExpectTitle = "Quản lý học kỳ";

		// Tạo biến ActualTitle, lấy Title trang web và gán dữ liệu cho nó
		String ActualTitle = webDriver.getTitle().toString();

		// So sánh 2 tiêu đề Mong đợi và Thực tế
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
	public void TC2_scrollPage() throws InterruptedException {
		termPage.scroll();
	}

	@Test
	public void TC3_pressTopPageButton() throws InterruptedException {
		termPage.nhanNutVeDauTrang();
	}

	@Test
	public void TC4_maximumOrMinimizeScreen() throws InterruptedException {
		termPage.toanVaThuManHinh();
	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
	}
}
