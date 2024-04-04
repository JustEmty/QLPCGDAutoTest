package userManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.UserPage;
import pageFactory.UserPage.LGV;
import pageFactory.UserPage.Role;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class UpdateUserTestNG {
  
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
	public void updateUserSucceed() throws InterruptedException {
		String userId = "21748";
		String userName = "Hà Hiếu";
		String userEmail = "hahieu0@vanlanguni.vn";
		
		userPage.updateUserFormButtonPressed();
		
		userPage.updateDataToUserForm(userId, userName, userEmail, LGV.CoHuu, Role.BCNKhoa);
		
		System.out.println("Lưu thành công");
	}
	
	@Test
	public void updateUserWithoutDataFailed() throws InterruptedException {
		String userId = "";
		String userName = "";
		String userEmail = "";
		
		userPage.updateUserFormButtonPressed();
		
		userPage.updateDataToUserForm(userId, userName, userEmail, LGV.CoHuu, Role.BoMon);
		
		saveUnsuccessful();
	}
	
	@AfterTest
	public void afterTest() {
		webDriver.close();
	}
	
	
	private void saveUnsuccessful() throws InterruptedException {
		if (userPage.isEnableSaveMajorButton()) {
			userPage.closeUserFormButtonPressed();
			System.out.println("Lưu không thành công");
		}
	}
}