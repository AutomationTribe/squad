package merchantModulePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KYCPage {
	
	public WebDriver _driver;
	
	public KYCPage(WebDriver driver) {
		this._driver = driver;
	}
	
	By verifyEmail =  By.cssSelector("button[id='accordion-button-45']");
	
	
	public WebElement VerifyEmail() {
		
		return _driver.findElement(verifyEmail);
	}
}
