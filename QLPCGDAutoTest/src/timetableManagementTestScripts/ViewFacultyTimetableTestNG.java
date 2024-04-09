package timetableManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.AssignLecturerPage;
import pageFactory.AssignmentPage;
import pageFactory.LoginPage;
import pageFactory.MenuTab;
import pageFactory.SubjectsPage;

import org.testng.annotations.BeforeTest;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ViewFacultyTimetableTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private AssignLecturerPage assignLecturerPage;

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		assignLecturerPage = new AssignLecturerPage(webDriver);

		loginPage.loginToWebsite();
		assignLecturerPage.chonMucPhanCong();
	}

	@Test(priority = 3)
	public void TestCase1() throws InterruptedException {
		// Tạo biến ExpectTitle và gán dữ liệu cho nó
		String ExpectTitle = "Phân công giảng dạy";

		// Tạo biến ActualTitle, lấy Title trang web và gán dữ liệu cho nó
		String ActualTitle = webDriver.getTitle().toString();

		// So sánh 2 tiêu đề Mong đợi và Thực tế
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

	@Test(priority = 2)
	public void TestCase2() throws InterruptedException {
		// Scroll page xuống theo chiều dọc và scroll bảng phân công xuống theo chiều
		// dọc
		assignLecturerPage.scrollPage_ScrollTable();

	}

	@Test(priority = 1)
	public void TestCase3() throws InterruptedException {
		assignLecturerPage.chonHocKy_Nganh("999", "công nghệ thông tinnnn");

		// Đếm tổng số lớp có trong bảng
		int tong_lop = 0;
		List<WebElement> so_hang = webDriver.findElements(By
				.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr"));
		int tong_hang = so_hang.size();
		for (int i = 1; i <= tong_hang; i++) {
			for (int j = 2; j < 36; j++) {

				List<WebElement> so_lop = webDriver.findElements(By.xpath(
						"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr["
								+ i + "]/td[" + j + "]/div"));
				tong_lop += so_lop.size();
			}
		}
		// Lấy số lớp Lý thuyết được ghi trên bảng
		String so_lop_LT = webDriver.findElement(By.xpath("//*[@id=\"theoreticalCount\"]")).getText().toString();
		// Lấy số lớp Thực hành được ghi trên bảng
		String so_lop_TH = webDriver.findElement(By.xpath("//*[@id=\"practicalCount\"]")).getText().toString();

		// So sánh Tổng số lớp và tổng của 2 lớp TH và LT
		if (tong_lop == (Integer.parseInt(so_lop_TH) + Integer.parseInt(so_lop_LT))) {
			System.out.println("Hệ thống Load hết lớp");
		} else {
			System.out.println("Hệ thống Load thiếu lớp");
		}
	}

	@Test(priority = 4)
	public void TestCase4() throws InterruptedException {
		assignLecturerPage.toanVaThuManHinh();

	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
