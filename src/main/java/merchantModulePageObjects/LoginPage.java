package merchantModulePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver _driver;
	
	public LoginPage(WebDriver driver) {
		this._driver = driver;
	}
	
	By emailAddress = By.cssSelector("input[name='email']");
	By password = By.cssSelector("input[name='password']");
	By loginButton = By.cssSelector("button[type='submit']");
	By createAccount = By.linkText("Create account");
	
	public WebElement EmailAddress() {
		return _driver.findElement(emailAddress);
	}
	
	public WebElement Password() {
		return _driver.findElement(password);
	}
	
	public WebElement LoginButton() {
		return _driver.findElement(loginButton);
	}
	
	public WebElement CreateAccount() {
		
		return _driver.findElement(createAccount);
	}
}
