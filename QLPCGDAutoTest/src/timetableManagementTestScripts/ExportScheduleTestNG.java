package timetableManagementTestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.AssignmentPage;
import pageFactory.LoginPage;
import pageFactory.MenuTab;

public class ExportScheduleTestNG {
  
	private WebDriver webDriver;
	private LoginPage loginPage;
	private MenuTab menuTab;
	private AssignmentPage assignmentPage;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);
		
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		assignmentPage = new AssignmentPage(webDriver);
		menuTab = new MenuTab(webDriver);
		
		loginPage.loginToWebsite();
		menuTab.moveToAssignmentTab();
	}
	
	@Test
	public void exportScheduleSucceed() throws InterruptedException {
		assignmentPage.exportButtonsClicked();
	}
	
	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
