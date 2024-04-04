package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class UpdateLecturerRank {

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
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a/span")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[2]/td[5]/a/i")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]/span")).click();
		Thread.sleep(2000);
		WebElement chon_capbac = webDriver
				.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/div/span[2]/span/span[1]/input"));
		chon_capbac.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[4]/button[2]")).click();
		Thread.sleep(2000);
	}

	@Test
	public void TestCase2() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[2]/td[5]/a/i")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"btnClose\"]")).click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
