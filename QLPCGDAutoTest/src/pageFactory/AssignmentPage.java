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

public class AssignmentPage {
	
	private WebDriver webDriver;
	private Actions actions;
	
	@FindBy(xpath = "//*[@id=\"assignLecturerDiv\"]/div[2]/div[2]/div/button") private WebElement exportButton;
	@FindBy(xpath = "//*[@id=\"289818\"]") private WebElement assignButton;	
	@FindBy(xpath = "//*[@id=\"assignLecturerDiv\"]/div[2]/div[1]/div[5]/span[1]/span[1]/span/ul/li[353]/input") private WebElement sortLectureField;	
	
	public AssignmentPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		actions = new Actions(webDriver);
	}
	
	public void exportButtonsClicked() throws InterruptedException {
		exportButton.click();
		Thread.sleep(2000);
	}
	
	public void assignLectureToSubject() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		actions.click(assignButton).perform();
		Thread.sleep(2000);
		
		WebElement lectureListContainer = webDriver.findElement(By.xpath("//*[@id=\"select2-lecturer-4x-container\"]/span"));
		lectureListContainer.click();
		Thread.sleep(2000);
	}
}
