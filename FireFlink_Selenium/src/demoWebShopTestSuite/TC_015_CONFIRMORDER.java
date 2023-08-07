package demoWebShopTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_015_CONFIRMORDER 
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
		
		public static void Shopping_Cart()
		{
			driver.findElement(By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']")).click();
		}
		
		public static void checkout()
		{
			driver.findElement(By.id("termsofservice")).click();
			driver.findElement(By.id("checkout")).click();
		}
		
		public static void Billing_address()
		{			
			Select s1=new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
			s1.selectByVisibleText("Algeria");
			
			driver.findElement(By.xpath("//div[@class='edit-address']//label[text()='City:']/following-sibling::input")).sendKeys("SouthEnd");
			driver.findElement(By.xpath("//div[@class='edit-address']//label[text()='Address 1:']/following-sibling::input")).sendKeys("25,KLM,Algeria");
			driver.findElement(By.xpath("//div[@class='edit-address']//label[text()='Zip / postal code:']/following-sibling::input")).sendKeys("8520");
			driver.findElement(By.xpath("//div[@class='edit-address']//label[text()='Phone number:']/following-sibling::input")).sendKeys("987654321");
			driver.findElement(By.xpath("//div[@id='billing-buttons-container']/input")).click();			
		}
		
		public static void Shipping_address()
		{
			driver.findElement(By.xpath("//div[@id='shipping-buttons-container']/input")).click();
			
			// Shipping Method
			driver.findElement(By.xpath("//ul[@class='method-list']//input[@id='shippingoption_1']")).click();
			driver.findElement(By.className("shipping-method-next-step-button")).click();
            
			// Payment Method
			driver.findElement(By.cssSelector("[value='Payments.CashOnDelivery']")).click();
			driver.findElement(By.className("payment-method-next-step-button")).click();
		}
		
		public static String Payment_Info()
		{
			WebElement pay_info=driver.findElement(By.xpath("//div[@id='checkout-step-payment-info']//td"));
			String exp_result="You will pay by COD";
			String result=pay_info.getText();
			if(exp_result.equals(result))
			{
				driver.findElement(By.className("payment-info-next-step-button")).click();
			}
			else
			{
				System.out.println("Payment-info Mismatch");
			}
			// Confirm Order
			driver.findElement(By.className("confirm-order-next-step-button")).click();
			String order_info=driver.findElement(By.xpath("//div[@class='title']/strong")).getText();
			return order_info;
		}
		

		public static void main(String[] args)
		{
			String exp_result="Your order has been successfully processed!";
			
	        String email="jack@jonees.com";
			LaunchBrowser("https://demowebshop.tricentis.com/");
			Login(email,"123456789");
			driver.findElement(By.xpath("(//a[contains(text(),'Books')])[1]")).click();
			AddtoCart();
			Shopping_Cart();
			checkout();
			Billing_address();
			Shipping_address();
			String act_result=Payment_Info();
			String order_id=driver.findElement(By.xpath("//div[@class='title']/../ul/li[1]")).getText();
			
			// Validation
			if(exp_result.equalsIgnoreCase(act_result))
			{
				System.out.println(act_result);
				System.out.println("Order Id: "+order_id);
			}
			else
			{
				System.out.println("Unable to Place The order");
			}
			driver.quit();
		}
}
