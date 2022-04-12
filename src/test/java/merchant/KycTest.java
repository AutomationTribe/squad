package merchant;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import basePackage.base;
import merchantModulePageObjects.GetStartedPage;
import merchantModulePageObjects.KYCPage;
import merchantModulePageObjects.LoginPage;

public class KycTest extends base{
		
	@AfterTest
	public void TearDown() {
		_driver.close();
	}
	
	@Test(dependsOnGroups="register")
	public void VerifyEmail(ITestContext ctx) throws IOException, InterruptedException {
		
		String username = (String) ctx.getAttribute("username");
		String password = (String) ctx.getAttribute("password");
		
		Init("merchantUrl");
		WebDriverWait wait = new WebDriverWait(_driver,20);
		
		LoginPage loginPage = new LoginPage(_driver);
		loginPage.EmailAddress().sendKeys(username);
		loginPage.Password().sendKeys(password); 
		loginPage.LoginButton().click();
		
		KYCPage kycPage = new KYCPage(_driver);
		GetStartedPage getStartedPage = new GetStartedPage(_driver);
		
		getStartedPage.CompleteKYC().click();
		
	    wait.until(ExpectedConditions.elementToBeClickable(kycPage.VerifyEmailButton()));
		kycPage.VerifyEmailButton().click();
		kycPage.SendEmail().click();
		
		_driver.navigate().to("https://yopmail.com/en/");
		
		kycPage.YopMail().sendKeys(username);
		kycPage.YopmailButton().click();
		
		_driver.switchTo().frame("ifmail");
		wait.until(ExpectedConditions.visibilityOf(kycPage.YopmailContent()));
		String mailContent = kycPage.YopmailContent().getText();
		System.out.print(mailContent);
		
		String verifyUrl = ExtractEmail(mailContent);
		
		//System.out.print(verifyUrl);
		
		_driver.navigate().to(verifyUrl);
		
	    //assert here
		
		Thread.sleep(150000);
	}
	
	@Test(dependsOnMethods="VerifyEmail")
	public void Business(ITestContext ctx) {
		
	}
	public String ExtractEmail(String mailContent) {
		
		String emailRegexPattern = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		String email ="";
		String[] mailContentToArray = mailContent.split(" ");
		
		for(int i = 0; i < mailContentToArray.length ; i++) {
			if(Pattern.compile(emailRegexPattern).matcher(mailContentToArray[i]).matches()) {
				email += mailContentToArray[i];
			}
		}
		return email;
	}

}
