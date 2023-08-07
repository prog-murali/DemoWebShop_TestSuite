package assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Registration Validation
public class TestCase1 {
	public static void main(String[] args) {
				
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//URL V&V
		
		String Url="https://demowebshop.tricentis.com/";
		driver.get(Url);
		
		String ExcepectedUrl=driver.getCurrentUrl();
		
		if(Url.equals(ExcepectedUrl))
		{
			System.out.println("WebPage Loaded Passed");
		}
		else
		{
			System.out.println("WebPage Loaded Failed");
		}	
		
		//Registration
		
		driver.findElement(By.className("ico-register")).click();
		driver.findElement(By.cssSelector("#gender-male")).click();
		driver.findElement(By.cssSelector("[name='FirstName']")).sendKeys("Mani");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Ragul");
		
		driver.findElement(By.cssSelector("#Email")).sendKeys("xyz65@gmail.co.in");
		
		
		driver.findElement(By.cssSelector("input[name='Password']")).sendKeys("123456");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector(".button-1.register-next-step-button")).click();
		
		String actText=driver.findElement(By.className("result")).getText();
		
		String Text="Your registration completed";
		
		if(Text.equals(actText))
		{
			System.out.println("Registration Passed");
		}
		else
		{
			System.out.println("Registration Failed");
		}
		driver.close();
	
	}
		
	

}
