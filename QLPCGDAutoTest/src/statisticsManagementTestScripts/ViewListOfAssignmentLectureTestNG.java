package statisticsManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class ViewListOfAssignmentLectureTestNG {

	private WebDriver webDriver;
	private LoginPage loginPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty(DataContainer.WEBDRIVER_CHROME_DRIVER, DataContainer.WEBDRIVER_CHROME_DRIVER_PATH);

		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);

		loginPage.loginToWebsite();
	}

	@Test
	public void TestCase1() throws InterruptedException {
		// Nhấn vào mục Thời khóa biểu
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[4]/a/span")).click();
		Thread.sleep(2000);
		// Chọn vào mục Phân Công
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[4]/ul/li[2]/a/span")).click();
		Thread.sleep(2000);

		// Tạo biến ExpectTitle và gán dữ liệu cho nó
		String ExpectTitle = "Phân công giảng dạy";

		// Tạo biến ActualTitle, lấy Title trang web và gán dữ liệu cho nó
		String ActualTitle = webDriver.getTitle().toString();

		// So sánh 2 tiêu đề Mong đợi và Thực tế
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
		// Tải lại trang
		webDriver.navigate().refresh();
		Thread.sleep(2000);

		// Chọn học kỳ
		webDriver.findElement(By.xpath("//*[@id=\"select2-term-container\"]")).click();
		Thread.sleep(2000);
		WebElement chon_hk = webDriver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input"));
		chon_hk.sendKeys("809");
		Thread.sleep(2000);
		chon_hk.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		// Chọn ngành
		WebElement chon_nganh = webDriver.findElement(By.xpath("//*[@id=\"select2-major-container\"]"));
		Thread.sleep(2000);
		chon_nganh.click();
		Actions actions = new Actions(webDriver);
		actions.sendKeys(Keys.UP).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		// Scroll page xuống theo chiều dọc và scroll bảng phân công xuống theo chiều
		// dọc
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 4000)", "");
		Thread.sleep(2000);
		WebElement table = webDriver.findElement(By.xpath("//*[@id=\"tblAssign\"]/tbody"));
		js.executeScript("arguments[0].scrollIntoView(0, 500);", table);

	}

	@Test
	public void TestCase3() throws InterruptedException {
		// Tải lại trang
		webDriver.navigate().refresh();
		Thread.sleep(2000);

		// Chọn học kỳ
		webDriver.findElement(By.xpath("//*[@id=\"select2-term-container\"]")).click();
		Thread.sleep(2000);
		WebElement chon_hk = webDriver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input"));
		chon_hk.sendKeys("809");
		Thread.sleep(2000);
		chon_hk.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		// Chọn ngành
		WebElement chon_nganh = webDriver.findElement(By.xpath("//*[@id=\"select2-major-container\"]"));
		Thread.sleep(2000);
		chon_nganh.click();
		Actions actions = new Actions(webDriver);
		actions.sendKeys(Keys.UP).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		// Đếm tổng số lớp có trong bảng
		int tong_lop = 0;
		List<WebElement> so_hang = webDriver.findElements(By
				.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr"));
		int tong_hang = so_hang.size();
		for (int i = 1; i <= tong_hang; i++) {
			for (int j = 2; j < 36; j++) {

				List<WebElement> so_lop = webDriver.findElements(By.xpath(
						"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr["
								+ i + "]/td[" + j + "]/div"));
				tong_lop += so_lop.size();
			}
		}
		// Lấy số lớp Lý thuyết được ghi trên bảng
		String so_lop_LT = webDriver.findElement(By.xpath("//*[@id=\"theoreticalCount\"]")).getText().toString();
		// Lấy số lớp Thực hành được ghi trên bảng
		String so_lop_TH = webDriver.findElement(By.xpath("//*[@id=\"practicalCount\"]")).getText().toString();

		// So sánh Tổng số lớp và tổng của 2 lớp TH và LT
		if (tong_lop == (Integer.parseInt(so_lop_TH) + Integer.parseInt(so_lop_LT))) {
			System.out.println("Hệ thống Load hết lớp");
		} else {
			System.out.println("Hệ thống Load thiếu lớp");
		}
	}

	@Test
	public void TestCase4() throws InterruptedException {
		// Tải lại trang
		webDriver.navigate().refresh();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[2]/nav/div/div/ul[2]/li/a/i")).click();

	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}
}
