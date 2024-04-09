package pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfileManagementPage {

	private WebDriver webDriver;
	private Actions actions;
	@FindBy(xpath = "//*[@id=\"dropdown-user\"]/span/img") private WebElement logoHoSo;
	@FindBy(xpath = "/html/body/div[2]/nav/div/ul/li[2]/div/a[1]") private WebElement chonMucHoSo;
	@FindBy(xpath = "//*[@id=\"staff_id\"]") private WebElement nhapMaGV;
	@FindBy(xpath = "//*[@id=\"full_name\"]") private WebElement nhapTenGV;
	@FindBy(xpath = "//*[@id=\"profile-form\"]/button") private WebElement nutCapNhat;
	
	public UserProfileManagementPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		actions = new Actions(webDriver);
	}
	public void capNhatHoSo(String maGV, String tenGV) throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logoHoSo.click();
		Thread.sleep(2000);
		chonMucHoSo.click();
		Thread.sleep(2000);
		nhapMaGV.click();
		Thread.sleep(2000);
		actions.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(2000);
		nhapMaGV.sendKeys(maGV);
		Thread.sleep(2000);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		nhapTenGV.sendKeys(tenGV);
		Thread.sleep(2000);
		nutCapNhat.click();
	}
}
