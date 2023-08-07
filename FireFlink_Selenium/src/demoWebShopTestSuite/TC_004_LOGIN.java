package demoWebShopTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_004_LOGIN 
{
	static WebDriver driver;
	
	public static void LaunchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	public static void Login(String email,String pass)
	{
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.cssSelector("[name='Email']")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pass);
		driver.findElement(By.className("login-button")).click();
	}

	public static void main(String[] args) 
	{
		String email="jack@jonees.com";
		LaunchBrowser("https://demowebshop.tricentis.com/");
		Login(email,"123456789");
		
		// VALIDATION
		String result=driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']")).getText();
		
		if(email.equalsIgnoreCase(result))
		{
			System.out.println("TC_004_LOGIN Passed "+"Logged in as: "+result);
		}
		else
		{
			System.out.println("TC_004_LOGIN Failed");
		}
		driver.quit();
	}
}
