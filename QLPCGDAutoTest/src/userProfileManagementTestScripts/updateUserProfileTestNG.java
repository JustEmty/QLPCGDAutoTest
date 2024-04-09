package userProfileManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.UserProfileManagementPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class updateUserProfileTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private UserProfileManagementPage userProfileManagementPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		userProfileManagementPage = new UserProfileManagementPage(webDriver);

		loginPage.loginToWebsite();
	}

	@Test
	public void TestCase1() throws InterruptedException {
		userProfileManagementPage.capNhatHoSo("005", "Lê Phạm Minh Tài");
		String thongBaoThanhCongExpect = "Cập nhật thành công!";
		String thongBaoThanhCongActual = webDriver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]")).getText();
		if (thongBaoThanhCongActual.contentEquals(thongBaoThanhCongExpect)) {
			System.out.println("Pass");
			System.out.println(
					"Thông báo cập nhật hồ sơ người dùng thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println(
					"Thông báo cập nhật hồ sơ người dùng thành công theo thực tế là: " + thongBaoThanhCongActual);
		} else {
			System.out.println("Fail");
			System.out.println(
					"Thông báo cập nhật hồ sơ người dùng thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println(
					"Thông báo cập nhật hồ sơ người dùng thành công theo thực tế là: " + thongBaoThanhCongActual);
		}
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
