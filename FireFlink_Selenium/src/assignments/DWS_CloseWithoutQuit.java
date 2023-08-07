package assignments;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DWS_CloseWithoutQuit {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demowebshop.tricentis.com/");
		
		Actions act=new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Facebook']")).click();
//		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Twitter']")).click();
//		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='YouTube']")).click();
//		Thread.sleep(2000);
		
		Set<String>handles=driver.getWindowHandles();
		
		for(String handle:handles)
		{
			driver.switchTo().window(handle);
			
			if(driver.getTitle().contains("Facebook"))
			{
				driver.close();
			}
			else if(driver.getTitle().contains("YouTube"))
			{
				driver.close();
			}
			else if(driver.getTitle().contains("nopCommerce"))
			{
				driver.close();
			}
			else if(driver.getTitle().contains("Demo"))
			{
				driver.close();
			}
		}

	}

}
