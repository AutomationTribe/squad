package admin;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import adminModulePageObjects.KYCScreenPage;
import basePackage.base;

public class KYCScreenTest extends base {
	
	//private KYCScreenPage _kycscreen = new KYCScreenPage(_driver);
	@BeforeTest
	public void SetUp() throws IOException {
		AdminLogin();  
		 KYCScreenPage kycScreen = new KYCScreenPage(_driver);
		 kycScreen.KycScreenNav().click();
	}
	
	@Test
	public void ApproveKYC() {
		
		KYCScreenPage kycScreen = new KYCScreenPage(_driver);
		if(kycScreen.KYCTable().isDisplayed())
		{
			//select table row with status value pending
		}
		
	} 
	
	@Test
	public void FilterByAll() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(_driver,30);
		 KYCScreenPage kycScreen = new KYCScreenPage(_driver);
		 kycScreen.FilterByButton().click();   
		 Select s = new Select(kycScreen.FilterByStatus());
		 s.selectByIndex(1);
		// wait.until(ExpectedConditions.elementToBeClickable(kycScreen.FilterByBusinessType()));
		 Select s1 = new Select(kycScreen.FilterByBusinessType());
		 s1.selectByIndex(0);
		 kycScreen.FilterByButton().click();
		 
		 Thread.sleep(5000);
		 wait.until(ExpectedConditions.visibilityOf(kycScreen.KYCTable()));
		 assertTrue(kycScreen.KYCTable().isDisplayed());
	}
	
	@Test
	public void NavigateToKyc() {
		
		
	}
	
	@Test
	public void KycDownload() {
		
	 KYCScreenPage kycScreen = new KYCScreenPage(_driver);
	 kycScreen.KycScreenNav().click();
	 kycScreen.KYCDownload().click();
	 
	 
	}
   
	@AfterTest
	public void TearDown() {
		_driver.close();
	}

}
