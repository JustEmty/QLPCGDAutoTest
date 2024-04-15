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

public class StatisticsLectureHoursPage {
	
	private WebDriver webDriver;
	private Actions actions;
	
	@FindBy(xpath = "//*[@id=\"select2-unit-container\"]") private WebElement typeSelection;
	@FindBy(xpath = "//*[@id=\"select2-term-container\"]") private WebElement termSelection;
	@FindBy(xpath = "//*[@id=\"select2-year-container\"]") private WebElement yearSelection;
	@FindBy(xpath = "//*[@id=\"select2-major-container\"]") private WebElement majorSelection;
	@FindBy(xpath = "//*[@id=\"select2-lecturerType-container\"]") private WebElement lectureTypeSelection;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input") private WebElement majorSelectionSearchField;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[1]/input") private WebElement lectureTypeSelectionSearchField;	
	@FindBy(xpath = "/html/body/div[2]/nav/div/div/ul[2]/li/a/i") private WebElement fullAndMinimizeScreenButton;
	@FindBy(xpath = "//*[@id=\"table-tab\"]") private WebElement tableTab;
	@FindBy(xpath = "//*[@id=\"isLesson\"]") private WebElement checkViewHoursByLessonButton;

	public StatisticsLectureHoursPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		actions = new Actions(webDriver);
	}
	
	public void setViewHoursInTerm() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		actions.click(termSelection).perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		actions.click(majorSelection).perform();
		Thread.sleep(2000);
		
		majorSelectionSearchField.sendKeys("Tất");
		Thread.sleep(2000);
				
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void setViewHoursInYear() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		actions.click(typeSelection).perform();
		Thread.sleep(2000);	
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		actions.click(majorSelection).perform();
		Thread.sleep(2000);
		
		majorSelectionSearchField.sendKeys("Tất");
		Thread.sleep(2000);
		
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		lectureTypeSelection.click();
		Thread.sleep(2000);
		
		lectureTypeSelectionSearchField.sendKeys("Tất");
		Thread.sleep(2000);
		
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void moveToTableTab() throws InterruptedException {
		tableTab.click();
		Thread.sleep(2000);
	}
	
	public void fullAndMinimizeScreenButtonClicked() throws InterruptedException {
		fullAndMinimizeScreenButton.click();
		Thread.sleep(2000);
		
		fullAndMinimizeScreenButton.click();
		Thread.sleep(2000);
	}
	
	public void getFirstDataSubjectFromTable() throws InterruptedException {
		WebElement plusButton = webDriver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[1]/td[2]/button/i"));
		plusButton.click();
		Thread.sleep(2000);
		
		WebElement table = webDriver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[2]/td/div/table"));
		List<WebElement> tableRow = table.findElements(By.tagName("tr"));
		for (WebElement row : tableRow) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement data : cells) {
				System.out.print(data.getText() + " | ");
			}
			System.out.println();
		}
	}
	
	public void checkViewHoursByLessonButtonClicked() throws InterruptedException {
		checkViewHoursByLessonButton.click();
		Thread.sleep(2000);
	}
}
