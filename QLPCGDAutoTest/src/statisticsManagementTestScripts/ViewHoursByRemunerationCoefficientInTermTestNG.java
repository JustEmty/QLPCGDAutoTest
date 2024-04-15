package statisticsManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.HoursByRemunerationCoefficientPage;
import pageFactory.LoginPage;
import pageFactory.MenuTab;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class ViewHoursByRemunerationCoefficientInTermTestNG {
  
	private WebDriver webDriver;
	private LoginPage loginPage;
	private MenuTab menuTab;
	private HoursByRemunerationCoefficientPage hoursByRemunerationCoefficientPage;
	private Actions actions;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);
		
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		hoursByRemunerationCoefficientPage = new HoursByRemunerationCoefficientPage(webDriver);
		menuTab = new MenuTab(webDriver);
		actions = new Actions(webDriver);
		
		loginPage.loginToWebsite();
		menuTab.moveToViewHoursByRemunerationCoefficientTab();
		hoursByRemunerationCoefficientPage.setViewHoursInTerm();
	}
	
	@Test
	public void fullAndMinimizeScreen() throws InterruptedException {
		hoursByRemunerationCoefficientPage.fullAndMinimizeScreenButtonClicked();
	}
	
	@Test
	public void scrollUpAndDownPage() throws InterruptedException {
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.UP).perform();
		Thread.sleep(2000);
	}
	
	@Test
	public void compareTitle() throws InterruptedException {
		String expectedTitle = "Thống kê số giờ quy đổi giảng viên";
		String actualTitle = webDriver.getTitle();
		
		assertEquals(actualTitle, expectedTitle);
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
