package userManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.UserPage;

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

public class ViewListOfUserTestNG {
  
	private WebDriver webDriver;
	private LoginPage loginPage;
	private UserPage userPage;
	private Robot robot;
	
	@BeforeTest
	public void setUp() throws InterruptedException, AWTException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);
		
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		userPage = new UserPage(webDriver);
		robot = new Robot();
		
		loginPage.loginToWebsite();
		userPage.moveToUserTab();
	}

	@Test
	public void compareTitle() throws InterruptedException {
		String expectedTitle = "Quản lý người dùng";
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
	
	@Test
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
