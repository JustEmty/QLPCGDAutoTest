package majorManagementTestScripts;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.TermAndMajorPage;
import pageFactory.TermAndMajorPage.CTDT;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
		Assert.assertEquals(termAndMajor.getToastMessage(), "Lưu thành công!");
	}

	@Test(priority = 2)
	public void addMajorWithoutDataFailed() throws InterruptedException {
		String majorId = "";
		String majorName = "";
		String abbreviation = "";
		
		termAndMajor.addMajorButtonPressed();
		
		termAndMajor.addDataToMajorForm(majorId, majorName, abbreviation, CTDT.DacBiet);
		
		printSaveUnsuccessfulMessage("addMajorWithoutDataFailed");
	}
	
	@Test(priority = 3)
	public void addMajorWithSpecialCharacterFailed() throws InterruptedException {
		String majorId = "!";
		String majorName = "a";
		String abbreviation = "a";
		
		termAndMajor.addMajorButtonPressed();
		
		termAndMajor.addDataToMajorForm(majorId, majorName, abbreviation, CTDT.DacBiet);
		
		printSaveUnsuccessfulMessage("addMajorWithSpecialCharacterFailed");
	}
	
	@Test(priority = 4)
	public void addMajorWithoutCTDTFailed() throws InterruptedException {
		String majorId = "a";
		String majorName = "a";
		String abbreviation = "a";
		
		termAndMajor.addMajorButtonPressed();
		
		termAndMajor.addDataToMajorForm(majorId, majorName, abbreviation, CTDT.CTDT);
		
		printSaveUnsuccessfulMessage("addMajorWithoutCTDTFailed");
	}
	
	@AfterClass
	public void afterClass() {
		webDriver.quit();
	}
	
	private void printSaveUnsuccessfulMessage(String testCaseName) throws InterruptedException {
		if (termAndMajor.isErrorMessagesDisplayed()) {
			System.out.println("TC: " + testCaseName + " Lưu không thành công vì các lỗi sau:");
			System.out.println("----------");
			for (WebElement errorMessage : termAndMajor.getErrorMessageList()) {
				System.out.println(errorMessage.getText());
			}
			System.out.println("-----");
			termAndMajor.closeMajorFormButtonPressed();
		}
	}
}
