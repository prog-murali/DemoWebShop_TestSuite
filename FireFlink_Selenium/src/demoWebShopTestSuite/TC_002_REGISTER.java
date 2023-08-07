package demoWebShopTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_002_REGISTER 
{
	static WebDriver driver;
	static String result;
	
	public static void LaunchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	public static void register()
	{
		WebElement register=driver.findElement(By.className("ico-register"));
		register.click();
	}	
	
	public static void Register_Fields()
	{   
			driver.findElement(By.id("gender-male")).click();
			driver.findElement(By.id("FirstName")).sendKeys("Praven");
			driver.findElement(By.id("LastName")).sendKeys("K");
			driver.findElement(By.id("Email")).sendKeys("jack@jonees.com");
			driver.findElement(By.id("Password")).sendKeys("123456789");
			driver.findElement(By.id("ConfirmPassword")).sendKeys("123456789");
			driver.findElement(By.id("register-button")).click();		
	}

	public static void main(String[] args) 
	{
		LaunchBrowser("https://demowebshop.tricentis.com/");
		register();
		Register_Fields();
		
		//Validation
		WebElement element=driver.findElement(By.xpath("//div[@class='result' or  contains(@class,'validation-summary-errors')]"));
		result=element.getText();
		if(element.isEnabled())
		{
			System.out.println("TC_002_REGISTER Passed"+" "+result);
		}
		else
		{
			System.out.println("TC_002_REGISTER Failed"+" "+result);
		}
		driver.quit();
	}

}
