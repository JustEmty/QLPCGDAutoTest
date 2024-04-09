package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.RemunerationCoefficientPage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class UpdateRemunerationCoefficientTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private RemunerationCoefficientPage remunerationCoefficientPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		remunerationCoefficientPage = new RemunerationCoefficientPage(webDriver);

		loginPage.loginToWebsite();
		remunerationCoefficientPage.chonMucDonGiaHeSo();
	}

	@Test
	public void TestCase1() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		remunerationCoefficientPage.suaDonGia("1000000");
		String thongBaoThanhCongExpect = "Lưu thành công!";
		String thongBaoThanhCongActual = webDriver.findElement(By.className("toast-message")).getText();
		if (thongBaoThanhCongActual.contentEquals(thongBaoThanhCongExpect)) {
			System.out.println("Pass");
			System.out.println("Thông báo sửa đơn giá thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo sửa đơn giá thành công theo thực tế là: " + thongBaoThanhCongActual);
		} else {
			System.out.println("Fail");
			System.out.println("Thông báo sửa đơn giá thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo sửa đơn giá thành công theo thực tế là: " + thongBaoThanhCongActual);
		}
	}

	@Test
	public void TestCase2() throws InterruptedException {
		remunerationCoefficientPage.suaHeSo("1.5", "1.1", "1.1", "1.2");
		String thongBaoThanhCongExpect = "Lưu thành công!";
		String thongBaoThanhCongActual = webDriver.findElement(By.className("toast-message")).getText();
		if (thongBaoThanhCongActual.contentEquals(thongBaoThanhCongExpect)) {
			System.out.println("Pass");
			System.out.println("Thông báo sửa hệ số thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo sửa hệ số thành công theo thực tế là: " + thongBaoThanhCongActual);
		} else {
			System.out.println("Fail");
			System.out.println("Thông báo sửa hệ số thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo sửa hệ số thành công theo thực tế là: " + thongBaoThanhCongActual);
		}
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
