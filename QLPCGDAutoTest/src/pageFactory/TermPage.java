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
import org.openqa.selenium.support.ui.Select;

public class TermPage {

	private WebDriver webDriver;
	private Actions actions;
	
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[2]/a/span") private WebElement chonMucHK;
	@FindBy(xpath = "//*[@id=\"tblTerm_length\"]/label/select") private WebElement chonSLKocKy;
	@FindBy(xpath = "/html/body/div[2]/nav/div/div/ul[2]/li/a/i") private WebElement toanVaThuManHinh;
	@FindBy(xpath = "//*[@id=\"tblTerm_filter\"]/label/input") private WebElement timKiemHK;
	@FindBy(xpath = "//*[@id=\"tblTerm_info\"]") private WebElement hienThiSoLuongDuLieu;
	@FindBy(xpath = "//*[@id=\"tblTerm\"]/tbody/tr") private WebElement soCotDuLieu;
	@FindBy(xpath = "//*[@id=\"tblTerm_wrapper\"]/div[1]/div[2]/div/div[2]/button") private WebElement nutThemMoi;
	@FindBy(xpath = "//*[@id=\"id\"]") private WebElement nhapHocKy;
	@FindBy(xpath = "//*[@id=\"select2-start_year-container\"]") private WebElement chonNamBD;
	@FindBy(xpath = "//*[@id=\"select2-end_year-container\"]") private WebElement chonNamKT;
	@FindBy(xpath = "//*[@id=\"start_week\"]") private WebElement nhapTuanBatDau;
	@FindBy(xpath = "//*[@id=\"term-form\"]/div[5]/input[2]") private WebElement chonNgayBatDau;
	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div/select") private WebElement chonThang;
	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div/input") private WebElement chonNam;
	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/span[12]") private WebElement chonNgay;
	@FindBy(xpath = "//*[@id=\"max_lesson\"]") private WebElement nhapTietToiDa;
	@FindBy(xpath = "//*[@id=\"max_class\"]") private WebElement nhapLopToiDa;
	@FindBy(xpath = "//*[@id=\"term-form\"]/div[7]/button[2]") private WebElement nutLuu;
	@FindBy(xpath = "//*[@id=\"tblTerm\"]/tbody/tr[1]/td[9]/a[1]/i") private WebElement nutChinhSua;
	@FindBy(xpath = "//*[@id=\"tblTerm\"]/tbody/tr[1]/td[9]/a[2]") private WebElement nutXoaHocKy;
	@FindBy(xpath = "/html/body/div[3]/div/div[6]/button[1]") private WebElement nutXoa;
	@FindBy(xpath = "/html/body/div[3]/div/div[6]/button[3]") private WebElement nutHuy;
	@FindBy(xpath = "//*[@id=\"tblTerm\"]/tbody/tr[1]/td[8]") private WebElement nutKhoa;
	
	public TermPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		actions = new Actions(webDriver);
	}
	
	public void chonMucHocKy() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		chonMucHK.click();
	}
	
	public void scroll() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		chonSLKocKy.click();
		Thread.sleep(2000);
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
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
		webDriver.findElement(By.xpath("/html/body/div[2]/button")).click();
		Thread.sleep(2000);
	}
	
	public void toanVaThuManHinh() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		toanVaThuManHinh.click();
	}
	
	public void themHocKy(String maHK, String tuanBD, String nam, String tietToiDa, String lopToiDa) throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		  // Nhấn nút thêm học kỳ mới
		  nutThemMoi.click();
		  Thread.sleep(2000);
		  
		  // Nhập học kỳ
		  nhapHocKy.sendKeys(maHK);
		  Thread.sleep(3000);
		  
		  //Chọn Năm bắt đầu
		  chonNamBD.click();
		  //Nhấn nút Down và chọn phần tử đó
		  actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		  Thread.sleep(2000);
		  
		  //Chọn Năm kết thúc
		  chonNamKT.click();
		  //Nhấn nút Down và chọn phần tử đó
		  actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		  Thread.sleep(2000);
		  
		  //Chuyển sang ô nhập Tuần bắt đầu
		  actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		  Thread.sleep(2000);
		  
		  // Nhập tuần bắt đầu
		  nhapTuanBatDau.sendKeys(tuanBD);
		  Thread.sleep(2000);
		  	
		  // Chọn ngày bắt đầu	
		  chonNgayBatDau.click();
		  Thread.sleep(2000);
		  // Chọn tháng
		  chonThang.click();
		  Select chon_thang = new Select(chonThang);
		  chon_thang.selectByVisibleText("Tháng tư");
		  Thread.sleep(5000);
		  // Nhập năm
		  chonNam.click();
		  chonNam.sendKeys(nam);
		  Thread.sleep(5000);
		  // Chọn ngày	
		  chonNgay.click();
		  Thread.sleep(2000);
		  
		  //Chuyển sang ô nhập Tiết tối đa
		  actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		  Thread.sleep(2000);
		  
		  // Nhập tiết tối đa
		  nhapTietToiDa.sendKeys(tietToiDa);
		  Thread.sleep(2000);	  
		  
		  //Chuyển sang ô nhập Lớp tối đa
		  actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		  Thread.sleep(2000);
		  
		  // Nhập lớp tối đa
		  nhapLopToiDa.sendKeys(lopToiDa);
		  Thread.sleep(2000);
		  
		  // Nhấn nút Lưu
		  nutLuu.click();
	}
	
	public void suaHocKy(String tuanBD, String nam, String tietToiDa, String lopToiDa) throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		  // Nhấn nút chỉnh sửa học kỳ
		  nutChinhSua.click();
		  Thread.sleep(2000);
		  
		  //Chọn Năm bắt đầu
		  chonNamBD.click();
		  //Nhấn nút Down và chọn phần tử đó
		  actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		  Thread.sleep(2000);
		  
		  //Chọn Năm kết thúc
		  chonNamKT.click();
		  //Nhấn nút Down và chọn phần tử đó
		  actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		  Thread.sleep(2000);
		  
		  //Chuyển sang ô nhập Tuần bắt đầu
		  actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		  Thread.sleep(2000);
		  
		  // Nhập tuần bắt đầu
		  nhapTuanBatDau.sendKeys(tuanBD);
		  Thread.sleep(2000);
		  	
		  // Chọn ngày bắt đầu	
		  chonNgayBatDau.click();
		  Thread.sleep(2000);
		  // Chọn tháng
		  chonThang.click();
		  Select chon_thang = new Select(chonThang);
		  chon_thang.selectByVisibleText("Tháng tư");
		  Thread.sleep(5000);
		  // Nhập năm
		  chonNam.click();
		  chonNam.sendKeys(nam);
		  Thread.sleep(5000);
		  // Chọn ngày	
		  chonNgay.click();
		  Thread.sleep(2000);
		  
		  //Chuyển sang ô nhập Tiết tối đa
		  actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		  Thread.sleep(2000);
		  
		  // Nhập tiết tối đa
		  nhapTietToiDa.sendKeys(tietToiDa);
		  Thread.sleep(2000);	  
		  
		  //Chuyển sang ô nhập Lớp tối đa
		  actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		  Thread.sleep(2000);
		  
		  // Nhập lớp tối đa
		  nhapLopToiDa.sendKeys(lopToiDa);
		  Thread.sleep(2000);
		  
		  // Nhấn nút Lưu
		  nutLuu.click();
	}
	
	public void xoaHocKy() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		nutXoaHocKy.click();
		Thread.sleep(2000);
		nutXoa.click();
	}
	
	public void huyXoaHocKy() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		nutXoaHocKy.click();
		Thread.sleep(2000);
		nutHuy.click();
	}
	
	public void khoaHocKy() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		nutKhoa.click();
	}
}
