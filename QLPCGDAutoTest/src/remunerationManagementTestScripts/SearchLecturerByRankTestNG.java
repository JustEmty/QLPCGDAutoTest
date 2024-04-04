package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class SearchLecturerByRankTestNG {

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
		String nd_cantimkiem = "Q"; // Nhập nội dung cần tìm kiếm vào đây

		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Chọn mục Thù lao ở thanh Menu
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a")).click();
		Thread.sleep(2000);

		// Chọn mục Cấp bậc GV
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a/span")).click();
		Thread.sleep(2000);

		// Chọn nút chọn số dữ liệu hiển thị và chọn tất cả
		webDriver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select")).click();
		Actions actions = new Actions(webDriver);
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		// Nhấn vào ô tìm kiếm cấp bậc và nhập nội dung
		webDriver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys(nd_cantimkiem);

		// Lấy số hàng
		List<WebElement> row = webDriver.findElements(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr"));
		int so_hang = row.size();
		// In dữ liệu hiển thị khi tìm kiếm ra màn hình
		System.out.println("Dữ liệu hiển thị khi nhập nội dung tìm kiếm:");
		for (int i = 1; i < so_hang; i++) {
			for (int j = 1; j < 5; j++) {
				WebElement dulieu = webDriver
						.findElement(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr[" + i + "]/td[" + j + "]"));
				System.out.print(dulieu.getText() + " | ");
			}
			System.out.println();
		}
	}

	@Test
	public void TestCase2() throws InterruptedException {
		// Tải lại trang
		webDriver.navigate().refresh();
		Thread.sleep(2000);

		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String nd_cantimkiem = "Q"; // Nhập nội dung cần tìm kiếm vào đây

		// Chọn nút chọn số dữ liệu hiển thị và chọn tất cả
		webDriver.findElement(By.xpath("//*[@id=\"tblLecturerRank_length\"]/label/select")).click();
		Actions actions = new Actions(webDriver);
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		// Nhấn vào ô tìm kiếm cấp bậc và nhập nội dung
		webDriver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input")).sendKeys(nd_cantimkiem);

		// Lấy dòng nội dung số lượng dữ liệu hiển thị và tách chuỗi ra rồi bỏ vào mảng
		WebElement so_du_lieu_hien_thi = webDriver.findElement(By.xpath("//*[@id=\"tblLecturerRank_info\"]"));
		String[] so_du_lieu = so_du_lieu_hien_thi.getText().split(" ");

		// Lấy tổng số dòng dữ liệu hiển thị
		List<WebElement> row = webDriver.findElements(By.xpath("//*[@id=\"tblLecturerRank\"]/tbody/tr"));
		int totalRow = row.size();

		// So sánh số dòng và số dữ liệu hiển thị
		if (Integer.parseInt(so_du_lieu[6]) == totalRow) {
			System.out.println("Hệ thống Load hết dữ liệu");
		} else {
			System.out.println("Hệ thống Load thiếu dữ liệu");
		}
	}

	@Test
	public void TestCase3() throws InterruptedException {
		// Tải lại trang
		webDriver.navigate().refresh();
		Thread.sleep(2000);

		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Chạy các phần tử li bằng vòng lặp for
		for (int i = 2; i <= 5; i++) {
			webDriver.findElement(By.xpath("//*[@id=\"tblLecturerRank_paginate\"]/ul/li[" + i + "]/a")).click();
			Thread.sleep(3000);
		}
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
