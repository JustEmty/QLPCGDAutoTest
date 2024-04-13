package majorManagementTestScripts;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.TermAndMajorPage;
import pageFactory.MenuTab;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class ViewListOfMajorTestNG {
	
	private WebDriver webDriver;
	private LoginPage loginPage;
	private MenuTab menuTab;
	private TermAndMajorPage termAndMajor;
	private Robot robot;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException, AWTException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);
		
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		menuTab = new MenuTab(webDriver);
		termAndMajor = new TermAndMajorPage(webDriver);
		robot = new Robot();
		
		loginPage.loginToWebsite();
		menuTab.moveToTermAndMajorTab();
		termAndMajor.moveToMajorTab();
	}

	@Test(priority = 1)
	public void compareTitle() throws InterruptedException {
		String expectedTitle = "Quản lý ngành";
		String actualTitle = webDriver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("PASS");
			System.out.println("Expected Title: " + expectedTitle);
			System.out.println("Actual Title: " + actualTitle);
		}else {
			System.out.println("Fail");
			System.out.println("Expected Title: " + expectedTitle);
			System.out.println("Actual Title: " + actualTitle);
		}
	}
	
	@Test(priority = 2)
	public void scrollWebsite() throws InterruptedException {
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
