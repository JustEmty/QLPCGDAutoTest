package userManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.UserPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class LockUserTestNG {
	
	private WebDriver webDriver;
	private LoginPage loginPage;
	private UserPage userPage;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);
		
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		userPage = new UserPage(webDriver);
		
		loginPage.loginToWebsite();
		userPage.moveToUserTab();
	}
	
	@Test
	public void lockUserSucceed() throws InterruptedException {
		userPage.showColumnStatus();
		userPage.enableStatus();
	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
	}
}
