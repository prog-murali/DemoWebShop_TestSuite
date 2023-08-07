package demoWebShopTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_011_SEARCH 
{
	static WebDriver driver;
	static String product;
	
	public static void LaunchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
			
	    driver.get(url);
	}
	
	public static String Search()
	{
		product="Computer";
		driver.findElement(By.id("small-searchterms")).sendKeys(product);
		driver.findElement(By.className("search-box-button")).click();
		String result=driver.getCurrentUrl();
		return result;
	}

	public static void main(String[] args) 
	{		
		LaunchBrowser("https://demowebshop.tricentis.com/");
		
		String act_result=Search();
		String exp_result="https://demowebshop.tricentis.com/search?q="+product;
		
		// Validation
		if (act_result.equalsIgnoreCase(exp_result))
		{
			System.out.println("Searched product Successfully");			
		}
		else
		{
			System.out.println("Unable to search Product");
		}
		driver.quit();
	}

}
