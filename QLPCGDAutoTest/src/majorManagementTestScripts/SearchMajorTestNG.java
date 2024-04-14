package majorManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.TermAndMajorPage;

import org.testng.annotations.BeforeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SearchMajorTestNG {
	
	private WebDriver webDriver;
	private LoginPage loginPage;
	private TermAndMajorPage termAndMajor;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);
		
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		termAndMajor = new TermAndMajorPage(webDriver);
		
		loginPage.loginToWebsite();
		termAndMajor.moveToMajorTab();
	}

	@Test(priority = 1)
	public void searchMajorSucceed() throws InterruptedException {
		String data = "a";
		termAndMajor.searchData(data);
		
		termAndMajor.printMajorDataTable();
	}
  
	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
