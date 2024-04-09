package pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LecturersRankPage {

	private WebDriver webDriver;
	private Actions actions;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[6]/a")
	private WebElement mucThuLao;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[4]/a/span")
	private WebElement mucCapBacGV;
	@FindBy(xpath = "//*[@id=\"tblLecturerRank\"]/tbody/tr[1]/td[5]/a")
	private WebElement nutCapNhat;
	@FindBy(xpath = "//*[@id=\"tblLecturerRank_wrapper\"]/div[1]/div[2]/div/div[2]/button")
	private WebElement nutCapNhatTatCa;
	@FindBy(xpath = "//*[@id=\"lecturerrank-form\"]/div[2]/div/span/span[1]/span")
	private WebElement truongTatCaCapBac;
	@FindBy(xpath = "//*[@id=\"select2-academic_degree_rank_id-container\"]")
	private WebElement truongCapBac;
	@FindBy(xpath = "//*[@id=\"lecturerrank-form\"]/div[4]/button[2]")
	private WebElement nutLuu;
	@FindBy(xpath = "//*[@id=\"lecturerrank-form\"]/div[3]/button[2]")
	private WebElement nutLuuTatCa;
	@FindBy(xpath = "//*[@id=\"tblLecturerRank_length\"]/label/select")
	private WebElement chonSLCapBac;
	@FindBy(xpath = "/html/body/div[2]/nav/div/div/ul[2]/li/a/i")
	private WebElement toanVaThuManHinh;
	@FindBy(xpath = "/html/body/div[2]/button")
	private WebElement nutTroVeDauTrang;
	@FindBy(xpath = "//*[@id=\"tblLecturerRank_filter\"]/label/input")
	private WebElement truongTimKiem;

	public LecturersRankPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		actions = new Actions(webDriver);
	}

	public void chonMucCapBacGV() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		mucThuLao.click();
		Thread.sleep(2000);
		mucCapBacGV.click();
	}

	public void capNhatCapBac() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		nutCapNhat.click();
		Thread.sleep(2000);
		truongCapBac.click();
		Thread.sleep(2000);
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		nutLuu.click();
	}

	public void capNhatTatCaCapBac() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		nutCapNhatTatCa.click();
		Thread.sleep(2000);
		truongTatCaCapBac.click();
		Thread.sleep(2000);
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		nutLuuTatCa.click();
	}

	public void scroll() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		chonSLCapBac.click();
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
		nutTroVeDauTrang.click();
		Thread.sleep(2000);
	}

	public void toanVaThuManHinh() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		toanVaThuManHinh.click();
	}

	public void chonSLDuLieuHienThi() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		chonSLCapBac.click();
		Thread.sleep(2000);
		actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
	}

	public void timKiemCapBac(String noidung_timkiem) throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		truongTimKiem.sendKeys(noidung_timkiem);
	}
}
