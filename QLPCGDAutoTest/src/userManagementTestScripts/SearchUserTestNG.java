package userManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.UserPage;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class SearchUserTestNG {
  
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
	public void searchMajorSucceed() throws InterruptedException {
		String data = "Lâm";
		userPage.searchData(data);
		
		userPage.getUserDataTable();
		
		System.out.println("Lấy dữ liệu thành công");
	}
	
	@AfterTest
	public void afterTest() {
		webDriver.close();
	}
}
