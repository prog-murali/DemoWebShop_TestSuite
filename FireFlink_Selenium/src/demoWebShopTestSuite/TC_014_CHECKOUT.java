package demoWebShopTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_014_CHECKOUT 
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
	
	public static void AddtoCart() throws InterruptedException
	{
		
		driver.findElement(By.xpath("(//a[text()='Computing and Internet'])[2]")).click();
		WebElement qty=driver.findElement(By.className("qty-input"));
		qty.clear();
		qty.sendKeys("2");
		
		driver.findElement(By.id("add-to-cart-button-13")).click();
	}
	
	public static void Shopping_Cart()
	{
		driver.findElement(By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']")).click();
	}
	
	public static String checkout()
	{
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();
		String result=driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
		return result;
	}

	public static void main(String[] args) throws InterruptedException 
	{
		String exp_result="Checkout";
		
        String email="jack@jonees.com";
		LaunchBrowser("https://demowebshop.tricentis.com/");
		Login(email,"123456789");
		driver.findElement(By.xpath("(//a[contains(text(),'Books')])[1]")).click();
		Thread.sleep(2000);
		AddtoCart();
		Shopping_Cart();
		String act_result=checkout();
		
		// Validation
		if(act_result.equals(exp_result))
		{
			System.out.println("CheckOut Page Loaded Successful");
		}
		else
		{
			System.out.println("Unable to Load CheckOut Page");
		}
		driver.quit();		
	}
}
