package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Working_With_Select_Class_getOptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		// Scenario : Log to demo Website-->click books-->Get all the options from the Sorty by DropDown
		
		// Book
		driver.findElement(By.partialLinkText("Books")).click();
		
		//Sort-by drop down
		WebElement sort=driver.findElement(By.id("products-orderby"));
		
		Select s=new Select(sort);
		List<WebElement>options=s.getOptions();
		
		for(WebElement option:options)
		{
			System.out.println(option.getText());			
		}
		driver.quit();
	}

}
