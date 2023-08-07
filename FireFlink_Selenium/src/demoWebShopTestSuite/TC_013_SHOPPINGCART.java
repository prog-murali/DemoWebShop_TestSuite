package demoWebShopTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_013_SHOPPINGCART 
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
	
	public static void AddtoCart()
	{
		driver.findElement(By.xpath("(//a[text()='Computing and Internet'])[2]")).click();
		
		WebElement qty=driver.findElement(By.className("qty-input"));
		qty.clear();
		qty.sendKeys("2");
		
		driver.findElement(By.id("add-to-cart-button-13")).click();
	}
	
	public static String Shopping_Cart()
	{
		driver.findElement(By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']")).click();
		String result=driver.findElement(By.xpath("//tr[@class='cart-item-row']//td[@class='product']")).getText();
		return result;
	}

	public static void main(String[] args) 
	{
        String email="jack@jonees.com";
		
        String exp_result="Computing and Internet";
		LaunchBrowser("https://demowebshop.tricentis.com/");
		Login(email,"123456789");
		driver.findElement(By.xpath("(//a[contains(text(),'Books')])[1]")).click();
		AddtoCart();
		String act_result=Shopping_Cart();
		
		//Validation
		if(act_result.equals(exp_result))
		{
			System.out.println("Producted added to Shopping Cart");
		}
		else
		{
			System.out.println("Failed to add product");
		}
		driver.quit();
	}

}
