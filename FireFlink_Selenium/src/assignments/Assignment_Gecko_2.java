package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment_Gecko_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Browser Launching Steps
		System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
				
		// To navigate to the URL
		driver.get("https://demowebshop.tricentis.com/");
			
		//TO identify the SEARCH TextField --->> findElement() return type is WebElement
		driver.findElement(By.id("small-searchterms")).sendKeys("Books");  
				
		driver.close();	
	}

}
