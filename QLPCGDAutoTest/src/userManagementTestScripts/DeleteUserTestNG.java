package userManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.UserPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DeleteUserTestNG {
 
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
		
		String data = "Trung Hiếu";
		userPage.searchData(data);
	}
	
	@Test
	public void deleteUserFailed() throws InterruptedException {
		userPage.deleteUserFormButtonPressed();
		userPage.cancelDeleteUserFormButtonPressed();
		System.out.println("Xóa không thành công!");
	}
	
	@Test
	public void deleteUserSucceed() throws InterruptedException {
		userPage.deleteUserFormButtonPressed();
		userPage.confirmDeleteUserFormButtonPressed();
		System.out.println("Xóa thành công!");
	}
	
	@AfterTest
	public void afterTest() {
		webDriver.close();
	}
}
