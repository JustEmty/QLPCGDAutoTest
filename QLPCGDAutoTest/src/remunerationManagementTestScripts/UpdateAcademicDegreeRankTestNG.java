package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.AcademicDegreesRankPage;
import pageFactory.LoginPage;
import pageFactory.MenuTab;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class UpdateAcademicDegreeRankTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private MenuTab menuTab;
	private AcademicDegreesRankPage academicDegreesRankPage;
	private Robot robot;

	@BeforeTest
	public void setUp() throws InterruptedException, AWTException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		menuTab = new MenuTab(webDriver);
		academicDegreesRankPage = new AcademicDegreesRankPage(webDriver);
		robot = new Robot();
			
		loginPage.loginToWebsite();
		menuTab.moveToAcademicDegreesRankTabs();
	}
	
	@Test
	private void updateAcademicDegreeRankSucceed() throws InterruptedException {
		academicDegreesRankPage.updateAcademicDegreesRankPressed();
		
		academicDegreesRankPage.updateDataToAcademicDegreesRankForm();
		
		System.out.println("Lưu thành công");
	}


	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
