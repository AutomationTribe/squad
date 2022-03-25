package basePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import adminModulePageObjects.LandingPage;
import merchantModulePageObjects.LoginPage;

public class base {
	
	public WebDriver _driver;
	
	public void Init(String url) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SBSC\\Documents\\sbsc\\Automation\\Programs\\chromedriver.exe");
		
		_driver = new ChromeDriver();
		
		_driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		
		_driver.manage().window().maximize();
		
		if(url == "adminUrl") {
			url = LoadProp().getProperty("adminUrl");
			
		}else if(url == "baseUrl")
		{
			url = LoadProp().getProperty("baseUrl");
		}
				
		_driver.get(url);
	}
	
	public void MerchantLogin() throws IOException {
		
		Init("baseUrl");
		
		LoginPage login = new LoginPage(_driver);
		
		login.EmailAddress().sendKeys("demo@merchant.com");
		
		login.Password().sendKeys("Password1");
		
		login.LoginButton().click();
		
	}
	
	public void AdminLogin() throws IOException {
		Init("adminUrl");
		
		LandingPage landing = new LandingPage(_driver);
		
		landing.Username().sendKeys(LoadProp().getProperty("adminUsername"));
		landing.Password().sendKeys(LoadProp().getProperty("adminPassword"));
		landing.LoginButton().click();
		
	}
	public Properties LoadProp() throws IOException {
		
		Properties prop =  new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\SBSC\\eclipse-workspace\\Squad\\data.properties");
		
		prop.load(fis);
		
		return prop;
	}

}
