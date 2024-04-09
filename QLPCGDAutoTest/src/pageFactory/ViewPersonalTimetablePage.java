package pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewPersonalTimetablePage {

	private WebDriver webDriver;
	private Actions actions;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[4]/a/span") private WebElement mucThoiKhoaBieu;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[4]/ul/li[3]/a/span") private WebElement mucXemTKB;
	@FindBy(xpath = "//*[@id=\"select2-term-container\"]") private WebElement nutChonHocKy;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input") private WebElement truongHocKy;
	@FindBy(xpath = "//*[@id=\"select2-major-container\"]") private WebElement nutChonNganh;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input") private WebElement truongNganh;
	@FindBy(xpath = "/html/body/div[2]/nav/div/div/ul[2]/li/a/i") private WebElement toanVaThuManHinh;
	
	public ViewPersonalTimetablePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		actions = new Actions(webDriver);
	}
	public void chonMucXemTKB() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Nhấn vào mục Thời Khóa Biểu
		mucThoiKhoaBieu.click();
		Thread.sleep(2000);
		// Chọn vào mục Phân Công
		mucXemTKB.click();
	}
	public void toanVaThuManHinh() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		toanVaThuManHinh.click();
	}
	public void chonHocKy_Nganh(String hocky) throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Chọn học kỳ
		nutChonHocKy.click();
		truongHocKy.sendKeys(hocky);
		Thread.sleep(2000);
		truongHocKy.sendKeys(Keys.ENTER);
	}
}
