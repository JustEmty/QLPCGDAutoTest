package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.AcademicDegreesRankPage;
import pageFactory.LoginPage;
import pageFactory.MenuTab;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DeleteAcademicDegreeRankTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private MenuTab menuTab;
	private AcademicDegreesRankPage academicDegreesRankPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		menuTab = new MenuTab(webDriver);
		academicDegreesRankPage = new AcademicDegreesRankPage(webDriver);
		

		loginPage.loginToWebsite();
		menuTab.moveToAcademicDegreesRankTabs();
	}
	
	@Test
	private void deleteAcademicDegreeRankFailed() throws InterruptedException {
		academicDegreesRankPage.deleteAcademicDegreesRankPressed();
		academicDegreesRankPage.cancelDeleteAcademicDegreesRankPressed();
		System.out.println("Xóa không thành công!");
	}
	
	@Test
	private void deleteAcademicDegreeRankSucceed() throws InterruptedException {
		academicDegreesRankPage.deleteAcademicDegreesRankPressed();
		academicDegreesRankPage.confirmDeleteAcademicDegreesRankPressed();
		System.out.println("Xóa thành công!");
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
