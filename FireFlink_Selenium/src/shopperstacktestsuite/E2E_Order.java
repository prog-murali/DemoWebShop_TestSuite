package shopperstacktestsuite;


import java.io.File;
import java.io.IOException;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class E2E_Order extends BaseTest
{
	

		@Test(priority=1)
		public void Login()
		{
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			driver.findElement(By.id("Email")).sendKeys("sekarna1507@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("AmNaaiSekar#1");
			driver.findElement(By.xpath("//span[text()='Login']")).click();
		}
		
		@Test(priority=2)
		public void Add_To_Cart()
		{
			driver.findElement(By.id("electronicsProd")).click();	
			driver.findElement(By.xpath("//span[text()='boat rockerz 450']/../following-sibling::div/button")).click();
			driver.findElement(By.id("cart")).click();
		}
		
		@Test(priority=3)
		public void remove()
		{
			driver.findElement(By.cssSelector(".MuiButton-textSizeSmall")).click();
			driver.findElement(By.xpath("//button[text()='Yes']")).click();
		}
		
		@Test(priority=4)
		public void Continue_Shopping() throws InterruptedException
		{
			Actions act=new Actions(driver);
			driver.findElement(By.cssSelector("[data-testid='ShoppingCartIcon']")).click();
			
			WebElement kids=driver.findElement(By.xpath("//a[@id='kids']"));
			kids=driver.findElement(By.xpath("//a[@id='kids']"));
			act.moveToElement(kids).perform();
			
			WebElement shirts=driver.findElement(By.xpath("(//a[text()='Shirts'])[2]"));
			shirts=driver.findElement(By.xpath("(//a[text()='Shirts'])[2]"));
			act.moveToElement(shirts).click().perform();
			Thread.sleep(2000);
			WebElement cursor=driver.findElement(By.xpath("//a[text()='boys shirt']"));
			cursor=driver.findElement(By.xpath("//a[text()='boys shirt']"));
			act.moveToElement(cursor).perform();
			
			driver.findElement(By.xpath("//button[text()='add to cart']")).click();
			driver.findElement(By.id("cart")).click();		
		}
		
		@Test(priority=5)
		public void Buy_Now()
		{
			driver.findElement(By.xpath("//button[@id='buynow_fl']")).click();
			driver.findElement(By.xpath("//button[contains(@class,'selectaddress')]")).click();
			driver.findElement(By.id("Name")).sendKeys("Naai");
			driver.findElement(By.cssSelector("[name='House/Office Info']")).sendKeys("ABC SquareMall");
			driver.findElement(By.cssSelector("[name='Street Info']")).sendKeys("24 A");
			driver.findElement(By.id("Landmark")).sendKeys("Police Station");
			
			Select country=new Select(driver.findElement(By.id("Country")));
			country.selectByVisibleText("India");
			
			Select state=new Select(driver.findElement(By.id("State")));
			state.selectByVisibleText("Karnataka");
			
			Select city=new Select(driver.findElement(By.id("City")));
			city.selectByValue("Bengaluru");
			
			driver.findElement(By.id("Pincode")).sendKeys("432103");
			driver.findElement(By.cssSelector("[name='Phone Number']")).sendKeys("9685743215");
			driver.findElement(By.id("addAddress")).click();
			
//			Alert alert=driver.switchTo().alert();
//			alert.dismiss();
			
			driver.findElement(By.xpath("(//input[@name='address'])[11]")).click();
			driver.findElement(By.xpath("//button[text()='Proceed']")).click();
			driver.findElement(By.cssSelector("[value='COD']")).click();
			driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		}
		
		@Test(priority=6)
		public void ScreenShot()
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File temp=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File("./ScreenShots/orderplaced.png");
			
			try 
			{
				FileHandler.copy(temp, dest);
			} 
			catch (IOException e) 
			{			
				e.printStackTrace();
			}
		}
		
		

	}



