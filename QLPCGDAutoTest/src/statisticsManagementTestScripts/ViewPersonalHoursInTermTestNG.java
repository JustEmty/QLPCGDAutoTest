package statisticsManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.MenuTab;
import pageFactory.ViewPersonalHoursInTermPage;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class ViewPersonalHoursInTermTestNG {
	
	private WebDriver webDriver;
	private LoginPage loginPage;
	private MenuTab menuTab;
	private ViewPersonalHoursInTermPage viewPersonalHoursInTermPage;
	private Actions actions;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);
		
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		viewPersonalHoursInTermPage = new ViewPersonalHoursInTermPage(webDriver);
		menuTab = new MenuTab(webDriver);
		actions = new Actions(webDriver);
		
		loginPage.loginToWebsite();
		menuTab.moveToViewPersonalHoursInTermTab();
		viewPersonalHoursInTermPage.setTerm();
	}
	
	@Test
	public void fullAndMinimizeScreen() throws InterruptedException {
		viewPersonalHoursInTermPage.fullAndMinimizeScreenButtonClicked();
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
		String expectedTitle = "Thống kê số giờ cá nhân";
		String actualTitle = webDriver.getTitle();
		
		assertEquals(actualTitle, expectedTitle);
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}

}
