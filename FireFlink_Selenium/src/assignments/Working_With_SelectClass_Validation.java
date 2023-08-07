package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Working_With_SelectClass_Validation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		// Scenario : Log to demo Website-->click books-->Check whether the particular item is present in list if there print the index of it 
		
		// Book
		driver.findElement(By.partialLinkText("Books")).click();
		
		//Sort-by drop down
		WebElement sort=driver.findElement(By.id("products-orderby"));
		
		Select s=new Select(sort);
		
		List<WebElement>options=s.getOptions();
		
		for(int i=0;i<options.size()-1;i++)
		{
			String element="Name: Z to A";
		
			if(options.get(i).getText().equals(element))
			{
				System.out.println("The Index of the particular element is: "+i);
			}
		}

	}

}
