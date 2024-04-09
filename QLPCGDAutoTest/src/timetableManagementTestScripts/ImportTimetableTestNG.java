package timetableManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.ImportTKBPage;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ImportTimetableTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private ImportTKBPage importTKBPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		importTKBPage = new ImportTKBPage(webDriver);

		loginPage.loginToWebsite();
		importTKBPage.chonMucImportTKB();
	}

	@Test(priority = 1)
	public void TestCase1() throws InterruptedException {
		importTKBPage.ImportTKB();
		String thongBaoExpect = "Bạn chưa chọn học kỳ và ngành";
		String thongBaoActual = webDriver.findElement(By.className("toast-message")).getText();
		if (thongBaoActual.contentEquals(thongBaoExpect)) {
			System.out.println("Pass");
			System.out.println(
					"Thông báo lỗi khi import TKB chưa chọn học kỳ và ngành theo mong đợi là: " + thongBaoExpect);
			System.out.println(
					"Thông báo lỗi khi import TKB chưa chọn học kỳ và ngành theo thực tế là: " + thongBaoActual);
		} else {
			System.out.println("Fail");
			System.out.println(
					"Thông báo lỗi khi import TKB chưa chọn học kỳ và ngành theo mong đợi là: " + thongBaoExpect);
			System.out.println(
					"Thông báo lỗi khi import TKB chưa chọn học kỳ và ngành theo thực tế là: " + thongBaoActual);
		}
	}

	@Test(priority = 2)
	public void TestCase2() throws InterruptedException {
		webDriver.navigate().refresh();
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		importTKBPage.chonHocKy_Nganh("120", "công nghệ thông tinnnn");
		Thread.sleep(2000);
		importTKBPage.ImportTKB();
		Thread.sleep(2000);
		importTKBPage.tiepTucImport();
		String thongBaoExpect = "Học kỳ và ngành này đã có dữ liệu trong hệ thống, bạn muốn cập nhật hay thay thế thời khoá biểu?";
		String thongBaoActual = webDriver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]")).getText();
		if (thongBaoActual.contentEquals(thongBaoExpect)) {
			System.out.println("Pass");
			System.out.println("Thông báo khi import TKB theo mong đợi là: " + thongBaoExpect);
			System.out.println("Thông báo khi import TKB theo thực tế là: " + thongBaoActual);
		} else {
			System.out.println("Fail");
			System.out.println("Thông báo khi import TKB theo mong đợi là: " + thongBaoExpect);
			System.out.println("Thông báo khi import TKB theo thực tế là: " + thongBaoActual);
		}
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
