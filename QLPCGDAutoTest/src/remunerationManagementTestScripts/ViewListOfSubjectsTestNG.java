package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.SubjectsPage;

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

public class ViewListOfSubjectsTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private SubjectsPage subjectsPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		subjectsPage = new SubjectsPage(webDriver);

		loginPage.loginToWebsite();
		subjectsPage.chonMucMonHoc();
		Thread.sleep(2000);
		subjectsPage.chonHocKy_Nganh("999", "công nghệ thông tinnnn");
	}

	@Test
	public void TestCase1() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// So sánh 2 Title Mong đợi và Thực tế
		String ExpectTitle = "Quản lý môn học";
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
		// Chọn lọc số lượng dữ liệu hiển thị thành Tất cả
		subjectsPage.chonSLDuLieuHienThi();
		Thread.sleep(2000);

		// Scroll page xuống và lên theo chiều dọc
		subjectsPage.scroll();
	}

	@Test
	public void TestCase3() throws InterruptedException {
		// Scroll page xuống theo chiều dọc và nhấn nút Trở lại đầu trang
		subjectsPage.nhanNutVeDauTrang();
	}

	@Test
	public void TestCase4() throws InterruptedException {
		// Nhấn nút Full Screen
		subjectsPage.toanVaThuManHinh();
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
