package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class ViewListOfRemunerationOfLecturerTestNG {

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
		// Chọn vào mục Thù lao GV
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[5]/a/span")).click();
		Thread.sleep(2000);
		String ExpectTitle = "Thù lao giảng viên";
		String ActualTitle = webDriver.getTitle().toString();
		if (ActualTitle.contentEquals(ExpectTitle)) {
			System.out.println("Pass");
			System.out.println("Title mong đợi là: " + ExpectTitle);
			System.out.println("Title thực tế là: " + ActualTitle);
		} else {
			System.out.println("Fail");
			System.out.println("Title mong đợi là: " + ExpectTitle);
			System.out.println("Title thực tế là: " + ActualTitle);
		}
		;
	}

	@Test
	public void TestCase2() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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

		// Chọn lọc số lượng dữ liệu hiển thị thành Tất cả
		webDriver.findElement(By.xpath("//*[@id=\"tblRemuneration_length\"]/label/select")).click();
		Actions actions = new Actions(webDriver);
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		// Scroll page xuống và lên theo chiều dọc
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 4000)", "");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -2000)", "");
	}

	@Test
	public void TestCase3() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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

		// Chọn lọc số lượng dữ liệu hiển thị thành Tất cả
		webDriver.findElement(By.xpath("//*[@id=\"tblRemuneration_length\"]/label/select")).click();
		Actions actions = new Actions(webDriver);
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		// Scroll page xuống theo chiều dọc và nhấn nút Trở lại đầu trang
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 4000)", "");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[2]/button")).click();
		Thread.sleep(2000);
	}

	@Test
	public void TestCase4() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Tải lại trang
		webDriver.navigate().refresh();
		Thread.sleep(2000);

		// Nhấn nút Full Screen
		webDriver.findElement(By.xpath("/html/body/div[2]/nav/div/div/ul[2]/li/a/i")).click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
