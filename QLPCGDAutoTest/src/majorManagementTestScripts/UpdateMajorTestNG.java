package majorManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.MenuTab;
import pageFactory.TermAndMajorPage;
import pageFactory.TermAndMajorPage.CTDT;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class UpdateMajorTestNG {
	
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
	public void updateMajorSucceed() throws InterruptedException {
		String majorName = "AutoTest";
		String abbreviation = "AT";
		
		termAndMajor.updateMajorFormButtonPressed();
		
		termAndMajor.updateDataToMajorForm(majorName, abbreviation, CTDT.TieuChuan);
		
		System.out.println("Lưu thành công");
	}
	
	@Test
	public void updateMajorWithoutDataFailed() throws InterruptedException {
		String majorName = "";
		String abbreviation = "";
		
		termAndMajor.updateMajorFormButtonPressed();
		
		termAndMajor.updateDataToMajorForm(majorName, abbreviation, CTDT.DacBiet);
		
		saveUnsuccessful();
	}
	
	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
	
	private void saveUnsuccessful() throws InterruptedException {
		if (termAndMajor.isErrorMessagesDisplayed()) {
			termAndMajor.closeMajorFormButtonPressed();
			System.out.println("Lưu không thành công");
		}
	}
}
