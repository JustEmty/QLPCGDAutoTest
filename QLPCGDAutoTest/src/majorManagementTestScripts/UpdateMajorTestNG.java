package majorManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.TermAndMajorPage;
import pageFactory.TermAndMajorPage.CTDT;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
	
	@Test(priority = 1)
	public void updateMajorSucceed() throws InterruptedException {
		String majorName = "AutoTest";
		String abbreviation = "AT";
		
		termAndMajor.updateMajorFormButtonPressed();
		
		termAndMajor.updateDataToMajorForm(majorName, abbreviation, CTDT.TieuChuan);
		
		Assert.assertEquals(termAndMajor.getToastMessage(), "Cập nhật thành công!");
	}
	
	@Test(priority = 2)
	public void updateMajorWithoutDataFailed() throws InterruptedException {
		String majorName = "";
		String abbreviation = "";
		
		termAndMajor.updateMajorFormButtonPressed();
		
		termAndMajor.updateDataToMajorForm(majorName, abbreviation, CTDT.DacBiet);
		
		saveUnsuccessful("updateMajorWithoutDataFailed");
	}
	
	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
	
	private void saveUnsuccessful(String testCaseName) throws InterruptedException {
		if (termAndMajor.isErrorMessagesDisplayed()) {
			for (WebElement errorMessage : termAndMajor.getErrorMessageList()) {
				System.out.println(errorMessage.getText());
			}
			System.out.println("-----");
			termAndMajor.closeMajorFormButtonPressed();
			System.out.println("TC: " + testCaseName + " Lưu không thành công");
			System.out.println("----------");
		}
	}
}
