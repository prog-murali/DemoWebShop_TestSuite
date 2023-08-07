package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excersice_on_DisaledElement_JSXecutor {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoapp.skillrary.com/index.php");
		
		// Accessing Disabled Button using JSEXECUTOR
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		WebElement disabledSubscribeTxt=driver.findElement(By.xpath("//input[@class='form-control']"));
		WebElement disabledSubscribeBtn=driver.findElement(By.className("btn-flat"));
		
		// Passing Value into disabled Element using JSEXECUTOR
		
		js.executeScript("arguments[0].value='abc@tyss.in';", disabledSubscribeTxt);
		
		// Clicking on the disabled Button using JSEXECUTOR
		
		js.executeScript("arguments[0].click();", disabledSubscribeBtn);
		
		

	}

}
