package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.AcademicDegreesPage;
import pageFactory.LoginPage;
import pageFactory.MenuTab;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DeleteAcademicDegreeTestNG {

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
	private void deleteAcademicDegreeRankFailed() throws InterruptedException {
		academicDegreesPage.deleteAcademicDegreesPressed();
		academicDegreesPage.cancelDeleteAcademicDegreesPressed();
		System.out.println("Xóa không thành công!");
	}
	
	@Test
	private void deleteAcademicDegreeRankSucceed() throws InterruptedException {
		academicDegreesPage.deleteAcademicDegreesPressed();
		academicDegreesPage.confirmDeleteAcademicDegreesPressed();
		System.out.println("Xóa thành công!");
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
