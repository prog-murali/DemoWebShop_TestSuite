package shopperstacktestsuite;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class E2E_AddtoWhishList extends BaseTest  
{
	@Test(priority=1)
	public void Login()
	{
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.id("Email")).sendKeys("sekarna1507@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("AmNaaiSekar#1");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
	}
	
	@Test(priority=2)
	public void Add_To_WhishList()
	{
		driver.findElement(By.id("mensProd")).click();
		driver.findElement(By
		.xpath("//span[contains(text(),'prakasam cotton')]/../following-sibling::div//*[contains(@class,'MuiSvgIcon-root')]")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'MuiAvatar-circular')])[1]")).click();
		driver.findElement(By.xpath("(//li[contains(@class,'MuiMenuItem-root')])[3]")).click();
	}
	
	@Test(priority=3)
	public void Remove_From_WhishList()
	{
		driver.findElement(By.xpath("//button[text()='remove from wishlist?']")).click();
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	@Test(priority=4)
	public void Logout()
	{
		driver.findElement(By.xpath("(//div[contains(@class,'MuiAvatar-circular')])[1]")).click();
		driver.findElement(By.xpath("(//li[contains(@class,'MuiMenuItem-root')])[7]")).click();
	}
}
