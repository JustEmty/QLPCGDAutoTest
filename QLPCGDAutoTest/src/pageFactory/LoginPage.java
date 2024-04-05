package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public final static String COOKIE_NAME = ".AspNet.Cookies";
	public final static String COOKIE_VALUE = "j5sPhuYH-OK3jS94mzJ-z88IVKTGZ57T5t3Qu85fgq01bQl6CRYISr7inwkhntwdntZpBMO6T8qz4HWRqzPMegwNuN9AcGeK7XahgxURNHHy0lua43fG0PO4AX1xmEZbS5ZmAwhgwqfyogR51HfnGsGF0gUK2tZb5HoI96zNGYa2zLaL59AAEFYoGnn94sGnNU1iQXShyTOP-PlLTC_RWkfNjfCL2bdsU1QM4Ss4N4As4qjd5Lput33ID79QEwd4kF1_2E4Lep13Lw5SjPJiVdH25eAd8_dpCS9P81chroSEzEpv55wSWrkKm370a6Mx1PDJ07fjUc70k0LEq8DlOGngOwLpN_VeJYHNsj7U88EAWfi9hcqKvq1V4m1s8B3N4nzEMPaIAuemrOb4P4jrjKaSrRobKl71KlyRhM5vIRtFXLYrMQWlHOzh2-p0RI6lim40cdN4nBBEjIuBtDbwEu9ix21_WTVEg-W9-mixYDDN-VzDkFWJUPFSgtwaBgv8ZiN89jkyAO0sg7NekCtSlpbwjxjf--mmMWoRgOCsFIWt5LD1aNhzTL5PKTWdPqYKps5iN1CBotnbZw0IyUZ1r7aTW5zJoKAgQkm3q-suMiR8t9VvUrP8BUzUQtPS_Dm1s4xukdE4gDQy-1GGeGT_tJie5F9baEVuJjxiGJRcF5RxjT5-QEEZe_GWQEyQncr4HZvkaNVa31S7bD8rhCDFOgEBnV9CQK3s13FnHNVABaoShFTKzLs-r2hZf9RvKun1zp568isT1oDfWLm0vIQhmnZeUSeRj2tLJo9_DMBbdfqv119c1CwOwAx9zG33bkT_SgldAZ1o4msOQ5U0kVob4l990DKernPP85596hwG01d8U5rX8y2Gc8uA0k67b4rcd8NHxno5rn8vwY8L1t6jRdw6lW0zDqSmz5M4blLd2UY-uTbiLSuJCbejH2c8DYz9jT5ob3wLQK2Y8QK01YACLYLyhrD5gocudWG2ChgdG0ivWRrJ1so8HR3-2veaZwLdOHP9At9UGaB5ijWKSb3cT2LF23zO6czlJSr12p4NHqekr1ksJVvJKbetAtl62aDMUVMC4ewo9vC9cPn6sICZR3cXaKtlsHB1715ikezbcXGLty4EGuqMWmIOsAZnIPlzJ0Fa-Qyq1BwUFgoK3nOz3c1zeCCcaK1ZaF3pBjNM1U0W4Zjr9pjemh7LhA0rXSVh7C4fI_rarPfeWRrsQzSJOGN9KQ87YUAZ4viQdXiLmtjCx0NuMe4NjQYWofagJd8nsra0pgvMI_kFKIEhlhQE0tDeaecWACN2oMGlfghyG0QWGyBG-L9JQJSQejwIv73C";
	
	private WebDriver webDriver;
	private String pcgdWebsiteLink = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Account/Login";
	
	@FindBy(id = "details-button") private WebElement detailsButton;
	@FindBy(id = "proceed-link") private WebElement proceedLink;
	
	public LoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public void loginToWebsite() throws InterruptedException {
		webDriver.manage().window().maximize();
		webDriver.navigate().to(pcgdWebsiteLink);

		
		detailsButton.click();
		Thread.sleep(1500);
		proceedLink.click();
		Thread.sleep(1500);
		
		webDriver.manage().addCookie(new Cookie(COOKIE_NAME, COOKIE_VALUE));
		
		webDriver.navigate().refresh();	
	}
}