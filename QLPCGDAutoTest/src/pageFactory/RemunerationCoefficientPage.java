package pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemunerationCoefficientPage {

	private WebDriver webDriver;
	private Actions actions;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[6]/a") private WebElement mucThuLao;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[2]/a/span") private WebElement mucDonGiaHeSo;
	@FindBy(xpath = "//*[@id=\"tblStandard\"]/tbody/tr[1]/td[3]/a/i") private WebElement nutCapNhat;
	@FindBy(xpath = "//*[@id=\"price\"]") private WebElement truongDonGia;
	@FindBy(xpath = "//*[@id=\"unitprice-form\"]/div[3]/button[2]") private WebElement nutLuuDonGia;
	@FindBy(xpath = "//*[@id=\"coefficient-tab\"]") private WebElement tabHeSo;
	@FindBy(xpath = "//*[@id=\"tblCoefficient\"]/tbody/tr/td[5]/a") private WebElement nutCapNhatHeSo;
	@FindBy(xpath = "//*[@id=\"vietnamese_coefficient\"]") private WebElement truongHeSoTiengViet;
	@FindBy(xpath = "//*[@id=\"foreign_coefficient\"]") private WebElement truongHeSoTiengAnh;
	@FindBy(xpath = "//*[@id=\"theoretical_coefficient\"]") private WebElement truongHeSoLyThuyet;
	@FindBy(xpath = "//*[@id=\"practice_coefficient\"]") private WebElement truongHeSoThucHanh;
	@FindBy(xpath = "//*[@id=\"coefficient-form\"]/div[3]/button[2]") private WebElement nutLuuHeSo;
	@FindBy(xpath = "/html/body/div[2]/nav/div/div/ul[2]/li/a/i") private WebElement toanVaThuManHinh;
	@FindBy(xpath = "/html/body/div[2]/button") private WebElement nutTroVeDauTrang;
	
	public RemunerationCoefficientPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		actions = new Actions(webDriver);
	}
	public void chonMucDonGiaHeSo() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		mucThuLao.click();
		Thread.sleep(2000);
		mucDonGiaHeSo.click();
	}
	public void suaDonGia(String don_gia) throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		nutCapNhat.click();
		Thread.sleep(2000);
		truongDonGia.sendKeys(don_gia);
		Thread.sleep(2000);
		nutLuuDonGia.click();
	}
	public void suaHeSo(String hs_TV, String hs_TA, String hs_LT, String hs_TH) throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		tabHeSo.click();
		Thread.sleep(2000);
		nutCapNhatHeSo.click();
		Thread.sleep(2000);
		truongHeSoTiengViet.sendKeys(hs_TV);
		Thread.sleep(2000);
		truongHeSoTiengAnh.sendKeys(hs_TA);
		Thread.sleep(2000);
		truongHeSoLyThuyet.sendKeys(hs_LT);
		Thread.sleep(2000);
		truongHeSoThucHanh.sendKeys(hs_TH);
		Thread.sleep(2000);
		nutLuuHeSo.click();
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
}