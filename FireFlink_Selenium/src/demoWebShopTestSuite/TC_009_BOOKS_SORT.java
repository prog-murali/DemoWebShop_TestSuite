package demoWebShopTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_009_BOOKS_SORT 
{
    static WebDriver driver;
	
	public static void LaunchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	public static String sort()
	{
		Select s=new Select(driver.findElement(By.cssSelector("[name='products-orderby']")));
		s.selectByVisibleText("Name: Z to A");
		
		Select s1=new Select(driver.findElement(By.id("products-pagesize")));
		s1.selectByIndex(2);
		
		Select s2=new Select(driver.findElement(By.id("products-viewmode")));
		s2.selectByIndex(1);
		
		String result=driver.getCurrentUrl();
		return result;
	}

	public static void main(String[] args) 
	{

		String exp_result="https://demowebshop.tricentis.com/books?orderby=6&pagesize=12&viewmode=list";
		
		LaunchBrowser("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.xpath("(//a[contains(text(),'Books')])[1]")).click();
		
		String act_result=sort();
		
		// Validation
		if(act_result.equalsIgnoreCase(exp_result))
		{
			System.out.println("Successfully sorted Books Page");
		}
		else
		{
			System.out.println("Unable to sort Books Page");
		}
		driver.quit();
	}
}
