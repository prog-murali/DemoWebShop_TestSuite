package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


// NOTE:                                   contains()

// contains() its from JS we can use the partial value in xpath by using this method
// It is a argumented method we can pass either (@Attribute_Name,'Partial_Attribute_Value) or (text(),'Partial_Text')


// EvenThough we are getting the more matches we can identify the WebElement by using Indexing By putting the Whole Xpression inside the (){Braces}
                            // Example : (//a[contains(@href,'digital')])[1]

// Starts-with()
// Syntax: //Tagname[starts-with(@Attribute_Name,'StartSequence_Attribute_Value')]
//         //Tagname[starts-with(text(),'StartSequence_text')]

public class Working_With_contains_RelXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		// Identify WebElements using the Contains() in RelXpath
		driver.findElement(By.xpath("(//a[contains(text(),'Book')])[1]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Computers')])[1]")).click();
		driver.findElement(By.xpath("(//a[contains(@href,'electronic')])[1]")).click();
		driver.findElement(By.xpath("(//a[contains(@href,'digital')])[1]")).click();
		
	}

}
