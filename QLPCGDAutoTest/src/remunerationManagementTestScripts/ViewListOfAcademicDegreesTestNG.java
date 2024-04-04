package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class ViewListOfAcademicDegreesTestNG {

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

		String ExpectTitle = "Quản lý học hàm, học vị";
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
		Thread.sleep(2000);
	}

	@Test
	public void TC_02() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_length\"]/label/select")).click();
		Thread.sleep(2000);

		Actions actions = new Actions(webDriver);
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 30000)", "");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -25000)", "");
		Thread.sleep(2000);
	}

	@Test
	public void TC_03() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_length\"]/label/select")).click();
		Thread.sleep(2000);

		Actions actions = new Actions(webDriver);
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 30000)", "");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[2]/button")).click();
	}

	@Test
	public void TC_04() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[2]/nav/div/div/ul[2]/li/a/i")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[2]/nav/div/div/ul[2]/li/a/i")).click();

		webDriver.close();
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
