package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class UpdateRemunerationCoefficientTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);

		loginPage.loginToWebsite();
	}

	@Test
	public void TestCase1() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Nhấn vào mục Thù lao
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a")).click();
		Thread.sleep(2000);
		// Chọn vào mục Cấp bậc GV
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[2]/a/span")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"tblStandard\"]/tbody/tr[1]/td[3]/a/i")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"price\"]")).sendKeys("1000000");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"unitprice-form\"]/div[3]/button[2]")).click();
		Thread.sleep(2000);
	}

	@Test
	public void TestCase2() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"tblStandard\"]/tbody/tr[1]/td[3]/a[1]/i")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"btnClose\"]")).click();
		Thread.sleep(2000);
	}

	@Test
	public void TestCase3() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"coefficient-tab\"]")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"tblCoefficient\"]/tbody/tr/td[5]/a/i")).click();
		Thread.sleep(2000);
		Actions actions = new Actions(webDriver);
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"vietnamese_coefficient\"]")).sendKeys("1.5");
		Thread.sleep(2000);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"foreign_coefficient\"]")).sendKeys("1.1");
		Thread.sleep(2000);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"theoretical_coefficient\"]")).sendKeys("1.1");
		Thread.sleep(2000);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"practice_coefficient\"]")).sendKeys("1.2");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"coefficient-form\"]/div[3]/button[2]")).click();
	}

	@Test
	public void TestCase4() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"coefficient-tab\"]")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"tblCoefficient\"]/tbody/tr/td[5]/a/i")).click();
		Thread.sleep(2000);
		Actions actions = new Actions(webDriver);
		actions.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"vietnamese_coefficient\"]")).sendKeys("1.5");
		Thread.sleep(2000);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"foreign_coefficient\"]")).sendKeys("1.1");
		Thread.sleep(2000);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"theoretical_coefficient\"]")).sendKeys("1.1");
		Thread.sleep(2000);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"practice_coefficient\"]")).sendKeys("1.2");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"btnClose\"]")).click();
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
