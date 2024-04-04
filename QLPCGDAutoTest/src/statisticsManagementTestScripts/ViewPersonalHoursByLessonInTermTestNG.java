package statisticsManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ViewPersonalHoursByLessonInTermTestNG {

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
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/a")).click();
		Thread.sleep(1500);
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/ul/li[4]/a/span")).click();
		Thread.sleep(1500);
		webDriver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
		Thread.sleep(1500);

		String ExpectTitle = "Thống kê số giờ cá nhân";
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
		webDriver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
		Thread.sleep(1500);

		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 1000)", "");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -1000)", "");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[2]/nav/div/div/ul[2]/li/a/i")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[2]/nav/div/div/ul[2]/li/a/i")).click();
		Thread.sleep(2000);
	}

	@Test
	public void TC_03() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
		Thread.sleep(1500);
		webDriver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();
		Thread.sleep(1500);
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 1000)", "");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -1000)", "");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[2]/nav/div/div/ul[2]/li/a/i")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[2]/nav/div/div/ul[2]/li/a/i")).click();
		Thread.sleep(2000);
	}

	@Test
	public void TC_04() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
		Thread.sleep(1500);
		webDriver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();
		Thread.sleep(1500);

		System.out.println("Dữ liệu hiển thị là: ");
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 13; j++) {
				WebElement dulieu = webDriver
						.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[" + j + "]"));
				System.out.print(dulieu.getText() + " | ");
			}
			System.out.println();
		}
		webDriver.close();
	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
	}
}
