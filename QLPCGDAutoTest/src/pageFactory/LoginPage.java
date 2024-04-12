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
	public final static String COOKIE_VALUE = "9s_-peEe6iZJjhiyPBst1sm6o-J8AgEBthFD31_VEpx4PYfms6z7DCKS9sViPrv3W4gzenHWT46BqBtkt3ahetkgfvTIor-ENsTjeRImCTcqoSyFqd5yGBEYMhNXSsXM51JmZrfhF8zeYTeXMryJY4iRLQgoExdqQe6xAid_9xGvXa-Vi5hfOIDpKIVOtUDvYQzHqbXeuxlO6KY-lxE-5wckpqY_z3SpH338yq-gbfy0NjG2vtpdpuYESL8N-wtWfmx8sDGDuDXauqG2XDJajD0DEx0dzggjFVxB1s9WbuYWVTBYiZa0RnGba4bvDxTh0kenY06OBV6y_URXAzzUQRh6tkjCqhnNZKvztAFE7D3whvFpPXrOUjhJvUNawnkVIYTFz0_BNW8fimFgkdYOJMbB0NkmC6ijesch2wMEVI3rf-4Z8sHuirZ5hnt3yMpJeu64GOa3zlhVkuOCQroE2wFZipy66QRjttbV7Yvs-3JMF8c9xvVQFvw7cKQ0JYQAyoBSjihUS9dXygrfSKycjsmWFryfF74NBxkGx_IfeY84fl0T6SwlEakYzchIqyfShvnwxc9U1RoszFx6uwf6fiZOf5JzBqZ01X3U0mVqsWQuQwZc4NlMBibi_yB9fvI3OKwMZgsxb1a83eANMzbnmiR4wx6GSblwekZzke84wTgv7nFFQo76G3VIuOTNq8y8bQHpFxNOqX2tx6f0R4BCh1NAxfCg-lrCY81hVenQasX_KZpLdF86j5tnhRLHwzQkNTPt5Jx5Pj-qQakKzFKJ0EDSEqVUoIKPD-9TJziCxED91Y-JZBhvw-KJkpFPYB9oKslVXoCJZUSTT-PXm1sRpOSpBwappyOORrnbmNvPePDWdnuf9Nv07Ukxh3QmO4-Qz0qfWx1_L4ljRO8wxiuMyejoIFAcAwyJlWPay9swVPmZFK3byoOuzSl45omaXlgIuTmN9FiXd__ZEjKVuEuOEdu1IgEEik1aQ5wQW3ZsvEwXB6kkvUIhmObRENg-0hqIt7WAui0t7anNtIHTZwEhhRO1ZimgowL_KtIISWmYdpg_H99HngFtgZnY7Jll2qq315u81bFzCv4oRLW-AKjHe-CIatw5G8ja3lGRkA5iNznXV327JT7xfOTGfyUCmBsMncgJ54J7_e4pvpviyKi1LMtNYtbRFbiPfp1pWGjc5SyIu1tF30lz-FfgHoPVgp5QSAzJIbWeQZ-_cgHkubWZkIVJVbcsDG3hPywnmLfSCTm4Dh0-HbA_MSs1EMRMAli6-z65fyJWkinYBjBA6jnfLZ89QSPcwOu3JLY-chub60p8BsiYqegIAMYWBWlg-f7a";
	
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