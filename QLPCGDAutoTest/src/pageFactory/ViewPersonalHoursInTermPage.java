package pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewPersonalHoursInTermPage {
	
	private WebDriver webDriver;
	private Actions actions;
	
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span") private WebElement typeSelection;
	@FindBy(xpath = "/html/body/div[2]/nav/div/div/ul[2]/li/a/i") private WebElement fullAndMinimizeScreenButton;
	
	public ViewPersonalHoursInTermPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		actions = new Actions(webDriver);
	}

	public void setTerm() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void setYear() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		actions.click(typeSelection).perform();
		Thread.sleep(2000);
		
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
	}
	
	public void fullAndMinimizeScreenButtonClicked() throws InterruptedException {
		fullAndMinimizeScreenButton.click();
		Thread.sleep(2000);
		
		fullAndMinimizeScreenButton.click();
		Thread.sleep(2000);
	}
}
