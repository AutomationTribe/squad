package merchantModulePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KYCPage {
	
	public WebDriver _driver;
	
	public KYCPage(WebDriver driver) {
		this._driver = driver;
	}
	
	//By verifyEmailButton =  By.cssSelector("button[data-index='0']");
	By verifyEmailButton = By.xpath("/html/body/div/div[1]/main/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/button");
	//By verifyEmailButton = By.id("accordion-button-271");
	By sendEmail = By.xpath("/html/body/div/div[1]/main/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div/span[1]");
	
	By yopmail = By.cssSelector("input[class='ycptinput']");
	By yopmailButton = By.cssSelector("button[class='md']");
	By yopmailContent = By.xpath("/html/body/main/div/div/div");
	
	
	public WebElement VerifyEmailButton() {
		
		return _driver.findElement(verifyEmailButton);
	}
	
	public WebElement SendEmail() {
		
		return _driver.findElement(sendEmail);
	}
	
	public WebElement YopMail() {
		return _driver.findElement(yopmail);
	}
	
	public WebElement YopmailButton() {
		return _driver.findElement(yopmailButton);
	}
	
	public WebElement YopmailContent() {
		return _driver.findElement(yopmailContent);
	}
}
