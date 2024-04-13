package termManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.TermPage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DeleteTermTestNG {

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

	@Test(priority = 1)
	public void TC1_deleteTermSuccess() throws InterruptedException {
		termPage.xoaHocKy();
		String thongBaoThanhCongExpect = "Xóa thành công!";
		String thongBaoThanhCongActual = webDriver.findElement(By.className("toast-message")).getText();
		if (thongBaoThanhCongActual.contentEquals(thongBaoThanhCongExpect)) {
			System.out.println("Pass");
			System.out.println("Thông báo xóa học kỳ thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo xóa học kỳ thành công theo thực tế là: " + thongBaoThanhCongActual);
		} else {
			System.out.println("Fail");
			System.out.println("Thông báo xóa học kỳ thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo xóa học kỳ thành công theo thực tế là: " + thongBaoThanhCongActual);
		}
	}

	@Test(priority = 2)
	public void TC2_deleteTermWhenPressCloseButton() throws InterruptedException {
		termPage.huyXoaHocKy();
	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
	}
}
