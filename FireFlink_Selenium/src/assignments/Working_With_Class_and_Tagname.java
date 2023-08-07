package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_With_Class_and_Tagname {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		
		//TO identify WebElements using CLass and TagName Locators
		
		//Search Bar
		driver.findElement(By.className("search-box-text")).sendKeys("Books");
		
		//Search Button
		driver.findElement(By.className("search-box-button")).click();

	}

}
