package demoWebShopTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_006_COMMUNITY_POLL 
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
	
	public static String Vote()
	{
		driver.findElement(By.xpath("//ul[@class='poll-options']//label[contains(text(),'Good')]")).click();
		driver.findElement(By.cssSelector("[value='Vote']")).click();
		String result=driver.findElement(By.xpath("//div[@class='poll']/strong")).getText();
		return result;
	}

	public static void main(String[] args) 
	{
		String exp_result="Do you like nopCommerce?";
		String email="jack@jonees.com";
		LaunchBrowser("https://demowebshop.tricentis.com/");
		Login(email,"123456789");
		String act_result=Vote();
		
		//Validation
		if(exp_result.equals(act_result))
		{
			System.out.println("Successfully Voted");
		}
		else
		{
			System.out.println("Voting Unsuccessfull");
		}	
		driver.quit();
	}
}
