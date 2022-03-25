package adminModulePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver _driver;
	
	public LandingPage(WebDriver driver) {
		this._driver = driver; 
	}
	
	By username = By.cssSelector("input[name='email']");
	By password = By.cssSelector("input[name='password']");
	By loginButton = By.cssSelector("button[type='submit']");
	By errorAlert = By.cssSelector("div[role='alert']");
	
	public WebElement Username() {
		return _driver.findElement(username);
	}
	
	public WebElement Password() {
		return _driver.findElement(password);
	}
	public WebElement LoginButton() {
		return _driver.findElement(loginButton);
	}
	
	public WebElement ErrorAlert() {
		return _driver.findElement(errorAlert);
	}
	
}
