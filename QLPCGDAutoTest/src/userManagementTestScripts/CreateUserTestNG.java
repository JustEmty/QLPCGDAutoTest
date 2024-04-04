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

public class CreateUserTestNG {
 
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
	public void addUserSucceed() throws InterruptedException {
		String userId = "21748020107011";
		String userName = "Trung Hiếu";
		String userEmail = "hahieu0311@vanlanguni.vn";
		
		userPage.addUserButtonPressed();
		
		userPage.addDataToUserForm(userId, userName, userEmail, LGV.CoHuu, Role.BCNKhoa);
		
		System.out.println("Lưu thành công");
	}
	
	@Test
	public void addUserWithoutDataFailed() throws InterruptedException {
		String userId = "";
		String userName = "";
		String userEmail = "";
		
		userPage.addUserButtonPressed();
		
		userPage.addDataToUserForm(userId, userName, userEmail, LGV.CoHuu, Role.BoMon);
		
		saveUnsuccessful();
	}
	
	@Test
	public void addUserWithSpecialCharacterFailed() throws InterruptedException {
		String userId = "@";
		String userName = "Trung Hiếu";
		String userEmail = "hahieu0311@vanlanguni.vn";
		
		userPage.addUserButtonPressed();
		
		userPage.addDataToUserForm(userId, userName, userEmail, LGV.CoHuu, Role.GiangVien);
		
		saveUnsuccessful();
	}
	
	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
	
	private void saveUnsuccessful() throws InterruptedException {
		if (userPage.isEnableSaveMajorButton()) {
			userPage.closeUserFormButtonPressed();
			System.out.println("Lưu không thành công");
		}
	}
}