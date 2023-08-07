package assignments;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Working_With_SelectClass_getOptionsMethod {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		// Scenario : Log to demo Website-->click books-->Select the options one by one from the Sorty by DropDown
		
		// Book
		driver.findElement(By.partialLinkText("Books")).click();   
		
		//Sort-by drop down
		Select s=new Select(driver.findElement(By.id("products-orderby")));
		
		List<WebElement>options=s.getOptions();
		
		for(int i=0;i<=options.size()-1;i++)
		{
			s.selectByIndex(i);
			s=new Select(driver.findElement(By.id("products-orderby")));
		}
	}

}
