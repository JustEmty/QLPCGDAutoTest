package loginPageTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.HomePage;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LogoutFromQLPCGDTestNG {
  
	private WebDriver webDriver;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);
		
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		homePage = new HomePage(webDriver);
		
		loginPage.loginToWebsite();
	}
	
	@Test
	public void logoutFromQLPCGDWebsiteSucceed() throws InterruptedException {
		homePage.lougoutFromWebsite();
	}
  

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
