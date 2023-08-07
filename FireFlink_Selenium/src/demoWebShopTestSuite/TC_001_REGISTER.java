package demoWebShopTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_001_REGISTER 
{	
	static WebDriver driver;
		
	public static void LaunchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	public static String register()
	{
		WebElement register=driver.findElement(By.className("ico-register"));
		register.click();		
		String ActualText=driver.findElement(By.className("page-title")).getText();
		return ActualText;
	}

	public static void main(String[] args) 
	{				
		LaunchBrowser("https://demowebshop.tricentis.com/");
		
		String act_Text=register();
		String exp_Text="Register";
		
		// Validation
		if(act_Text.equals(exp_Text))
		{
			System.out.println("TC_001_REGISTER Passed");
		}
		else
		{
			System.out.println("TC_001_REGISTER Failed");
		}
		driver.quit();
	}
}
