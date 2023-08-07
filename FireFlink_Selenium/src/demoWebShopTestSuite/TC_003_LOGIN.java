package demoWebShopTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_003_LOGIN 
{
    static WebDriver driver;
	
	public static void LaunchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	public static String Login()
	{
		driver.findElement(By.className("ico-login")).click();
		String url=driver.getCurrentUrl();
		return url;
	}

	public static void main(String[] args) 
	{
		String exp_url="https://demowebshop.tricentis.com/login";
		
		LaunchBrowser("https://demowebshop.tricentis.com/");
		String act_url=Login();
		
		//Validation
		
		if(act_url.equalsIgnoreCase(exp_url))
		{
			System.out.println("LogIn Page Displayed Successfully");
		}
		else
		{
			System.out.println("LogIn Page Doesnt Displayed"); 
		}
		driver.quit();
	}
}
