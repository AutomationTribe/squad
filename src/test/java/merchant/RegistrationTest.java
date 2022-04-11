package merchant;

import java.io.IOException;
import java.util.Locale;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import basePackage.base;
import merchantModulePageObjects.RegistrationPage;
//import merchantModulePageObjects.RegistrationPage;


public class RegistrationTest extends base {
	
	@DataProvider(name ="registerData")
	public Object[][] RegisterData(){
		
		FakeValuesService fakeService = new FakeValuesService(new Locale("en-NG"),new RandomService());
		Faker fake = new Faker(new Locale("en-NG"));
		
		String fullName = fake.name().fullName().toString();
		String businessName = fake.company().name().toString();
		String phoneNumber  = fake.phoneNumber().phoneNumber();	
		String email = fakeService.bothify("????#@yopmail.com");
		String password = fakeService.regexify("[a-z1-9]{7}");
		
		Object[][] data = new Object[1][5];
		
		data[0][0] = fullName;
		data[0][1] = businessName;
		data[0][2] = phoneNumber;
		data[0][3] = email;
		data[0][4] = password;
		
		return data;	
	}
	
	@Test(dataProvider="registerData")
	public void ValidMerchantRegistration(String fullName,String businessName,String phoneNumber,String email,String password) throws InterruptedException, IOException {
		
		Init("baseUrl");
		
		RegistrationPage register = new RegistrationPage(_driver);
		
		_driver.navigate().to(LoadProp().getProperty("regUrl"));
		
		register.FullName().sendKeys(fullName);
		
		register.BusinessName().sendKeys(businessName);
		
		register.Country().selectByValue("NGA");
		
		register.PhoneNumber().sendKeys(phoneNumber);
		
		register.EmailAddress().sendKeys(email);
		
		register.Password().sendKeys(password);
		
		register.RgButton().click();
		
		Thread.sleep(9000);
		
		_driver.close();
		
	}
			
}
