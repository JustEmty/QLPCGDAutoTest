package termManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.TermPage;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class SearchTermTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private TermPage termPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		termPage = new TermPage(webDriver);

		loginPage.loginToWebsite();
		termPage.chonMucHocKy();
	}

	@Test
	public void TC1_printOutputTerm() throws InterruptedException {
		// Chọn nút chọn số dữ liệu hiển thị và chọn tất cả
		termPage.chonSLDuLieuHienThi();

		// Nhấn vào ô tìm kiếm học kỳ và nhập nội dung
		termPage.timKiemHocKy("8");

		// In dữ liệu hiển thị khi tìm kiếm ra màn hình
		System.out.println("Dữ liệu hiển thị khi nhập nội dung tìm kiếm:");
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 8; j++) {
				WebElement dulieu = webDriver
						.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr[" + i + "]/td[" + j + "]"));
				System.out.print(dulieu.getText() + " | ");
			}
			System.out.println();
		}
	}

	@Test
	public void TC2_compareQuantitiesOfData() throws InterruptedException {
		// Tải lại trang
		webDriver.navigate().refresh();
		Thread.sleep(2000);

		// Chọn nút chọn số dữ liệu hiển thị và chọn tất cả
		termPage.chonSLDuLieuHienThi();

		// Nhấn vào ô tìm kiếm học kỳ và nhập nội dung
		termPage.timKiemHocKy("8");

		// Lấy dòng nội dung số lượng dữ liệu hiển thị và tách chuỗi ra rồi bỏ vào mảng
		WebElement so_du_lieu_hien_thi = webDriver.findElement(By.xpath("//*[@id=\"tblTerm_info\"]"));
		String[] so_du_lieu = so_du_lieu_hien_thi.getText().split(" ");

		// Lấy tổng số dòng dữ liệu hiển thị
		List<WebElement> row = webDriver.findElements(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr"));
		int totalRow = row.size();

		// So sánh số dòng và số dữ liệu hiển thị
		if (Integer.parseInt(so_du_lieu[6]) == totalRow) {
			System.out.println("Hệ thống Load hết dữ liệu");
		} else {
			System.out.println("Hệ thống Load thiếu dữ liệu");
		}
	}

	@Test
	public void TC3_searchBaseOnPagination() throws InterruptedException {
		// Tải lại trang
		webDriver.navigate().refresh();
		Thread.sleep(2000);

		// Chạy các phần tử li bằng vòng lặp for
		for (int i = 2; i <= 5; i++) {
			webDriver.findElement(By.xpath("//*[@id=\"tblTerm_paginate\"]/ul/li[" + i + "]/a")).click();
			Thread.sleep(2000);
		}
	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
	}
}
