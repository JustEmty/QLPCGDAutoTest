package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DeleteAcademicDegreeRankTestNG {

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
		webDriver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody/tr[2]/td[2]/a[2]/i")).click();
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
		Thread.sleep(1500);
	}

	@Test
	public void TC_02() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody/tr[2]/td[2]/a[2]/i")).click();
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]")).click();
		Thread.sleep(1500);

		webDriver.close();
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
