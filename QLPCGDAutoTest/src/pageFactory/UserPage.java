package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	public enum LGV{
		CoHuu,
		ThinhGiang
	}
	
	public enum Role{
		BCNKhoa,
		BoMon,
		GiangVien,
		ChuaPhanQuyen
	}
	
	private WebDriver webDriver;
	private Actions actions;
	private MenuTab menuTab;
	
	@FindBy(xpath = "//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button/span") private WebElement addUser;
	@FindBy(xpath = "//*[@id=\"staff_id\"]") private WebElement userIdField;
	@FindBy(xpath = "//*[@id=\"full_name\"]") private WebElement userNameField;
	@FindBy(xpath = "//*[@id=\"email\"]") private WebElement userEmailField;
	@FindBy(xpath = "//*[@id=\"select2-type-container\"]") private WebElement userType;
	@FindBy(xpath = "//*[@id=\"user-form\"]/div[7]/button[2]") private WebElement saveUserButton;
	@FindBy(xpath = "/html/body/div[3]/div[1]/button") private WebElement closeUserFormButton;
	@FindBy(xpath = "//*[@id=\"tblUser\"]/tbody/tr[1]/td[7]/a[1]") private WebElement updateUserFormButton;
	@FindBy(xpath = "//*[@id=\"tblUser_filter\"]/label/input") private WebElement searchField;
	@FindBy(xpath = "//*[@id=\"tblUser_length\"]/label/select") private WebElement userLength;
	@FindBy(xpath = "//*[@id=\"tblUser_wrapper\"]/div[1]/div[1]/div[2]/div/label/div/span/span[1]/span/"
			+ "ul/li[6]/input") private WebElement showColumns;
	@FindBy(xpath = "//*[@id=\"tblUser\"]/tbody/tr[1]/td[7]/div/input") private WebElement userStatus;
	@FindBy(xpath = "//*[@id=\"tblUser\"]/tbody/tr[1]/td[8]/a[2]/i") private WebElement deleteUserFormButton;
	@FindBy(xpath = "/html/body/div[3]/div/div[6]/button[1]") private WebElement confirmDeleteUserFormButton;
	@FindBy(xpath = "/html/body/div[3]/div/div[6]/button[3]") private WebElement cancelDeleteUserFormButton;
	
	public UserPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		
		menuTab = new MenuTab(webDriver);
	}
	
	public void moveToUserTab() throws InterruptedException {
		menuTab.moveToUserTab();
		Thread.sleep(2000);
	}
	
	public void addUserButtonPressed() throws InterruptedException {
		addUser.click();
		Thread.sleep(2000);
	}
	
	public void closeUserFormButtonPressed() throws InterruptedException {
		closeUserFormButton.click();
		Thread.sleep(2000);
	}
	
	public void updateUserFormButtonPressed() throws InterruptedException {
		updateUserFormButton.click();
		Thread.sleep(2000);
	}
	
	public void deleteUserFormButtonPressed() throws InterruptedException {
		deleteUserFormButton.click();
		Thread.sleep(2000);
	}
	
	public void confirmDeleteUserFormButtonPressed() throws InterruptedException {
		confirmDeleteUserFormButton.click();
		Thread.sleep(2000);
	}
	
	public void cancelDeleteUserFormButtonPressed() throws InterruptedException {
		cancelDeleteUserFormButton.click();
		Thread.sleep(2000);
	}
	
	public void addDataToUserForm(String userId, String userName, String userEmail, LGV lgv, Role role) throws InterruptedException{
		userIdField.sendKeys(userId);
		Thread.sleep(2000);
		
		userNameField.sendKeys(userName);
		Thread.sleep(2000);
		
		userEmailField.sendKeys(userEmail);
		Thread.sleep(2000);
		
		actions = new Actions(webDriver);
		actions.moveToElement(userEmailField).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		switch (lgv) {
			case CoHuu:
				actions.sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);
				break;
			case ThinhGiang:
				actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);
				break;
			default:
				break;
		}
		
		actions.moveToElement(userType).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		switch (role) {
		case BCNKhoa:
			actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			break;
		case BoMon:
			actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			break;
		case GiangVien:
			actions.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			break;
		case ChuaPhanQuyen:
			actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			break;
		default:
			break;
	}
		
		actions.click(saveUserButton).perform();
		Thread.sleep(2000);
	}
	
	public void updateDataToUserForm(String userId, String userName, String userEmail, LGV lgv, Role role) throws InterruptedException{
		userIdField.clear();
		Thread.sleep(2000);
		
		userIdField.sendKeys(userId);
		Thread.sleep(2000);
		
		userNameField.clear();
		Thread.sleep(2000);
		
		userNameField.sendKeys(userName);
		Thread.sleep(2000);
		
		userEmailField.clear();
		Thread.sleep(2000);
		
		userEmailField.sendKeys(userEmail);
		Thread.sleep(2000);
		
		actions = new Actions(webDriver);
		actions.moveToElement(userEmailField).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		switch (lgv) {
			case CoHuu:
				actions.sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);
				break;
			case ThinhGiang:
				actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);
				break;
			default:
				break;
		}
		
		actions.moveToElement(userType).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		
		switch (role) {
		case BCNKhoa:
			actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			break;
		case BoMon:
			actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			break;
		case GiangVien:
			actions.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			break;
		case ChuaPhanQuyen:
			actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			break;
		default:
			break;
	}
		
		actions.click(saveUserButton).perform();
		Thread.sleep(2000);
	}

	public boolean isEnableSaveMajorButton() {
		return saveUserButton.isEnabled();
	}
	
	public void searchData(String data) throws InterruptedException {
		searchField.sendKeys(data);
		Thread.sleep(2000);
		searchField.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	public void getUserDataTable() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j < 6; j++) {
				WebElement dulieu = webDriver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr["+i+"]/td["+j+"]"));
				System.out.print(dulieu.getText() + " | ");
			}
			System.out.println();
		}
	}
	
	public void showColumnStatus() throws InterruptedException {
		showColumns.click();
		Thread.sleep(2000);
		Actions layTrangThai = new Actions(webDriver);
		layTrangThai.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
		.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
	}
	
	public void enableStatus() throws InterruptedException {
		userStatus.click();
		Thread.sleep(3000);
	}
}
