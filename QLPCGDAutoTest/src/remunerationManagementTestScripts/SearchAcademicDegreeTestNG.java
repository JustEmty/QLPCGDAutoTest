package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.AcademicDegreesPage;
import pageFactory.LoginPage;
import pageFactory.MenuTab;

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

public class SearchAcademicDegreeTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private MenuTab menuTab;
	private AcademicDegreesPage academicDegreesPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		menuTab = new MenuTab(webDriver);
		academicDegreesPage = new AcademicDegreesPage(webDriver);
			
		loginPage.loginToWebsite();
		menuTab.moveToAcademicDegreesTabs();
	}
	
	@Test
	private void searchAcademicDegreeSucceed() throws InterruptedException {
		String data = "L";
		academicDegreesPage.searchData(data);
		
		academicDegreesPage.getAcademicDegreesDataTable();
		
		System.out.println("Lấy dữ liệu thành công");
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
