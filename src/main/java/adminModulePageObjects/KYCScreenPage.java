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
	By filterByButton =  By.xpath("//*[@id=\"popover-trigger-7\"]");
	By filterByStatus = By.xpath("//select[@name='status']");
	By filterByBusinessType = By.xpath("//select[@name='businessType']");
	By filterButton = By.cssSelector("button[type='submit']");
	//By kycTable = By.xpath("//table[@id='dataTable']");
	By kycTable = By.xpath("//*[@id='dataTable']");
	
	By pendingKYC = By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[7]");
	
	By searchByMerchantEmail =  By.cssSelector("input[id='email']");
	
	
	public WebElement KYCDownload() {
		return _driver.findElement(kycDownload);
	}
	
	public WebElement KycScreenNav() {
		return _driver.findElement(kycScreenNav);
	}
	
	public WebElement FilterByButton() {
		return _driver.findElement(filterByButton);
	}
	
	public WebElement FilterByStatus() {
		return _driver.findElement(filterByStatus);
	}
	
	public WebElement FilterByBusinessType() {
		return _driver.findElement(filterByBusinessType);
	}
	
	public WebElement KYCTable() {
		return _driver.findElement(kycTable);
	}
	
	public WebElement SearchByMerchantEmail() {
		
		return _driver.findElement(searchByMerchantEmail);
	}
	
	public WebElement PendingKYC() {
		
		return _driver.findElement(pendingKYC);
	}

}
