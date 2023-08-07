package assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Assignment_Edge_1 
{
	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver","./Drivers/msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		driver.get("https://www.google.co.in");
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

}
