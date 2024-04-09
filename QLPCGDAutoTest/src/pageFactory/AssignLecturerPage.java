package pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignLecturerPage {

	private WebDriver webDriver;
	private Actions actions;
	
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[4]/a/span") private WebElement mucThoiKhoaBieu;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[4]/ul/li[2]/a/span") private WebElement mucPhanCong;
	@FindBy(xpath = "//*[@id=\"select2-term-container\"]") private WebElement nutChonHocKy;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input") private WebElement truongHocKy;
	@FindBy(xpath = "//*[@id=\"select2-major-container\"]") private WebElement nutChonNganh;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input") private WebElement truongNganh;
	@FindBy(xpath = "/html/body/div[2]/nav/div/div/ul[2]/li/a/i") private WebElement toanVaThuManHinh;
	
	public AssignLecturerPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		actions = new Actions(webDriver);
	}
	public void chonMucPhanCong() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Nhấn vào mục Thời Khóa Biểu
		mucThoiKhoaBieu.click();
		Thread.sleep(2000);
		// Chọn vào mục Phân Công
		mucPhanCong.click();
	}
	public void chonHocKy_Nganh(String hocky, String nganh) throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Chọn học kỳ
		nutChonHocKy.click();
		truongHocKy.sendKeys(hocky);
		Thread.sleep(1000);
		truongHocKy.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Chọn ngành
		nutChonNganh.click();
		Thread.sleep(1000);
		truongNganh.sendKeys(nganh);
		Thread.sleep(1000);
		truongNganh.sendKeys(Keys.ENTER);
	}
	public void scrollPage_ScrollTable() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Scroll page xuống theo chiều dọc và scroll bảng phân công xuống theo chiều dọc
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 4000)", "");
		Thread.sleep(2000);
		WebElement table = webDriver.findElement(By.xpath("//*[@id=\"tblAssign\"]/tbody"));
		js.executeScript("arguments[0].scrollIntoView(0, 500);", table);
	}
	public void toanVaThuManHinh() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		toanVaThuManHinh.click();
	}
}
