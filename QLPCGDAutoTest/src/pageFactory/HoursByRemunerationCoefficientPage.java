package pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoursByRemunerationCoefficientPage {
	
	private WebDriver webDriver;
	private Actions actions;
	
	@FindBy(xpath = "//*[@id=\"select2-unit-container\"]") private WebElement typeSelection;
	@FindBy(xpath = "//*[@id=\"select2-term-container\"]") private WebElement termSelection;
	@FindBy(xpath = "//*[@id=\"select2-year-container\"]") private WebElement yearSelection;
	@FindBy(xpath = "//*[@id=\"select2-major-container\"]") private WebElement majorSelection;
	@FindBy(xpath = "/html/body/div[2]/nav/div/div/ul[2]/li/a/i") private WebElement fullAndMinimizeScreenButton;
	
	public HoursByRemunerationCoefficientPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		actions = new Actions(webDriver);
	}

	public void setViewHoursInTerm() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		actions.click(termSelection).perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		actions.click(majorSelection).perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
	}
	
	public void setViewHoursInYear() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		actions.click(typeSelection).perform();
		Thread.sleep(2000);	
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		actions.click(yearSelection).perform();
		Thread.sleep(2000);
		WebElement searchField = webDriver.findElement(By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input"));
		searchField.sendKeys("2024");
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		actions.click(majorSelection).perform();
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
