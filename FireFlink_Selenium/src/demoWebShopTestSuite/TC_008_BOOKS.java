package demoWebShopTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_008_BOOKS 
{
static WebDriver driver;
	
	public static void LaunchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
	}

	public static void main(String[] args) 
	{
		String exp_result="https://demowebshop.tricentis.com/books";
		
		LaunchBrowser("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.xpath("(//a[contains(text(),'Books')])[1]")).click();
		String act_result=driver.getCurrentUrl();
		
		if(act_result.equals(exp_result))
		{
			System.out.println("Books Page Displayed");
		}
		else
		{
			System.out.println("Couldn't Find the Books Page");
		}
		driver.quit();
	}
}
