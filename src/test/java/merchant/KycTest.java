package merchant;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basePackage.base;
import merchantModulePageObjects.GetStartedPage;
import merchantModulePageObjects.KYCPage;
import merchantModulePageObjects.LoginPage;

public class KycTest extends base{
	
	@Test
	public void IndividualKyc() throws IOException, InterruptedException {
		
		Init();
		
		LoginPage login = new LoginPage(_driver);
		
		login.EmailAddress().sendKeys("testsquad@yopmail.com");
		
		login.Password().sendKeys("Password@2022_");
		
		login.LoginButton().click();
		
		GetStartedPage getStarted = new GetStartedPage(_driver);
		
		WebDriverWait wait = new WebDriverWait(_driver,30);
		
		wait.until(ExpectedConditions.elementToBeClickable(getStarted.completeKYC));
		
		getStarted.CompleteKYC().click();
		
		_driver.findElement(By.id("accordion-button-271")).click();
		
		Thread.sleep(3000);
		
	}

}
