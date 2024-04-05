package statisticsManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.MenuTab;
import pageFactory.ViewLecturerTimetablePage;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ViewLecturerTimetableTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private MenuTab menuTab;
	private ViewLecturerTimetablePage viewLecturerTimetableTestNG;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);
		
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		viewLecturerTimetableTestNG = new ViewLecturerTimetablePage(webDriver);
		menuTab = new MenuTab(webDriver);
		
		loginPage.loginToWebsite();
		menuTab.moveToViewLecturerTimetablePage();
	}
	
	@Test
	public void fullAndMinimizeScreen() throws InterruptedException {
		viewLecturerTimetableTestNG.fullAndMinimizeScreenButtonClicked();
	}
	
	@Test
	public void compareTitle() throws InterruptedException {
		String expectedTitle = "Thống kê lịch giảng dạy";
		String actualTitle = webDriver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("PASS");
		}else {
			System.out.println("Fail");
			System.out.println("Expected Title: " + expectedTitle);
			System.out.println("Actual Title: " + actualTitle);
		}
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
