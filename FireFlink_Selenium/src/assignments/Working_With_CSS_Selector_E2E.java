package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_With_CSS_Selector_E2E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		
		
//		                                  E2E Scenario using CSS Selector
		
		//TO Identify WebElemenets using the CSS_Selector  [ # --> id ; . --> class ]
		
		//Register Button
		driver.findElement(By.cssSelector(".ico-register")).click();
		
		//Male Radio Button
		driver.findElement(By.cssSelector("#gender-male")).click();
		
		//Fname
		driver.findElement(By.cssSelector("[name='FirstName']")).sendKeys("Kumar");
		
		//Lname
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Prabhu");
		
		//Email
		driver.findElement(By.cssSelector("#Email")).sendKeys("xyz@tyss.in");
		
		//Pass
		driver.findElement(By.cssSelector("input[name='Password']")).sendKeys("123456");
		
		//C-Pass
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123456");
		
		//Reg Button
		driver.findElement(By.cssSelector(".button-1.register-next-step-button")).click();
		      //We can Chain two classes using the dot opertator instead of space in the class in the css expression
		

	}

}
