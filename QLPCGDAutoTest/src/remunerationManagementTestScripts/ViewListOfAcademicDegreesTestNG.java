package remunerationManagementTestScripts;

import data.DataContainer;
import pageFactory.AcademicDegreesPage;
import pageFactory.LoginPage;
import pageFactory.MenuTab;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class ViewListOfAcademicDegreesTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private MenuTab menuTab;
	private AcademicDegreesPage academicDegreesPage;
	private Robot robot;

	@BeforeTest
	public void setUp() throws InterruptedException, AWTException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		menuTab = new MenuTab(webDriver);
		academicDegreesPage = new AcademicDegreesPage(webDriver);
		robot = new Robot();
			
		loginPage.loginToWebsite();
		menuTab.moveToAcademicDegreesTabs();
	}

	@Test
	public void fullAndMinimizeScreen() throws InterruptedException {
		academicDegreesPage.fullAndMinimizeScreenButtonClicked();
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
		String expectedTitle = "Quản lý học hàm, học vị";
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
