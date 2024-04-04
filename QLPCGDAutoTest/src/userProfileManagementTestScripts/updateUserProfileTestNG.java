package userProfileManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class updateUserProfileTestNG {

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
		String ma_GV = "2174802010781";
		String ten_GV = "Lê Phạm Minh Tài";
		// Nhấn vào logo hồ sơ
		webDriver.findElement(By.xpath("//*[@id=\"dropdown-user\"]/span/img")).click();
		Thread.sleep(2000);
		// Chọn vào mục Hồ sơ
		webDriver.findElement(By.xpath("/html/body/div[2]/nav/div/ul/li[2]/div/a[1]")).click();
		Thread.sleep(2000);
		WebElement nhap_maGV = webDriver.findElement(By.xpath("//*[@id=\"staff_id\"]"));
		Actions actions = new Actions(webDriver);
		nhap_maGV.click();
		actions.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(2000);
		nhap_maGV.sendKeys(ma_GV);
		Thread.sleep(2000);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"full_name\"]")).sendKeys(ten_GV);
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"profile-form\"]/button")).click();
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
