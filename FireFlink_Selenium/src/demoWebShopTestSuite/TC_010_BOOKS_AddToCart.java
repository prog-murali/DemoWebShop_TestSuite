package demoWebShopTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_010_BOOKS_AddToCart 
{
	static WebDriver driver;
		
	public static void LaunchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
			
	    driver.get(url);
	}
	
	public static String AddtoCart() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()='Computing and Internet']")).click();
		
		WebElement qty=driver.findElement(By.className("qty-input"));
		qty.clear();
		qty.sendKeys("2");
		
		driver.findElement(By.id("add-to-cart-button-13")).click();
		
		Thread.sleep(2000);
		
		String result=driver.findElement(By.xpath("//a[@class='ico-cart']//span[@class='cart-qty']")).getText();
		return result;
	}

	public static void main(String[] args) throws InterruptedException 
	{
        String exp_result="(2)";
		
		LaunchBrowser("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.xpath("(//a[contains(text(),'Books')])[1]")).click();
		
		String act_result=AddtoCart();
		
		//Validation
		if(act_result.equalsIgnoreCase(exp_result))
		{
			 System.out.println("Book Added to Cart Successfully");
		}
		else
		{
			System.out.println("Couldn't add to Cart");
		}
		driver.quit();		
	}
}
