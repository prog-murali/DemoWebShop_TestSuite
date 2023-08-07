package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise_on_HiddenElement_JSxecutor {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		// Working on Hidden Element
		driver.findElement(By.linkText("Create new account")).click();
		driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("Ram");
		driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("A");
		driver.findElement(By.cssSelector("[name='reg_email__']")).sendKeys("abc@tyss.in");
		driver.findElement(By.id("password_step_input")).sendKeys("RamKumar");
		
		Select year=new Select(driver.findElement(By.cssSelector("[name='birthday_year']")));
	    year.selectByVisibleText("1999");
		
		WebElement genderHidden=driver.findElement(By.cssSelector("[name='custom_gender']"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].value='Male';", genderHidden);
		Thread.sleep(2000);
		
		// To view Wheteher we have passed
		driver.findElement(By.xpath("//span[@data-name='gender_wrapper']/span[3]/input")).click();
		
		// Passing the Pronoun DropDown
		Select pronoun=new Select(driver.findElement(By.cssSelector("[name='preferred_pronoun']")));
		pronoun.selectByIndex(2);
		

	}

}
