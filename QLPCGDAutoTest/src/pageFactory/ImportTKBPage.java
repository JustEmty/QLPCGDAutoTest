package pageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportTKBPage {

	private WebDriver webDriver;
	private Actions actions;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[4]/a/span") private WebElement mucThoiKhoaBieu;
	@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/ul/li[4]/ul/li[1]/a/span") private WebElement mucImportTKB;
	@FindBy(xpath = "//*[@id=\"select2-term-container\"]") private WebElement nutChonHocKy;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span[2]/span/span[1]/input") private WebElement truongHocKy;
	@FindBy(xpath = "//*[@id=\"select2-major-container\"]") private WebElement nutChonNganh;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span[2]/span/span[1]/input") private WebElement truongNganh;
	@FindBy(xpath = "//*[@id=\"dpz-single-file\"]/div") private WebElement uploadFile;
	@FindBy(xpath = "//*[@id=\"submit-all\"]") private WebElement nutImport;
	@FindBy(xpath = "/html/body/div[3]/div/div[6]/button[1]") private WebElement nutThayThe;
	@FindBy(xpath = "/html/body/div[3]/div/div[6]/button[1]") private WebElement nutImportTiep;
	@FindBy(xpath = "/html/body/div[3]/div/div[6]/button[1]") private WebElement nutXacNhan;
	
	public ImportTKBPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		actions = new Actions(webDriver);
	}
	public void chonMucImportTKB() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Nhấn vào mục Thời khóa biểu
		mucThoiKhoaBieu.click();
		Thread.sleep(2000);
		// Chọn vào mục Import TKB
		mucImportTKB.click();
	}
	public void chonHocKy_Nganh(String hocky) throws InterruptedException {
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
		truongNganh.sendKeys(Keys.ENTER);
	}
	public void tiepTucImport() throws InterruptedException {
		Thread.sleep(5000);
		nutThayThe.click();
		
		Thread.sleep(5000);
		nutImportTiep.click();
		
		Thread.sleep(30000);
		nutXacNhan.click();
	}
	public void ImportTKB() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String filePath = "C:\\Users\\OS\\Downloads\\CNTT UIS-ThoiKhoaBieu_TieuChuan_Mau.xlsx";
		// Nhấn vào phần Upload file
		uploadFile.click();
		Thread.sleep(2000);
		// Khởi tạo Robot class
		Robot rb = null;
		try {
		  rb = new Robot();
		} catch (AWTException e) {
		  e.printStackTrace();
		}

		// Copy File path vào Clipboard
		StringSelection str = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		Thread.sleep(2000);

		// Nhấn Control+V để dán
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		// Xác nhận Control V trên
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		Thread.sleep(2000);

		// Nhấn Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(10000);
		nutImport.click();
	}
}
