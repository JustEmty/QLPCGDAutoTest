package pageFactory;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver webDriver;
	
	@FindBy(xpath = "//*[@id=\"dropdown-user\"]") private WebElement dropdownUserButton;
	@FindBy(xpath = "/html/body/div[2]/nav/div/ul/li[2]/div/a[2]") private WebElement logoutButton;
	
	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public void lougoutFromWebsite() throws InterruptedException {
		dropdownUserButton.click();
		Thread.sleep(1500);
		logoutButton.click();
		Thread.sleep(1500);	
	}
}