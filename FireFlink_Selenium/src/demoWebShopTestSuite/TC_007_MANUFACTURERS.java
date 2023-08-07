package demoWebShopTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_007_MANUFACTURERS 
{
static WebDriver driver;
	
	public static void LaunchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	public static String Manufacturer()
	{
		driver.findElement(By.xpath("//a[text()='Tricentis']")).click();
		String result=driver.findElement(By.className("page-title")).getText();
		return result;
	}

	public static void main(String[] args) 
	{
		String exp_result="Tricentis";
		
		LaunchBrowser("https://demowebshop.tricentis.com/");
		String act_result=Manufacturer();
		
		// Validation
		if(act_result.equals(exp_result))
		{
			System.out.println("TC_007_MANUFACTURERS Passed");
		}
		else
		{
			System.out.println("TC_007_MANUFACTURERS Failed");
		}
		driver.quit();		
	}

}
