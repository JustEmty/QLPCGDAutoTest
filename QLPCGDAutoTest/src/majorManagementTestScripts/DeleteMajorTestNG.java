package majorManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.TermAndMajorPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class DeleteMajorTestNG {
	
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
		
		String data = "a";
		termAndMajor.searchData(data);
	}
  
	@Test
	public void deleteMajorSucceed() throws InterruptedException {
		termAndMajor.deleteMajorFormButtonPressed();
		termAndMajor.confirmDeleteMajorFormButtonPressed();
		System.out.println("Xóa thành công!");
	}
	
	@Test
	public void deleteMajorFailed() throws InterruptedException {
		termAndMajor.deleteMajorFormButtonPressed();
		termAndMajor.cancelDeleteMajorFormButtonPressed();
		System.out.println("Xóa không thành công!");
	}
	
	@AfterTest
	public void afterTest() {	
		webDriver.quit();
	}
}
