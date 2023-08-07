package assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// get() will waits for the Browser to Load the page whereas the navigate().to() doesnt but sometime it waits because the get() calls internaly
public class Assignment_1 
{
	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
//	UPCASTING TO GET THE RTP USING THe <<WEBDRIVER>>	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();// Maximize 
		
		// NOTE: to(String URL)/to(URL url) will call the get() internally while executing it waits for page for loading 
		driver.navigate().to("https://www.google.co.in");//to(String URL)
		driver.navigate().to("https://www.selenium.dev/");//to(String URL)
//	BROWSER CONTROL METHODS -->,<-- & refresh	
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
//	Closing the window	
		driver.close();
	}

}
