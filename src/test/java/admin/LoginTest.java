package admin;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import adminModulePageObjects.LandingPage;
import basePackage.base;

public class LoginTest extends base {
	
	@BeforeTest
	public void Setup() throws IOException {
		Init("adminUrl");	
	}
	
	@AfterTest
	public void TearDown() {
		_driver.close();
	}
	
	@Test
	public void ValidLogin() throws IOException {
		
		LandingPage landing = new LandingPage(_driver);
		WebDriverWait wait =  new WebDriverWait(_driver,20);
		landing.Username().sendKeys(LoadProp().getProperty("adminUser"));
		landing.Password().sendKeys(LoadProp().getProperty("adminPassword"));
		landing.LoginButton().click();
		wait.until(ExpectedConditions.urlToBe("https://admin.squadinc.co/overview"));
		String actual = _driver.getCurrentUrl();
		String expected = "https://admin.squadinc.co/overview";
		assertEquals(actual,expected);
	}

	@Test(dataProvider="loginData")
	public void InvalidLogin(String username , String password) throws IOException{
		
		LandingPage landing = new LandingPage(_driver);
		WebDriverWait wait =  new WebDriverWait(_driver,5);
		landing.Username().sendKeys(username);
		landing.Password().sendKeys(password);
		landing.LoginButton().click();
		wait.until(ExpectedConditions.visibilityOf(landing.ErrorAlert()));
		String expected = "Incorrect email or password";
		String actual = landing.ErrorAlert().getText();
		assertEquals(actual,expected);
	}
	
	
	@DataProvider(name="loginData")
	public Object[][] LoginData(){
		
		Object[][] data = new Object[1][2];
		data[0][0] = "rasksaka@asdlks.com";
		data[0][1] = "Password1";
		
		return data ;	
	}
	
	
}
