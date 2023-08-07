package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment_Gecko_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		//TO identify the register Link
		driver.findElement(By.linkText("Register")).click();
		
		//To identify the FIRSTNAME TextField
		driver.findElement(By.id("FirstName")).sendKeys("Murali");
		
		//To identify the LASTNAME TextField
		driver.findElement(By.id("LastName")).sendKeys("Krishnaa");
		
		//To identify the EMAIL TextField
		driver.findElement(By.id("Email")).sendKeys("abc@tyss.in");

	}

}
