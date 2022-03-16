package basePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import merchantModulePageObjects.LoginPage;

public class base {
	
	public WebDriver _driver;
	
	public void Init() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SBSC\\Documents\\sbsc\\Automation\\Programs\\chromedriver.exe");
		
		_driver = new ChromeDriver();
		
		_driver.manage().window().maximize();
		
		String url = LoadProp().getProperty("baseUrl");
				
		_driver.get(url);
	}
	
	public void MerchantLogin() throws IOException {
		
		Init();
		
		LoginPage login = new LoginPage(_driver);
		
		login.EmailAddress().sendKeys("demo@merchant.com");
		
		login.Password().sendKeys("Password1");
		
		login.LoginButton().click();
		
	}
	public Properties LoadProp() throws IOException {
		
		Properties prop =  new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\SBSC\\eclipse-workspace\\Squad\\data.properties");
		
		prop.load(fis);
		
		return prop;
	}

}
