package merchant;

import java.io.IOException;
import org.testng.annotations.Test;

import basePackage.base;
import merchantModulePageObjects.RegistrationPage;
//import merchantModulePageObjects.RegistrationPage;


public class RegistrationTest extends base {
	
	@Test
	public void ValidMerchantRegistration() throws InterruptedException, IOException {
		
		Init();
		
		RegistrationPage register = new RegistrationPage(_driver);
		
		_driver.navigate().to(LoadProp().getProperty("regUrl"));
		
		register.FullName().sendKeys("Test Squad");
		
		register.BusinessName().sendKeys("Aboki Biz");
		
		register.Country().selectByValue("NGA");
		
		register.PhoneNumber().sendKeys("08067532314");
		
		register.EmailAddress().sendKeys("testsquad@yopmail.com");
		
		register.Password().sendKeys("Password@2022_");
		
		register.RgButton().click();
		
		Thread.sleep(9000);
		
		_driver.close();
		
	}
			
}
