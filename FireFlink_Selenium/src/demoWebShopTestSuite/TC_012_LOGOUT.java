package demoWebShopTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_012_LOGOUT 
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
	
	public static boolean Logout()
	{
		driver.findElement(By.className("ico-logout")).click();
		boolean result=driver.findElement(By.className("ico-login")).isDisplayed();
		return result;
	}

	public static void main(String[] args) 
	{
		String email="jack@jonees.com";
		
		LaunchBrowser("https://demowebshop.tricentis.com/");
		
		Login(email,"123456789");
		
		boolean result=Logout();
		
		//Validation
		if(result)
		{
			System.out.println("Logged Out Successful");
		}
		else
		{
			System.out.println("Unable to Log Out");
		}
		driver.quit();
	}
}
