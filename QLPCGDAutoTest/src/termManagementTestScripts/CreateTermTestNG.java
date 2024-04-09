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

public class CreateTermTestNG {

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
	public void TestCase1() throws InterruptedException {
		termPage.themHocKy("002", "26", "2025", "7", "15");
		String thongBaoThanhCongExpect = "Lưu thành công!";
		String thongBaoThanhCongActual = webDriver.findElement(By.className("toast-message")).getText();
		if (thongBaoThanhCongActual.contentEquals(thongBaoThanhCongExpect)) {
			System.out.println("Pass");
			System.out.println("Thông báo thêm học kỳ thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo thêm học kỳ thành công theo thực tế là: " + thongBaoThanhCongActual);
		} else {
			System.out.println("Fail");
			System.out.println("Thông báo thêm học kỳ thành công theo mong đợi là: " + thongBaoThanhCongExpect);
			System.out.println("Thông báo thêm học kỳ thành công theo thực tế là: " + thongBaoThanhCongActual);
		}
	}

	@Test(priority = 2)
	public void TestCase2() throws InterruptedException {
		webDriver.navigate().refresh();
		Thread.sleep(2000);
		termPage.themHocKy("101", null, null, null, null);
		String tuanBDErrorExpect = "Bạn chưa nhập tuần bắt đầu";
		String tietTDErrorExpect = "Bạn chưa nhập số tiết tối đa";
		String lopTDErrorExpect = "Bạn chưa nhập số lớp tối đa";
		String tuanBDErrorActual = webDriver.findElement(By.xpath("//*[@id=\"start_week-error\"]")).getText();
		String tietTDErrorActual = webDriver.findElement(By.xpath("//*[@id=\"max_lesson-error\"]")).getText();
		String lopTDErrorActual = webDriver.findElement(By.xpath("//*[@id=\"max_class-error\"]")).getText();
		if (tuanBDErrorActual.contentEquals(tuanBDErrorActual) && tietTDErrorActual.contentEquals(tietTDErrorExpect)
				&& lopTDErrorActual.contentEquals(lopTDErrorExpect)) {
			System.out.println("Pass");
			System.out.println("Thông báo lỗi của trường nhập tuần bắt đầu mong đợi là: " + tuanBDErrorExpect);
			System.out.println("Thông báo lỗi của trường nhập tuần bắt đầu thực tế là: " + tuanBDErrorActual);
			System.out.println("---------------------------------------");
			System.out.println("Thông báo lỗi của trường nhập tiết tối đa mong đợi là: " + tietTDErrorExpect);
			System.out.println("Thông báo lỗi của trường nhập tiết tối đa thực tế là: " + tietTDErrorActual);
			System.out.println("---------------------------------------");
			System.out.println("Thông báo lỗi của trường nhập lớp tối đa mong đợi là: " + lopTDErrorExpect);
			System.out.println("Thông báo lỗi của trường nhập lớp tối đa thực tế là: " + lopTDErrorActual);
		} else {
			System.out.println("Fail");
			System.out.println("Thông báo lỗi của trường nhập tuần bắt đầu mong đợi là: " + tuanBDErrorExpect);
			System.out.println("Thông báo lỗi của trường nhập tuần bắt đầu thực tế là: " + tuanBDErrorActual);
			System.out.println("---------------------------------------");
			System.out.println("Thông báo lỗi của trường nhập tiết tối đa mong đợi là: " + tietTDErrorExpect);
			System.out.println("Thông báo lỗi của trường nhập tiết tối đa thực tế là: " + tietTDErrorActual);
			System.out.println("---------------------------------------");
			System.out.println("Thông báo lỗi của trường nhập lớp tối đa mong đợi là: " + lopTDErrorExpect);
			System.out.println("Thông báo lỗi của trường nhập lớp tối đa thực tế là: " + lopTDErrorActual);
		}
		;
	}

	@Test(priority = 3)
	public void TestCase3() throws InterruptedException {
		termPage.themHocKy("101", "26", "2025", "7", "15");
		String thongBaoLoiExpect = "Học kỳ này đã được tạo trong hệ thống!";
		String thongBaoLoiActual = webDriver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]")).getText();
		if (thongBaoLoiActual.contentEquals(thongBaoLoiExpect)) {
			System.out.println("Pass");
			System.out.println("Thông báo lỗi khi thêm trùng học kỳ mong đợi là: " + thongBaoLoiExpect);
			System.out.println("Thông báo lỗi khi thêm trùng học kỳ thực tế là: " + thongBaoLoiActual);
		} else {
			System.out.println("Fail");
			System.out.println("Thông báo lỗi khi thêm trùng học kỳ mong đợi là: " + thongBaoLoiExpect);
			System.out.println("Thông báo lỗi khi thêm trùng học kỳ thực tế là: " + thongBaoLoiActual);
		}
	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
	}
}
