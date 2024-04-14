package loginPageTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginToQLPCGDWebsiteTestNG {
	
	private WebDriver webDriver;
	private LoginPage loginPage;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);
		
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
	}

	@Test
	public void loginToQLPCGDWebsiteSucceed() throws InterruptedException {
		loginPage.loginToWebsite();
	}
	

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
