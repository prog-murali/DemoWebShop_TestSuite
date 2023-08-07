package demoWebShopTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_005_NEWSLETTER 
{
    static WebDriver driver;
	
	public static void LaunchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	public static String NewsLetter(String email)
	{
		driver.findElement(By.id("newsletter-email")).sendKeys(email);
		driver.findElement(By.cssSelector("[value='Subscribe']")).click();
		String act_result=driver.findElement(By.xpath("//div[@class='newsletter-result-block']")).getText();
		return act_result;		
	}

	public static void main(String[] args) 
	{
		String exp_result="Thank you for signing up! A verification email has been sent. We appreciate your interest.";		
		String email="jack@jonees.com";
		
		LaunchBrowser("https://demowebshop.tricentis.com/");
		String act_result=NewsLetter(email);
		
		//Validation
		if(act_result.equals(exp_result))
		{
			System.out.println("Successfully Signed Up for Newseletter");
		}
		else
		{
			System.out.println("Couldn't Sign Up for NewsLetter");
		}
	}
}
