package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.RemunerationOfLecturerPage;

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

public class SearchRenumnerationOfLectureTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private RemunerationOfLecturerPage remunerationOfLecturerPage;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);
		
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		remunerationOfLecturerPage = new RemunerationOfLecturerPage(webDriver);
		
		loginPage.loginToWebsite();
		remunerationOfLecturerPage.chonMucThuLaoGV();
	}

	@Test
	public void TC1_printOutputRenumneration() throws InterruptedException {
		String nd_cantimkiem = "hi"; // Nhập nội dung cần tìm kiếm vào đây

		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Chọn học kỳ
		remunerationOfLecturerPage.chonHocKy("999");

		// Chọn nút chọn số dữ liệu hiển thị và chọn tất cả
		remunerationOfLecturerPage.chonSLDuLieuHienThi();

		// Nhấn vào ô tìm kiếm Thù lao và nhập nội dung
		remunerationOfLecturerPage.timKiemThuLao("hi");

		// Lấy số hàng
		List<WebElement> row = webDriver.findElements(By.xpath("//*[@id=\"tblRemuneration\"]/tbody/tr"));
		int so_hang = row.size();
		// In dữ liệu hiển thị khi tìm kiếm ra màn hình
		System.out.println("Dữ liệu hiển thị khi nhập nội dung tìm kiếm:");
		for (int i = 1; i < so_hang; i++) {
			for (int j = 2; j < 7; j++) {
				WebElement dulieu = webDriver
						.findElement(By.xpath("//*[@id=\"tblRemuneration\"]/tbody/tr[" + i + "]/td[" + j + "]"));
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

		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Chọn học kỳ
		remunerationOfLecturerPage.chonHocKy("999");

		// Chọn nút chọn số dữ liệu hiển thị và chọn tất cả
		remunerationOfLecturerPage.chonSLDuLieuHienThi();

		// Nhấn vào ô tìm kiếm Thù lao và nhập nội dung
		remunerationOfLecturerPage.timKiemThuLao("hi");

		// Lấy dòng nội dung số lượng dữ liệu hiển thị và tách chuỗi ra rồi bỏ vào mảng
		WebElement so_du_lieu_hien_thi = webDriver.findElement(By.xpath("//*[@id=\"tblRemuneration_info\"]"));
		String[] so_du_lieu = so_du_lieu_hien_thi.getText().split(" ");

		// Lấy tổng số dòng dữ liệu hiển thị
		List<WebElement> row = webDriver.findElements(By.xpath("//*[@id=\"tblRemuneration\"]/tbody/tr"));
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

		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Chọn học kỳ
		remunerationOfLecturerPage.chonHocKy("999");

		// Chạy các phần tử li bằng vòng lặp for
		for (int i = 2; i <= 5; i++) {
			webDriver.findElement(By.xpath("//*[@id=\"tblRemuneration_paginate\"]/ul/li[" + i + "]/a")).click();
			Thread.sleep(2000);
		}
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
