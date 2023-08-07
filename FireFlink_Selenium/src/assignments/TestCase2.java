package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// Login Validation
public class TestCase2 
{
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		String email="xyz65@gmail.co.in";
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys("xyz65@gmail.co.in");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.cssSelector(".button-1.login-button")).click();
		String log=driver.findElement(By.className("account")).getText();
		
		if(log.equals(email))
		{
			System.out.println("Entered as a Valid user");
		}
		else
		{
			System.out.println("Log in Failed");
		}
		
	}
}
