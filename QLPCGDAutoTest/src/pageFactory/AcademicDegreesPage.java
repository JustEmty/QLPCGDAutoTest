package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcademicDegreesPage {

	private WebDriver webDriver;
	private MenuTab menuTab;
	private Actions actions;
	
	@FindBy(xpath = "/html/body/div[2]/nav/div/div/ul[2]/li/a/i") private WebElement fullAndMinimizeScreenButton;
	@FindBy(xpath = "//*[@id=\"tblAcademicDegree_wrapper\"]/div[1]/div[2]/div/div[2]/button/span") private WebElement addAcademicDegrees;
	@FindBy(xpath = "//*[@id=\"id\"]") private WebElement academicDegreesId;
	@FindBy(xpath = "//*[@id=\"name\"]") private WebElement academicDegreesNAme;
	@FindBy(xpath = "//*[@id=\"academicdegree-form\"]/div[4]/button[2]") private WebElement saveAcademicDegreesButton;
	@FindBy(xpath = "/html/body/div[3]/div[1]/button") private WebElement closeAcademicDegreesFormButton;
	@FindBy(xpath = "//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]/i") private WebElement updateAcademicDegrees;
	@FindBy(xpath = "//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[2]/i") private WebElement deleteAcademicDegreesFormButton;
	@FindBy(xpath = "/html/body/div[3]/div/div[6]/button[1]") private WebElement confirmDeleteAcademicDegrees;
	@FindBy(xpath = "/html/body/div[3]/div/div[6]/button[3]") private WebElement cancelDeleteAcademicDegrees;
	@FindBy(xpath = "//*[@id=\"tblAcademicDegree_filter\"]/label/input") private WebElement searchField;
	
	public AcademicDegreesPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		menuTab = new MenuTab(webDriver);
	}
	
	public void fullAndMinimizeScreenButtonClicked() throws InterruptedException {
		fullAndMinimizeScreenButton.click();
		Thread.sleep(2000);
		
		fullAndMinimizeScreenButton.click();
		Thread.sleep(2000);
	}
	
	public void addAcademicDegreesPressed() throws InterruptedException {
		addAcademicDegrees.click();
		Thread.sleep(2000);
	}
	
	public void addDataToAcademicDegreesForm(String academicDegreesID, String academicDegreesName) throws InterruptedException{
		academicDegreesId.sendKeys(academicDegreesID);
		Thread.sleep(2000);
		
		academicDegreesNAme.sendKeys(academicDegreesName);
		Thread.sleep(2000);
		
		actions = new Actions(webDriver);
		actions.moveToElement(academicDegreesNAme).sendKeys(Keys.TAB).sendKeys("3").perform();
		Thread.sleep(2000);
		
		actions.click(saveAcademicDegreesButton).perform();
		Thread.sleep(2000);
	}
	
	public void updateDataToAcademicDegreesForm(String academicDegreesName) throws InterruptedException{	
		academicDegreesNAme.clear();
		academicDegreesNAme.sendKeys(academicDegreesName);
		Thread.sleep(2000);
		
		actions = new Actions(webDriver);
		actions.moveToElement(academicDegreesNAme).sendKeys(Keys.TAB).sendKeys("3").perform();
		Thread.sleep(2000);
		
		actions.click(saveAcademicDegreesButton).perform();
		Thread.sleep(2000);
	}
	
	public boolean isEnableSaveAcademicDegreesButton() {
		return saveAcademicDegreesButton.isEnabled();
	}
	
	public void closeAcademicDegreesFormButtonPressed() throws InterruptedException {
		closeAcademicDegreesFormButton.click();
		Thread.sleep(2000);
	}
	
	public void updateAcademicDegreesPressed() throws InterruptedException {
		updateAcademicDegrees.click();
		Thread.sleep(2000);
	}
	
	public void deleteAcademicDegreesPressed() throws InterruptedException {
		deleteAcademicDegreesFormButton.click();
		Thread.sleep(2000);
	}
	
	public void confirmDeleteAcademicDegreesPressed() throws InterruptedException {
		confirmDeleteAcademicDegrees.click();
		Thread.sleep(2000);
	}
	
	public void cancelDeleteAcademicDegreesPressed() throws InterruptedException {
		cancelDeleteAcademicDegrees.click();
		Thread.sleep(2000);
	}
	
	public void searchData(String data) throws InterruptedException {
		searchField.sendKeys(data);
		Thread.sleep(2000);
		searchField.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	public void getAcademicDegreesDataTable() {
		for (int i = 1; i < 3; i++) {
			for (int j = 1; j < 5; j++) {
				WebElement dulieu = webDriver
						.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[" + i + "]/td[" + j + "]"));
				System.out.print(dulieu.getText() + " | ");
			}
			System.out.println();
			System.out.println("--------------------------------------------------");
		}
	}
}
