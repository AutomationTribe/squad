package adminModulePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KYCScreenPage {
	
	public WebDriver _driver;
	
	public KYCScreenPage(WebDriver driver) {
		this._driver = driver;
	}
	
	By kycScreenNav = By.xpath("//*[@id=\"root\"]/div[1]/nav/div[2]/div[2]/a");
	By kycDownload = By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div[2]/button");
	
	public WebElement KYCDownload() {
		return _driver.findElement(kycDownload);
	}
	
	public WebElement KycScreenNav() {
		return _driver.findElement(kycScreenNav);
	}

}
