package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra_Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
		
		// Hover Mouse to Mens and selec Tshirts
		
		WebElement Men=driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		
		Actions act=new Actions(driver);
		act.moveToElement(Men).perform();
		
		WebElement t_Shirt=driver.findElement(By.xpath("(//a[text()='T-Shirts'])[1]"));
		
		act.moveToElement(t_Shirt).click().perform();
	}
}
