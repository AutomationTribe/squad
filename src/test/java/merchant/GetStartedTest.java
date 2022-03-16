package merchant;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basePackage.base;
import merchantModulePageObjects.GetStartedPage;

public class GetStartedTest extends base {
	
	@Test
	public void CompleteKyc() throws IOException {
			
		MerchantLogin();		
		
		GetStartedPage getStarted = new GetStartedPage(_driver);
		
		WebDriverWait wait = new WebDriverWait(_driver, 30);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='alert-card--button']")));
		
		getStarted.CompleteKYC().click();
		
		_driver.close();
		
	}

}
