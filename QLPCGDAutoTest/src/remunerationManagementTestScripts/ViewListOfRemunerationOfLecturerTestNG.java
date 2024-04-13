package remunerationManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.RemunerationOfLecturerPage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ViewListOfRemunerationOfLecturerTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private RemunerationOfLecturerPage remunerationOfLecturerPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		remunerationOfLecturerPage = new RemunerationOfLecturerPage(webDriver);

		loginPage.loginToWebsite();
		remunerationOfLecturerPage.chonMucThuLaoGV();
	}

	@Test
	public void TC1_compareTitle() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String ExpectTitle = "Thù lao giảng viên";
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
	public void TC2_scrollPage() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Tải lại trang
		webDriver.navigate().refresh();
		Thread.sleep(2000);

		// Chọn học kỳ
		remunerationOfLecturerPage.chonHocKy("999");

		// Chọn lọc số lượng dữ liệu hiển thị thành Tất cả
		remunerationOfLecturerPage.chonSLDuLieuHienThi();

		// Scroll page xuống và lên theo chiều dọc
		remunerationOfLecturerPage.scroll();
	}

	@Test
	public void TC3_pressTopPageButton() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Scroll page xuống theo chiều dọc và nhấn nút Trở lại đầu trang
		remunerationOfLecturerPage.nhanNutVeDauTrang();
	}

	@Test
	public void TC4_maximumOrMinimizeScreen() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Nhấn nút Full Screen
		remunerationOfLecturerPage.toanVaThuManHinh();
	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
