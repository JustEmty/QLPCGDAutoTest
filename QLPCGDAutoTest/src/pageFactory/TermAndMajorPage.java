package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TermAndMajorPage {
	
	public enum CTDT{
		TieuChuan,
		DacBiet,
		CTDT
	}
	
	private static final String MAJOR_TAB_URL = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Major";
	
	private WebDriver webDriver;
	private MenuTab menuTab;
	private CTDT ctdt;
	
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a") private WebElement majorTab;
	@FindBy(xpath = "//*[@id=\"id\"]") private WebElement majorIdField;
	@FindBy(xpath = "//*[@id=\"name\"]") private WebElement majorNameField;
	@FindBy(xpath = "//*[@id=\"abbreviation\"]") private WebElement abbreviationField;
	@FindBy(xpath = "//*[@id=\"tblMajor_wrapper\"]/div[1]/div[2]/div/div[2]/button") private WebElement addMajorButton;
	@FindBy(xpath = "//*[@id=\"major-form\"]/div[5]/button[2]") private WebElement saveMajorButton;
	@FindBy(xpath = "/html/body/div[3]/div[1]/button") private WebElement closeMajorFormButton;
	@FindBy(xpath = "//*[@id=\"tblMajor\"]/tbody/tr[4]/td[6]/a[1]") private WebElement updateMajorFormButton;
	@FindBy(xpath = "//*[@id=\"tblMajor\"]/tbody/tr[4]/td[6]/a[2]") private WebElement deleteMajorFormButton;
	@FindBy(xpath = "/html/body/div[3]/div/div[6]/button[1]") private WebElement confirmDeleteMajorFormButton;
	@FindBy(xpath = "/html/body/div[3]/div/div[6]/button[3]") private WebElement cancelDeleteMajorFormButton;
	@FindBy(xpath = "//*[@id=\"tblMajor_filter\"]/label/input") private WebElement searchField;
	@FindBy(xpath = "//*[@id=\"tblMajor\"]") private WebElement majorDataTable;
	
	public TermAndMajorPage(WebDriver webDriver){
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		menuTab = new MenuTab(webDriver);
	}
	
	public void moveToMajorTab() throws InterruptedException {
		menuTab.moveToTermAndMajorTab();
		
		majorTab.click();
		Thread.sleep(2000);
	}
	
	public void addMajorButtonPressed() throws InterruptedException {
		addMajorButton.click();
		Thread.sleep(2000);
	}
	
	public void closeMajorFormButtonPressed() throws InterruptedException {
		closeMajorFormButton.click();
		Thread.sleep(2000);
	}
	
	public void updateMajorFormButtonPressed() throws InterruptedException {
		updateMajorFormButton.click();
		Thread.sleep(2000);
	}
	
	public void deleteMajorFormButtonPressed() throws InterruptedException {
		deleteMajorFormButton.click();
		Thread.sleep(2000);
	}
	
	public void confirmDeleteMajorFormButtonPressed() throws InterruptedException {
		confirmDeleteMajorFormButton.click();
		Thread.sleep(2000);
	}
	
	public void cancelDeleteMajorFormButtonPressed() throws InterruptedException {
		cancelDeleteMajorFormButton.click();
		Thread.sleep(2000);
	}
	
	public void addDataToMajorForm(String majorId, String majorName, String abbreviation, CTDT ctdt) throws InterruptedException{
		majorIdField.sendKeys(majorId);
		Thread.sleep(1000);
		
		majorNameField.sendKeys(majorName);
		Thread.sleep(1000);
		
		abbreviationField.sendKeys(abbreviation);
		Thread.sleep(1000);
		
		Actions actions = new Actions(webDriver);
		actions.moveToElement(abbreviationField).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		
		switch (ctdt) {
			case TieuChuan:
				actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).perform();
				Thread.sleep(1000);
				break;
			case DacBiet:
				actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
				Thread.sleep(1000);
				break;
			case CTDT:
				actions.sendKeys(Keys.TAB).perform();
				Thread.sleep(1000);
				break;
			default:
				break;
		}
		
		actions.click(saveMajorButton).perform();
		Thread.sleep(1000);
	}
	
	public void updateDataToMajorForm(String majorName, String abbreviation, CTDT ctdt) throws InterruptedException{
		majorNameField.clear();
		Thread.sleep(2000);
		
		majorNameField.sendKeys(majorName);
		Thread.sleep(2000);
		
		abbreviationField.clear();
		Thread.sleep(2000);
		
		abbreviationField.sendKeys(abbreviation);
		Thread.sleep(2000);
		
		Actions actions = new Actions(webDriver);
		actions.moveToElement(abbreviationField).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		switch (ctdt) {
			case TieuChuan:
				actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);
				break;
			case DacBiet:
				actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);
				break;
			case CTDT:
				actions.sendKeys(Keys.TAB).perform();
				Thread.sleep(2000);
				break;
			default:
				break;
		}
		
		actions.click(saveMajorButton).perform();
		Thread.sleep(2000);
	}
	
	public boolean isEnableSaveMajorButton() {
		return saveMajorButton.isEnabled();
	}

	public void searchData(String data) throws InterruptedException {
		searchField.sendKeys(data);
		Thread.sleep(2000);
		searchField.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	public void getMajorDataTable() {
		List<WebElement> rows = majorDataTable.findElements(By.tagName("tr"));
		
		for (WebElement row : rows) {
		    List<WebElement> cells = row.findElements(By.tagName("td"));
		    for (WebElement cell : cells) {
		        System.out.print(cell.getText() + " | ");
		    }
		    System.out.println();
		}
	}
	
	public boolean isErrorMessagesDisplayed() {
		if(webDriver.findElement(By.className("error")).isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public List<WebElement> getErrorMessageList() {
		List<WebElement> errorMessageList = webDriver.findElements(By.className("error"));
		
		return errorMessageList;
	}
	
	public String getToastMessage() {
		return webDriver.findElement(By.className("toast-message")).getText();
	}
}
