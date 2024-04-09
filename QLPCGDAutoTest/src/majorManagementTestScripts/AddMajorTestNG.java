package majorManagementTestScripts;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.TermAndMajorPage;
import pageFactory.TermAndMajorPage.CTDT;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class AddMajorTestNG {
	
	private WebDriver webDriver;
	private LoginPage loginPage;
	private TermAndMajorPage termAndMajor;
	
	@BeforeClass
	public void beforeClass() throws InterruptedException{
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);
		
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		termAndMajor = new TermAndMajorPage(webDriver);
		
		loginPage.loginToWebsite();
		termAndMajor.moveToMajorTab();
	}
  
	@Test(priority = 1)
	public void addMajorSucceed() throws InterruptedException {
		String majorId = "a";
		String majorName = "a";
		String abbreviation = "a";
		
		termAndMajor.addMajorButtonPressed();
		
		termAndMajor.addDataToMajorForm(majorId, majorName, abbreviation, CTDT.DacBiet);
		termAndMajor.getToastMessage();
	}

	@Test(priority = 2)
	public void addMajorWithoutDataFailed() throws InterruptedException {
		String majorId = "";
		String majorName = "";
		String abbreviation = "";
		
		termAndMajor.addMajorButtonPressed();
		
		termAndMajor.addDataToMajorForm(majorId, majorName, abbreviation, CTDT.DacBiet);
		
		saveUnsuccessful();
	}
	
	@Test(priority = 3)
	public void addMajorWithSpecialCharacterFailed() throws InterruptedException {
		String majorId = "!";
		String majorName = "a";
		String abbreviation = "a";
		
		termAndMajor.addMajorButtonPressed();
		
		termAndMajor.addDataToMajorForm(majorId, majorName, abbreviation, CTDT.DacBiet);
		
		saveUnsuccessful();
	}
	
	@Test(priority = 4)
	public void addMajorWithoutCTDTFailed() throws InterruptedException {
		String majorId = "a";
		String majorName = "a";
		String abbreviation = "a";
		
		termAndMajor.addMajorButtonPressed();
		
		termAndMajor.addDataToMajorForm(majorId, majorName, abbreviation, CTDT.CTDT);
		
		saveUnsuccessful();
	}
	
	@AfterClass
	public void afterClass() {
		webDriver.quit();
	}
	
	private void saveUnsuccessful() throws InterruptedException {
		if (termAndMajor.isErrorMessagesDisplayed()) {
			termAndMajor.closeMajorFormButtonPressed();
			System.out.println("Lưu không thành công");
		}
	}
}
