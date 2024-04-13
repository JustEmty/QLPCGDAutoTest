package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LecturersRankPage;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class ViewListOfLecturersByRankTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private LecturersRankPage lecturersRankPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		lecturersRankPage = new LecturersRankPage(webDriver);

		loginPage.loginToWebsite();
		lecturersRankPage.chonMucCapBacGV();
	}

	@Test
	public void TC1_compareTitle() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		String ExpectTitle = "Quản lý cấp bậc giảng viên";
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
	public void TC2_scrollPage() throws InterruptedException {
		lecturersRankPage.scroll();
	}

	@Test
	public void TC3_pressTopPageButton() throws InterruptedException {
		lecturersRankPage.nhanNutVeDauTrang();
	}

	@Test
	public void TC4_maximumOrMinimizeScreen() throws InterruptedException {
		lecturersRankPage.toanVaThuManHinh();
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
