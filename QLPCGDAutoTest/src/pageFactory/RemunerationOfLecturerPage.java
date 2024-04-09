package pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemunerationOfLecturerPage {

	private WebDriver webDriver;
	private Actions actions;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[6]/a") private WebElement mucThuLao;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[5]/a/span") private WebElement mucThuLaoGV;
	@FindBy(xpath = "//*[@id=\"select2-term-container\"]") private WebElement nutChonHocKy;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input") private WebElement truongHocKy;
	@FindBy(xpath = "//*[@id=\"tblRemuneration_length\"]/label/select") private WebElement nutSLHienThiDuLieu;
	@FindBy(xpath = "/html/body/div[2]/button") private WebElement nutTroVeDauTrang;
	@FindBy(xpath = "/html/body/div[2]/nav/div/div/ul[2]/li/a/i") private WebElement toanVaThuManHinh;
	@FindBy(xpath = "//*[@id=\"tblRemuneration_filter\"]/label/input") private WebElement truongTimKiem;
	
	public RemunerationOfLecturerPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		actions = new Actions(webDriver);
	}
	public void chonMucThuLaoGV() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Nhấn vào mục Thù lao
		mucThuLao.click();
		Thread.sleep(2000);
		// Chọn vào mục Môn học
		mucThuLaoGV.click();
	}
	public void chonHocKy(String hocky) throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Chọn học kỳ
		nutChonHocKy.click();
		truongHocKy.sendKeys(hocky);
		Thread.sleep(2000);
		truongHocKy.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	public void chonSLDuLieuHienThi() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		nutSLHienThiDuLieu.click();
		Thread.sleep(2000);
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
	}
	public void scroll() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 4000)", "");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -2000)", "");
	}
	public void nhanNutVeDauTrang() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 4000)", "");
		Thread.sleep(2000);
		nutTroVeDauTrang.click();
		Thread.sleep(2000);
	}
	public void toanVaThuManHinh() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		toanVaThuManHinh.click();
	}
	public void timKiemThuLao(String noidung_timkiem) throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		truongTimKiem.sendKeys(noidung_timkiem);;
	}
}
