package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.AcademicDegreesRankPage;
import pageFactory.LoginPage;
import pageFactory.MenuTab;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class ViewListOfAcademicDegreeRanksTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private MenuTab menuTab;
	private AcademicDegreesRankPage academicDegreesRankPage;
	private Robot robot;
	
	@BeforeTest
	public void setUp() throws InterruptedException, AWTException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		menuTab = new MenuTab(webDriver);
		academicDegreesRankPage = new AcademicDegreesRankPage(webDriver);
		robot = new Robot();
			
		loginPage.loginToWebsite();
		menuTab.moveToAcademicDegreesRankTabs();
	}

	@Test
	public void fullAndMinimizeScreen() throws InterruptedException {
		academicDegreesRankPage.fullAndMinimizeScreenButtonClicked();
	}
	
	@Test
	public void scrollUpAndDownPage() throws InterruptedException {
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		Thread.sleep(2000);
	}
	
	@Test
	public void compareTitle() throws InterruptedException {
		String expectedTitle = "Quản lý cấp bậc";
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
