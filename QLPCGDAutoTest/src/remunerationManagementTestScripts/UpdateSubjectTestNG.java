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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class UpdateSubjectTestNG {

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
		// Chọn vào mục Môn học
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[3]/a/span")).click();
		Thread.sleep(2000);
		// Chọn học kỳ
		webDriver.findElement(By.xpath("//*[@id=\"select2-term-container\"]")).click();
		WebElement chon_hk = webDriver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input"));
		chon_hk.sendKeys("809");
		Thread.sleep(2000);
		chon_hk.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		// Chọn ngành
		WebElement chon_nganh = webDriver.findElement(By.xpath("//*[@id=\"select2-major-container\"]"));
		Thread.sleep(2000);
		chon_nganh.click();
		Actions actions = new Actions(webDriver);
		actions.sendKeys(Keys.UP).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		// Nhấn nút Cập nhật Môn học
		webDriver.findElement(By.xpath("//*[@id=\"tblSubject\"]/tbody/tr[1]/td[6]/a/i")).click();
		Thread.sleep(2000);
		// Chọn Loại Ngôn ngữ
		webDriver.findElement(By.xpath("//*[@id=\"is_vietnamese\"]")).click();
		Thread.sleep(2000);
		// Nhấn nút Lưu
		webDriver.findElement(By.xpath("//*[@id=\"subject-form\"]/div[4]/button[2]")).click();

	}

	@Test
	public void TestCase2() throws InterruptedException {
		// Tải lại trang
		webDriver.navigate().refresh();
		Thread.sleep(2000);
		// Chọn học kỳ
		webDriver.findElement(By.xpath("//*[@id=\"select2-term-container\"]")).click();
		WebElement chon_hk = webDriver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input"));
		chon_hk.sendKeys("809");
		Thread.sleep(2000);
		chon_hk.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		// Chọn ngành
		WebElement chon_nganh = webDriver.findElement(By.xpath("//*[@id=\"select2-major-container\"]"));
		Thread.sleep(2000);
		chon_nganh.click();
		Actions actions = new Actions(webDriver);
		actions.sendKeys(Keys.UP).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		// Nhấn nút Cập nhật Môn học
		webDriver.findElement(By.xpath("//*[@id=\"tblSubject\"]/tbody/tr[1]/td[6]/a/i")).click();
		Thread.sleep(2000);
		// Chọn Loại Ngôn ngữ
		webDriver.findElement(By.xpath("//*[@id=\"is_vietnamese\"]")).click();
		Thread.sleep(2000);
		// Nhấn nút Hủy
		webDriver.findElement(By.xpath("//*[@id=\"btnClose\"]")).click();

	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
