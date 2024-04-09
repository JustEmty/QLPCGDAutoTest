package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LecturersRankPage;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class UpdateLecturerRank {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private LecturersRankPage lecturersRankPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		lecturersRankPage = new LecturersRankPage(webDriver);

		loginPage.loginToWebsite();
		lecturersRankPage.chonMucCapBacGV();
	}

	@Test
	public void TestCase1() throws InterruptedException {
		lecturersRankPage.capNhatCapBac();
		String thongBaoThanhCongExpect = "Cập nhật thành công!";
		String thongBaoThanhCongActual = webDriver.findElement(By.className("toast-message")).getText();
		if (thongBaoThanhCongActual.contentEquals(thongBaoThanhCongExpect)) {
			System.out.println("Pass");
			System.out.println("Thông báo cập nhật cấp bậc thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo cập nhật cấp bậc thành công theo thực tế là: " + thongBaoThanhCongActual);
		} else {
			System.out.println("Fail");
			System.out.println("Thông báo cập nhật cấp bậc thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo cập nhật cấp bậc thành công theo thực tế là: " + thongBaoThanhCongActual);
		}
	}

	@Test
	public void TestCase2() throws InterruptedException {
		lecturersRankPage.capNhatTatCaCapBac();
		String thongBaoThanhCongExpect = "Lưu thành công!";
		String thongBaoThanhCongActual = webDriver.findElement(By.className("toast-message")).getText();
		if (thongBaoThanhCongActual.contentEquals(thongBaoThanhCongExpect)) {
			System.out.println("Pass");
			System.out.println(
					"Thông báo cập nhật tất cả cấp bậc thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println(
					"Thông báo cập nhật tất cả cấp bậc thành công theo thực tế là: " + thongBaoThanhCongActual);
		} else {
			System.out.println("Fail");
			System.out.println(
					"Thông báo cập nhật tất cả cấp bậc thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println(
					"Thông báo cập nhật tất cả cấp bậc thành công theo thực tế là: " + thongBaoThanhCongActual);
		}
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
