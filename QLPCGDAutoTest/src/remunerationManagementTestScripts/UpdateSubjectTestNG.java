package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.SubjectsPage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class UpdateSubjectTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private SubjectsPage subjectsPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);

		loginPage.loginToWebsite();
		subjectsPage.chonMucMonHoc();
		Thread.sleep(2000);
		subjectsPage.chonHocKy_Nganh("999", "công nghệ thông tinnnn");
	}

	@Test
	public void TC1_updateSubjectSuccess() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		subjectsPage.capNhatMonHoc();
		String thongBaoThanhCongExpect = "Cập nhật thành công!";
		String thongBaoThanhCongActual = webDriver.findElement(By.className("toast-message")).getText();
		if (thongBaoThanhCongActual.contentEquals(thongBaoThanhCongExpect)) {
			System.out.println("Pass");
			System.out.println("Thông báo sửa môn học thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo sửa môn học thành công theo thực tế là: " + thongBaoThanhCongActual);
		} else {
			System.out.println("Fail");
			System.out.println("Thông báo sửa môn học thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo sửa môn học thành công theo thực tế là: " + thongBaoThanhCongActual);
		}

	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
