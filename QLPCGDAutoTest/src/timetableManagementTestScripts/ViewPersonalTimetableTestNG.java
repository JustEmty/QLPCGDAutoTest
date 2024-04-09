package timetableManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;
import pageFactory.ViewPersonalTimetablePage;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ViewPersonalTimetableTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;
	private ViewPersonalTimetablePage viewPersonalTimetablePage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
		viewPersonalTimetablePage = new ViewPersonalTimetablePage(webDriver);

		loginPage.loginToWebsite();
		viewPersonalTimetablePage.chonMucXemTKB();
	}

	@Test
	public void TestCase1() throws InterruptedException {
		String ExpectTitle = "Thời khóa biểu cá nhân";
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
		// Nhấn nút Full Screen
		viewPersonalTimetablePage.toanVaThuManHinh();
	}

	@Test
	public void TestCase3() throws InterruptedException {
		// Tải lại trang
		webDriver.navigate().refresh();
		Thread.sleep(2000);

		// Chon Học kỳ
		viewPersonalTimetablePage.chonHocKy_Nganh("999");
		Thread.sleep(2000);
		List<WebElement> so_hang = webDriver
				.findElements(By.xpath("//*[@id=\"personalTimetableDiv\"]/div[3]/table/tbody/tr"));
		List<WebElement> so_cot = webDriver
				.findElements(By.xpath("//*[@id=\"personalTimetableDiv\"]/div[3]/table/tbody/tr[1]/td"));
		for (int i = 1; i < so_hang.size(); i++) {
			for (int j = 2; j < so_cot.size(); j++) {
				WebElement thongtin = webDriver.findElement(
						By.xpath("//*[@id=\"personalTimetableDiv\"]/div[3]/table/tbody/tr[" + i + "]/td[" + j + "]"));
				String thong_tin_lop = thongtin.getText().toString();
				if (thong_tin_lop != null) {
					System.out.println(thong_tin_lop);
				}
			}
		}
	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
	}
}
