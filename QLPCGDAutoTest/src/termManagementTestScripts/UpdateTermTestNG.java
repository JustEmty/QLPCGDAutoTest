package termManagementTestScripts;

import org.testng.annotations.Test;

import data.DataContainer;
import pageFactory.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class UpdateTermTestNG {

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
		Actions actions = new Actions(webDriver);
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
		Thread.sleep(2000);

		// Nhấn nút chỉnh sửa
		webDriver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr[1]/td[9]/a[1]/i")).click();
		Thread.sleep(2000);

		// Sửa Năm bắt đầu
		webDriver.findElement(By.xpath("//*[@id=\"select2-start_year-container\"]")).click();
		// Nhấn nút Down và chọn phần tử đó
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		// Sửa Năm kết thúc
		webDriver.findElement(By.xpath("//*[@id=\"select2-end_year-container\"]")).click();
		// Nhấn nút Down và chọn phần tử đó
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		// Chuyển sang ô nhập Tuần bắt đầu
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);

		// Sửa tuần bắt đầu
		webDriver.findElement(By.xpath("//*[@id=\"start_week\"]")).sendKeys("26");
		Thread.sleep(2000);

		// Sửa ngày bắt đầu
		webDriver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
		Thread.sleep(2000);
		// Sửa tháng
		WebElement month = webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/select"));
		month.click();
		Select chon_thang = new Select(month);
		chon_thang.selectByVisibleText("Tháng tư");
		Thread.sleep(5000);
		// Sửa năm
		WebElement year = webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/input"));
		year.click();
		year.sendKeys("2025");
		Thread.sleep(5000);
		// Sửa ngày
		webDriver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]")).click();
		Thread.sleep(2000);

		// Chuyển sang ô nhập Tiết tối đa
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);

		// Sửa tiết tối đa
		webDriver.findElement(By.xpath("//*[@id=\"max_lesson\"]")).sendKeys("7");
		Thread.sleep(2000);

		// Chuyển sang ô nhập Lớp tối đa
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);

		// Sửa lớp tối đa
		webDriver.findElement(By.xpath("//*[@id=\"max_class\"]")).sendKeys("15");
		Thread.sleep(2000);

		// Nhấn nút Lưu
		webDriver.findElement(By.xpath("//*[@id=\"term-form\"]/div[7]/button[2]")).click();
	}

	@Test
	public void TestCase2() throws InterruptedException {
		Actions actions = new Actions(webDriver);
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
		Thread.sleep(2000);

		// Nhấn nút chỉnh sửa
		webDriver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr[1]/td[9]/a[1]/i")).click();
		Thread.sleep(2000);

		// Sửa Năm bắt đầu
		webDriver.findElement(By.xpath("//*[@id=\"select2-start_year-container\"]")).click();
		// Nhấn nút Down và chọn phần tử đó
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		// Sửa Năm kết thúc
		webDriver.findElement(By.xpath("//*[@id=\"select2-end_year-container\"]")).click();
		// Nhấn nút Down và chọn phần tử đó
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		// Chuyển sang ô nhập Tuần bắt đầu
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);

		// Sửa tuần bắt đầu
		webDriver.findElement(By.xpath("//*[@id=\"start_week\"]")).sendKeys("26");
		Thread.sleep(2000);

		// Sửa ngày bắt đầu
		webDriver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
		Thread.sleep(2000);
		// Sửa tháng
		WebElement month = webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/select"));
		month.click();
		Select chon_thang = new Select(month);
		chon_thang.selectByVisibleText("Tháng tư");
		Thread.sleep(5000);
		// Sửa năm
		WebElement year = webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/input"));
		year.click();
		year.sendKeys("2025");
		Thread.sleep(5000);
		// Sửa ngày
		webDriver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]")).click();
		Thread.sleep(2000);

		// Chuyển sang ô nhập Tiết tối đa
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);

		// Sửa tiết tối đa
		webDriver.findElement(By.xpath("//*[@id=\"max_lesson\"]")).sendKeys("7");
		Thread.sleep(2000);

		// Chuyển sang ô nhập Lớp tối đa
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);

		// Sửa lớp tối đa
		webDriver.findElement(By.xpath("//*[@id=\"max_class\"]")).sendKeys("15");
		Thread.sleep(2000);

		// Nhấn nút Hủy
		webDriver.findElement(By.xpath("//*[@id=\"btnClose\"]")).click();
	}

	@Test
	public void TestCase3() throws InterruptedException {
		Actions actions = new Actions(webDriver);
		webDriver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
		Thread.sleep(2000);

		// Nhấn nút chỉnh sửa
		webDriver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr[1]/td[9]/a[1]/i")).click();
		Thread.sleep(2000);

		// Sửa Năm bắt đầu
		webDriver.findElement(By.xpath("//*[@id=\"select2-start_year-container\"]")).click();
		// Nhấn nút Down và chọn phần tử đó
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		// Sửa Năm kết thúc
		webDriver.findElement(By.xpath("//*[@id=\"select2-end_year-container\"]")).click();
		// Nhấn nút Down và chọn phần tử đó
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		// Chuyển sang ô nhập Tuần bắt đầu
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);

		// Sửa tuần bắt đầu
		webDriver.findElement(By.xpath("//*[@id=\"start_week\"]")).sendKeys("53");
		Thread.sleep(2000);

		// Sửa ngày bắt đầu
		webDriver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
		Thread.sleep(2000);
		// Sửa tháng
		WebElement month = webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/select"));
		month.click();
		Select chon_thang = new Select(month);
		chon_thang.selectByVisibleText("Tháng tư");
		Thread.sleep(5000);
		// Sửa năm
		WebElement year = webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/input"));
		year.click();
		year.sendKeys("2025");
		Thread.sleep(5000);
		// Sửa ngày
		webDriver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]")).click();
		Thread.sleep(2000);

		// Chuyển sang ô nhập Tiết tối đa
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);

		// Sửa tiết tối đa
		webDriver.findElement(By.xpath("//*[@id=\"max_lesson\"]")).sendKeys("16");
		Thread.sleep(2000);

		// Chuyển sang ô nhập Lớp tối đa
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);

		// Sửa lớp tối đa
		webDriver.findElement(By.xpath("//*[@id=\"max_class\"]")).sendKeys("31");
		Thread.sleep(2000);

		// Nhấn nút Lưu
		webDriver.findElement(By.xpath("//*[@id=\"term-form\"]/div[7]/button[2]")).click();
	}

	@AfterTest
	public void afterTest() {
		webDriver.close();
	}
}
