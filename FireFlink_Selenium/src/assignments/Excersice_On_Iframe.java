package assignments;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Excersice_On_Iframe {

	public static void main(String[] args) {
		
		LocalDateTime date=LocalDateTime.now();
		String ss_date=date.toString().replaceAll(":", "-");
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://snowcityblr.com/");
		 Actions act=new Actions(driver);
		
		// ContactUs
		driver.findElement(By.xpath("(//a[text()='Contact Us'])[1]")).click();
		
		// G-Maps iframe Switch
        WebElement g_map=driver.findElement(By.xpath("//iframe[@referrerpolicy='no-referrer-when-downgrade']"));
        driver.switchTo().frame(g_map);
        
        // Directions On IFRAME
        driver.findElement(By.xpath("//div[text()='Directions']")).click();
        
        // TO Change the Window to G-Maps
        Set<String> handles = driver.getWindowHandles();
        
        for(String handle:handles)
        {
        	driver.switchTo().window(handle);
        	if(driver.getCurrentUrl().contains("https://www.google.com/"))
        	{
        		break;
        	}        			
        }
        
        // From Loc on IFRAME
        driver.findElement(By.xpath("//input[contains(@tooltip,'starting point')]")).sendKeys("Mumbai,Maharashtra");
       
        // Enter on the IFRAME
        act.sendKeys(Keys.RETURN).perform();
        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Taking ScreenShot
        
        TakesScreenshot ts=(TakesScreenshot) driver;
        File temp=ts.getScreenshotAs(OutputType.FILE);
        File dest=new File("./ScreenShots/"+ss_date+".png");
        
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
