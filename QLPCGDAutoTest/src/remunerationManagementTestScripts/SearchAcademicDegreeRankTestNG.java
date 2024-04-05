package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.AcademicDegreesRankPage;
import pageFactory.LoginPage;
import pageFactory.MenuTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SearchAcademicDegreeRankTestNG {

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
	private void searchAcademicDegreeRankSucceed() throws InterruptedException {
		String data = "11";
		academicDegreesRankPage.searchData(data);
		
		academicDegreesRankPage.getAcademicDegreesRankDataTable();
		
		System.out.println("Lấy dữ liệu thành công");
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
