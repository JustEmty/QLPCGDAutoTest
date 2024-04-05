package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcademicDegreesRankPage {

	private WebDriver webDriver;
	private MenuTab menuTab;
	private Actions actions;
	
	@FindBy(xpath = "/html/body/div[2]/nav/div/div/ul[2]/li/a/i") private WebElement fullAndMinimizeScreenButton;
	@FindBy(xpath = "//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button/span") private WebElement addAcademicDegreesRank;
	@FindBy(xpath = "//*[@id=\"select2-academic_degree_id-container\"]") private WebElement typeAcademicDegrees;
	@FindBy(xpath = "//*[@id=\"id\"]") private WebElement rankId;
	@FindBy(xpath = "//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]") private WebElement saveAcademicDegreesRankButton;
	@FindBy(xpath = "/html/body/div[3]/div[1]/button") private WebElement closeAcademicDegreesRankFormButton;
	@FindBy(xpath = "//*[@id=\"tblAcademicDegreeRank\"]/tbody/tr[2]/td[2]/a[1]/i") private WebElement updateAcademicDegreesRank;
	@FindBy(xpath = "//*[@id=\"tblAcademicDegreeRank\"]/tbody/tr[2]/td[2]/a[2]/i") private WebElement deleteAcademicDegreesRankFormButton;
	@FindBy(xpath = "/html/body/div[3]/div/div[6]/button[1]") private WebElement confirmDeleteAcademicDegreesRank;
	@FindBy(xpath = "/html/body/div[3]/div/div[6]/button[3]") private WebElement cancelDeleteAcademicDegreesRank;
	@FindBy(xpath = "//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input") private WebElement searchField;
	
	public AcademicDegreesRankPage(WebDriver webDriver) {
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
	
	public void addAcademicDegreesRankPressed() throws InterruptedException {
		addAcademicDegreesRank.click();
		Thread.sleep(2000);
	}
	
	public void addDataToAcademicDegreesRankForm(String rankID) throws InterruptedException{
		actions = new Actions(webDriver);
		typeAcademicDegrees.click();
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		rankId.sendKeys(rankID);
		Thread.sleep(2000);
		
		actions.click(saveAcademicDegreesRankButton).perform();
		Thread.sleep(2000);
	}
	
	public void updateDataToAcademicDegreesRankForm() throws InterruptedException{
		actions = new Actions(webDriver);
		typeAcademicDegrees.click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		actions.click(saveAcademicDegreesRankButton).perform();
		Thread.sleep(2000);
	}
	
	public boolean isEnableSaveAcademicDegreesRankButton() {
		return saveAcademicDegreesRankButton.isEnabled();
	}
	
	public void closeAcademicDegreesRankFormButtonPressed() throws InterruptedException {
		closeAcademicDegreesRankFormButton.click();
		Thread.sleep(2000);
	}
	
	public void updateAcademicDegreesRankPressed() throws InterruptedException {
		updateAcademicDegreesRank.click();
		Thread.sleep(2000);
	}
	
	public void deleteAcademicDegreesRankPressed() throws InterruptedException {
		deleteAcademicDegreesRankFormButton.click();
		Thread.sleep(2000);
	}
	
	public void confirmDeleteAcademicDegreesRankPressed() throws InterruptedException {
		confirmDeleteAcademicDegreesRank.click();
		Thread.sleep(2000);
	}
	
	public void cancelDeleteAcademicDegreesRankPressed() throws InterruptedException {
		cancelDeleteAcademicDegreesRank.click();
		Thread.sleep(2000);
	}
	
	public void searchData(String data) throws InterruptedException {
		searchField.sendKeys(data);
		Thread.sleep(2000);
		searchField.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	public void getAcademicDegreesRankDataTable() {
		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 2; j++) {
				WebElement dulieu1 = webDriver
						.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody/tr[" + i + "]/td[" + j + "]"));
				System.out.print(dulieu1.getText());
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}
}
