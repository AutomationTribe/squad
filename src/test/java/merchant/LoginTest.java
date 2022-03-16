package merchant;


import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.base;
import dataDriven.LoginData;
import merchantModulePageObjects.LoginPage;


public class LoginTest extends base {
	
	//public LoginPage _loginPage;
	
	public LoginTest() {
		
		//loginPage = _loginPage;
	}

	@Test(dataProvider="testData")
	public void validLogin(String username,String password) throws InterruptedException, IOException {
				
		 Init();
		 LoginPage _loginPage = new LoginPage(_driver);
		 
		 _loginPage.EmailAddress().sendKeys(username);
		 
		 _loginPage.Password().sendKeys(password);
		 _loginPage.LoginButton().click();
		// String actualUrl = _driver.getCurrentUrl();
		 //String expectedUrl = "https://dashboard.squadinc.co/get-started";
		// Assert.assertEquals(actualUrl,expectedUrl);
		 
		 Thread.sleep(3000);	
		 
		 _driver.close();
	}
	
	
	@Test
	public void NavigateToRegistrationPage() throws IOException, InterruptedException {
		
		Init();
		
		LoginPage _loginPage = new LoginPage(_driver);
		
		_loginPage.EmailAddress().sendKeys("test@test.com");
		_loginPage.Password().sendKeys("Password");
		_loginPage.CreateAccount().click(); 
	
	}
	
	@DataProvider(name="testData")
	public Object[][] loginData(){
		
		LoginData data = new LoginData("C:\\Users\\SBSC\\Documents\\sbsc\\Automation\\HabariPay\\Data\\logintestdata.xlsx");
		
		int rows = data.getRowCount(0);
		
		Object[][] signin_cred = new Object[rows][2];
		
		for(int i = 0; i < rows;i++) {
			
			signin_cred[i][0] = data.getData(0, i, 0);
			signin_cred[i][1] = data.getData(0, i, 1);
		}
		return signin_cred;	
	}
	
	@AfterTest
	public void TearDown() {
		
		_driver.quit();
	}

}
