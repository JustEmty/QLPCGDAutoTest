package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.RemunerationCoefficientPage;

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
	private RemunerationCoefficientPage remunerationCoefficientPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		remunerationCoefficientPage = new RemunerationCoefficientPage(webDriver);

		loginPage.loginToWebsite();
		remunerationCoefficientPage.chonMucDonGiaHeSo();
	}

	@Test
	public void TestCase1() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
		remunerationCoefficientPage.scroll();
	}

	@Test
	public void TestCase3() throws InterruptedException {
		remunerationCoefficientPage.nhanNutVeDauTrang();
	}

	@Test
	public void TestCase4() throws InterruptedException {
		remunerationCoefficientPage.toanVaThuManHinh();
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
