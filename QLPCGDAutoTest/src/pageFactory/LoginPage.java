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
	public final static String COOKIE_VALUE = "IYtgNa-9dE7KpcTfKmSTRPlHEAGFmJr6W4n48LjuSNtOWXe2ZIvNthtqXXczl8MRpphqh0mL6hsDb_XmnduFDwlMMFEkF9ZKLbFffwnC2BQCcO7IIW7Z-P-jRUPeXMSWvhHP5huSDscdedUmWGbuD2Hc3Fb257ToPcE1YRzOqizfGmAUrjHAGqPIfwk78ftpMzNwY55kJwEFWUuswOk83dGDHgGrKdRDClTIwNsxr0TLFC-C6TKx6e-uffj5yqAeRcbXGRvDd0OQOOen05XWp9SjWdJeSXbsHWvlK9zkvc13aJcjT9yTupAkpWcIvw4zcbxGsnJ72PlFf1en-9a6pYKYJZgzI3q2f3o9nzgfKXI7VQ5iO78DOeMVg3v-b2fgKxaw-6kAvSpPu86XeFEC4S8Sggoxre0VU9j4rn1wWk9kpWyj6L5iPydVMr_pC3V4-60fth7lu-LVTmsVQVoSfTV_Fpr4EuFKfMU39Ss-bXn-IFYOfqYHD8S03ys75xFt16mwuO0GbgPuZMpqd5ExTFaZoJSTFcb54KSi5BK6V9jbeYwT8WDNl3qdHFBuZ_SG4zEvz1PSIngWz_Z2VEUxW2U19zUUqRNsixqeZ35mTunOPMXYhzvfVajaNleZJZaKj3kWI0QeF8uRcEq9C9bLCOBKfGjdNnEGaXk5lzCPwFT0qni9UUYNy9XZ6lxcAZS-JM9F5oeiMfDEHFXCcI50kyw65QoMmYcxz1Xhtg7lksoAQ7Q5FEpJWMipXvHXbgIk-nj4Dqq38PIFcHh80UT3afJDs2KpRtdOfZ9Vd1ITwlax-mR-F91SU51FS5ILdO529xR72W2MsiEybuvAukea22-uLckcPrkeRv4Wy1jV58SPJif2fpiyuLCdraoRrAjIFRHORdVCxMFPuOT0Xdg_2tQq6f-kZV-MLHrVm4ijIf_8bYPKf6PA68laViGkX8qx5cpXnmw2hv7NZkMs14kAdPa58nMzxcTXWU9EDCvS-1TzJqxwfkn88zBYiMaYZu77xAmc7ZYeYA8arsKRl5DXp-dhFoTTMgSQMzvw-0IhhW4jPE6gm5AJq7vXkJr53KL38h6RIuL5eTcm_hu5lXdvp_hcNMHZSAdInw6TtP7BbUWQXDYH87AfJLWpVB6Cl3kU-rJBSgBowTOPodRf6WGeQu_CLBmco0VD3PShAXCGaM3ZyL2NPutjDCOwl2NoIdusCv2B-tN7jmNNmH9to-wzKN_oTdOaOxFhoiAmKoEvSpQ";
	
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