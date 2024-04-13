package termManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.TermPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LockTermTestNG {

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
	public void TC1_lockTermSuccess() throws InterruptedException {
		termPage.khoaHocKy();
		String thongBaoThanhCongExpect = "Cập nhật trạng thái thành công!";
		String thongBaoThanhCongActual = webDriver.findElement(By.className("toast-message")).getText();
		if (thongBaoThanhCongActual.contentEquals(thongBaoThanhCongExpect)) {
			System.out.println("Pass");
			System.out.println("Thông báo khóa học kỳ thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo khóa học kỳ thành công theo thực tế là: " + thongBaoThanhCongActual);
		} else {
			System.out.println("Fail");
			System.out.println("Thông báo khóa học kỳ thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo khóa học kỳ thành công theo thực tế là: " + thongBaoThanhCongActual);
		}
	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
	}
}
