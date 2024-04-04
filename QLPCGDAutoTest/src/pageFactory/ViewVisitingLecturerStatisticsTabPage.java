package pageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewVisitingLecturerStatisticsTabPage {

	private WebDriver webDriver;
	private Actions actions;
	
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span/span[1]/span/ul") private WebElement termSelection;
	@FindBy(xpath = "//*[@id=\"submit-all\"]") private WebElement statictisButton;
	@FindBy(xpath = "/html/body/div[2]/nav/div/div/ul[2]/li/a/i") private WebElement fullAndMinimizeScreenButton;
	
	public ViewVisitingLecturerStatisticsTabPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		actions = new Actions(webDriver);
	}
	
	public void setTerm() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		actions.click(termSelection).perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		actions.click(termSelection).perform();
		Thread.sleep(2000);
		
		statictisButtonClicked();
	}
	
	private void statictisButtonClicked() throws InterruptedException {
		statictisButton.click();
		Thread.sleep(2000);
	}
	
	public void getDataFromTable() throws InterruptedException {
		WebElement table = webDriver.findElement(By.xpath("//*[@id=\"tblStatistics\"]"));
		List<WebElement> tableRow = table.findElements(By.tagName("tr"));
		for (WebElement row : tableRow) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement data : cells) {
				System.out.print(data.getText() + " | ");
			}
			System.out.println();
		}
	}
	
	public void fullAndMinimizeScreenButtonClicked() throws InterruptedException {
		fullAndMinimizeScreenButton.click();
		Thread.sleep(2000);
		
		fullAndMinimizeScreenButton.click();
		Thread.sleep(2000);
	}
}
