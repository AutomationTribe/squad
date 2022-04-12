package adminModulePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KYCDetailPage {
	
	public WebDriver _driver;
	
	public KYCDetailPage(WebDriver driver) {
		this._driver = driver;
	}
	
	By approveKycButton = By.cssSelector("button[class='css-gt34my']");
	By rejectKycButton = By.cssSelector("button[class='css-1v52ne8']");
	
	public WebElement ApproveKycButton() {
		return _driver.findElement(approveKycButton);
	}
	
	public WebElement RejectKycButton() {
		
		return _driver.findElement(rejectKycButton);
	}

}
