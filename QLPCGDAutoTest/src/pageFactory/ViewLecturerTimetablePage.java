package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewLecturerTimetablePage {

	private WebDriver webDriver;
	private Actions actions;
	
	@FindBy(xpath = "/html/body/div[2]/nav/div/div/ul[2]/li/a/i") private WebElement fullAndMinimizeScreenButton;
	
	public ViewLecturerTimetablePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		actions = new Actions(webDriver);
	}
	
	public void fullAndMinimizeScreenButtonClicked() throws InterruptedException {
		fullAndMinimizeScreenButton.click();
		Thread.sleep(2000);
		
		fullAndMinimizeScreenButton.click();
		Thread.sleep(2000);
	}
}
