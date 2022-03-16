package merchantModulePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
	private WebDriver _driver;
	
	public RegistrationPage(WebDriver driver) {
		this._driver = driver;
	}

	By fullName = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div[2]/form/div[1]/input");
	By businessName = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div[2]/form/div[2]/input");
	By country = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div[2]/form/div[3]/div[1]/select");
	By phoneNumber = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div[2]/form/div[3]/div[3]/div[2]/input");
	By emailAddress = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div[2]/form/div[4]/div[1]/input");
	By password = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div[2]/form/div[4]/div[3]/div/input");
	By rgButton =  By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div[2]/form/button");
	
	
	public WebElement FullName() {	
		return _driver.findElement(fullName);	
	}
	
	public WebElement BusinessName() {
		
		return _driver.findElement(businessName);
	}
	
	
	public Select Country() {
		
		return  new Select(_driver.findElement(country));
	}
	
	public WebElement PhoneNumber() {
		
		return _driver.findElement(phoneNumber);
	}
	
	public WebElement EmailAddress() {
		
		return _driver.findElement(emailAddress);
	}
	
	public WebElement Password() {
		
		return _driver.findElement(password);
	}
	
	public WebElement RgButton() {
		
		return _driver.findElement(rgButton);
	}
}
