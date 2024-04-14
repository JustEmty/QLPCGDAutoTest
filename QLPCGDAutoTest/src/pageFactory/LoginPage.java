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
	public final static String COOKIE_VALUE = "PfUoqNL7uXiO9EY7qbw11fOI7VUEbO3IJ9jf9kA1c0Imz9cSl79GK3rVGSp8A_aSvir6nTBstcpjcc2QzX_GRUwgjEzG6CPgQkzlAzH1TA5SGpdhg8Avx8FqlclO7QW4ogOSxs4yoSR18CAnzIG2WWKZtgWP0O7N5FsnQlqxXwHBMsRsiMLCAdcB8GCwc75IWVeQEM06WP1jFi0IwW5-jhQPYiF7yR0ENoYa86mtozSzUSu87HjRQdLMH71hYi6C23hxBGvtAKZauO4kwa3G_7Mu4BnkuJB57l09A4gSBZNBUAeskRi3btoaZGu4cNFlDQUz_AM7KMGFrfpzmdJBkQG3L6Th4fEousg6yMLQcJCTDRKbgtdwz3gNQRpTxhetmDUhmuGwX3db0uDlyAwS8ZU9zFpXlUtR3Tqw-Mppk-u1d0Tutee1itQtMcts_aJNf6Qtm1s2fWcfHXsdhBRs_tcjsJDiKy7js4_-MtWZAvshOKpME0_dT_Feg2A17tg3QO32u6CorLTj_zkK_Aeec3ajgHwTX4gaQVK4zyrqiBLHDrg7YQYS1FlmFcob4iKFL1w5DGX52sFWso4p5enZ9Im965fF4NZiMYQB_WMuHw--Q8zVWGkKTqW-e3Gq70TjrxZScvD22f1fHDTgpxFFFvtDMEeUSPUeKuz9jGmvGXGQPpwu9vm5IZVpsIPu4EVT6Xo-SQnwp_Ma5WRpY125MUognBxbrCJ0t9pxJg94e7VR9Rwvr0DH7DObvOGleZWmJNWHTREpCmAbKRGFrdxg-U-dtF6OxvRB3l9Pjeh_TLGiEedhzRsu46jpHWWSdYYf_WyBRj9rrL9LcgFT--GdMpCVlegSBpYf8YuACQgV69ahVHLkmSmT49cSYusBxcUa4njP7qLX-owg8xSuLKnJsTsHPd79n9HhEcdofhOF3fYShvaCuAHGcS988wK9pS_N41XXhpmcjqfk9RszEEer_bibX3X8S7NhKTTncg_kKQPL8BM89n1dsnv23lPSiDwQz6-wD0gFPu2_3R0bPzdAFx-BLPa55eXEBOhlYb_v9C9Efc6LvG_UaipM6lLxkx9Ce7d-hoKjY4XIY6pxQBPd9CNR6eT-NmHdV7JhsPi8hGzXzmE1ui5pROZCp6RjVjhWmiQoar19KW1x6ZRe8xux93oheij25lJE84VRWYn0K5gHaRcJXmJgN2ZzREGfeJId2kZ4zjE_BzdTAXlU1Ru2AVa_j7mvOzq4Mi0rHkJ9TSbr7dVHwCCtHwbmsUZvocE9CTOP3xHoU4pbYmUvAB458pr8k_FMBVBzOVzsoEuh4e6FJy60tQk4BT-XWg8_UclR";
	
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
		Thread.sleep(1500);
	}
}