package assignments;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DWS_FB_assignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		// Open DWS and click on Facebook close only the FaceBook
		
		Actions act=new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Facebook']")).click();
		
		Set<String> windowHandles=driver.getWindowHandles();
		
		for(String handle:windowHandles)
		{
			driver.switchTo().window(handle);
			if(driver.getCurrentUrl().contains("https://www.facebook.com/nopCommerce"))
			{
				driver.close();
			}
		}
	}

}
