package merchantModulePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetStartedPage {
	
	public WebDriver _driver;
	
	public GetStartedPage(WebDriver driver) {
		this._driver = driver;
	}

	//By completeKyc = By.xpath("//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[1]/button");
	
	public By completeKYC = By.cssSelector("button[class='alert-card--button']");
	
	public WebElement CompleteKYC() {
		
		return _driver.findElement(completeKYC);
	}
}
