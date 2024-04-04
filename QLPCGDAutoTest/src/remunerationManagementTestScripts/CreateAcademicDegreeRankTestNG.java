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

public class CreateAcademicDegreeRankTestNG {

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
		webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a"))
				.click();
		Thread.sleep(1500);
		webDriver
				.findElement(
						By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button/span"))
				.click();
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"select2-academic_degree_id-container\"]/span")).click();
		Thread.sleep(2000);
		Actions chonHocHamHocVi = new Actions(webDriver);
		chonHocHamHocVi.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		webDriver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("ThSi");
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]")).click();
		Thread.sleep(1500);
	}

	@Test
	public void TC_02() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(1500);

		webDriver
				.findElement(
						By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button/span"))
				.click();
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"select2-academic_degree_id-container\"]/span")).click();
		Thread.sleep(2000);
		Actions chonHocHamHocVi = new Actions(webDriver);
		chonHocHamHocVi.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		webDriver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("ThSi");
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"btnClose\"]")).click();
		Thread.sleep(1500);
	}

	@Test
	public void TC_03() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(1500);

		webDriver
				.findElement(
						By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button/span"))
				.click();
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]")).click();
	}

	@Test
	public void TC_04() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(1500);

		webDriver
				.findElement(
						By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button/span"))
				.click();
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"select2-academic_degree_id-container\"]/span")).click();
		Thread.sleep(2000);
		Actions chonHocHamHocVi = new Actions(webDriver);
		chonHocHamHocVi.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		webDriver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("TS.01@");
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]")).click();
		Thread.sleep(1500);

		webDriver.close();
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
