package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class CreateAcademicDegreeTestNG {

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
	public void TC_01() throws InterruptedException {
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a/span")).click();
		Thread.sleep(1500);
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a/span")).click();
		Thread.sleep(1500);
		webDriver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button/span"))
				.click();
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("HHT001");
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Thạc sĩ");
		Thread.sleep(1500);

		Actions actions = new Actions(webDriver);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

		webDriver.findElement(By.xpath("//*[@id=\"level\"]")).sendKeys("100");
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]")).click();
		Thread.sleep(1500);
	}

	@Test
	public void TC_02() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(1500);
		webDriver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button/span"))
				.click();
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("HHT001");
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Thạc sĩ");
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"btnClose\"]")).click();
		Thread.sleep(1500);
	}

	@Test
	public void TC_03() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(1500);
		webDriver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button/span"))
				.click();
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("HHT001@");
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Thạc sĩ");
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]")).click();
		Thread.sleep(1500);
	}

	@Test
	public void TC_04() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(1500);
		webDriver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button/span"))
				.click();
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("HHT001");
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Thạc sĩ");
		Thread.sleep(1500);

		Actions actions = new Actions(webDriver);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		webDriver.findElement(By.xpath("//*[@id=\"level\"]")).sendKeys("101");
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]")).click();
		Thread.sleep(1500);

		webDriver.close();
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
