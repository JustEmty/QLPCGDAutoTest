package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class SearchAcademicDegreeRankTestNG {

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
		String nd_cantim = "3";

		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a/span")).click();
		Thread.sleep(1500);
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a/span")).click();
		Thread.sleep(1500);
		webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a"))
				.click();
		Thread.sleep(1500);

		webDriver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_length\"]/label/select")).click();
		Actions actions = new Actions(webDriver);
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		webDriver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input")).sendKeys(nd_cantim);

		System.out.println("Dữ liệu hiển thị khi nhập nội dung tìm kiếm là: ");
		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 2; j++) {
				WebElement dulieu1 = webDriver
						.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody/tr[" + i + "]/td[" + j + "]"));
				System.out.print(dulieu1.getText());
			}
			System.out.println();
		}
		System.out.println("--------------------------");
		Thread.sleep(2000);
	}

	@Test
	public void TC_02() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 3000)", "");
		Thread.sleep(2000);

		for (int i = 2; i <= 3; i++) {
			webDriver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_paginate\"]/ul/li[" + i + "]/a")).click();
			Thread.sleep(2000);
		}
		webDriver.close();
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
