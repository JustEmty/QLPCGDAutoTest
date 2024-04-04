package pageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuTab {
	
	private WebDriver webDriver;
	private Actions actions;
	
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[1]/a") private WebElement homeTab;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[2]/a") private WebElement termAndMajorTab;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[3]/a") private WebElement userTab;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[4]/a") private WebElement scheduleTab;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[5]/a") private WebElement statisticsTab;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[6]/a") private WebElement remunerationTab;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[4]/ul/li[2]/a") private WebElement assignmentTab;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[5]/ul/li[1]/a") private WebElement lectureHoursTab;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[5]/ul/li[2]/a") private WebElement hoursByRemunerationCoefficientTab;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[5]/ul/li[3]/a") private WebElement viewVisitingLecturerStatisticsTab;
	@FindBy(xpath = "//*[@id=\"main-menu-navigation\"]/li[5]/ul/li[4]/a") private WebElement viewPersonalHoursInTermTab;
	
	
	public MenuTab(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		actions = new Actions(webDriver);
	}
	
	public void moveToTermAndMajorTab() throws InterruptedException {
		termAndMajorTab.click();
		Thread.sleep(2000);
	}
	
	public void moveToAssignmentTab() throws InterruptedException {
		actions.click(scheduleTab).perform();
		Thread.sleep(2000);
		
		actions.click(assignmentTab).perform();
		Thread.sleep(2000);
	}
	
	
	public void moveToStatisticsTab() throws InterruptedException {
		actions.click(statisticsTab).perform();
		Thread.sleep(2000);
	}
	
	public void moveToViewLessonTab() throws InterruptedException {
		moveToStatisticsTab();
		
		actions.click(lectureHoursTab).perform();
		Thread.sleep(2000);
	}
	
	public void moveToViewHoursByRemunerationCoefficientTab() throws InterruptedException {
		moveToStatisticsTab();
		
		actions.click(hoursByRemunerationCoefficientTab).perform();
		Thread.sleep(2000);
	}
	
	public void moveToViewVisitingLecturerStatisticsTab() throws InterruptedException {
		moveToStatisticsTab();
		
		actions.click(viewVisitingLecturerStatisticsTab).perform();
		Thread.sleep(2000);
	}
	
	public void moveToViewPersonalHoursInTermTab() throws InterruptedException {
		moveToStatisticsTab();
		
		actions.click(viewPersonalHoursInTermTab).perform();
		Thread.sleep(2000);
	}
	
	public void moveToUserTab() throws InterruptedException {
		userTab.click();
		Thread.sleep(2000);
	}
}
