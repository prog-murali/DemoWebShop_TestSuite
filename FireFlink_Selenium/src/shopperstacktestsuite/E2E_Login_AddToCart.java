package shopperstacktestsuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class E2E_Login_AddToCart extends BaseTest 
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
	public void Add_To_Cart()
	{
		driver.findElement(By.id("electronicsProd")).click();	
		driver.findElement(By.xpath("//span[text()='boat rockerz 450']/../following-sibling::div/button")).click();
		driver.findElement(By.id("cart")).click();
		String count=driver.findElement(By.xpath("//a[@id='cart']/span")).getText();
		System.out.println("Count after adding:"+count);
	}
	
	@Test(priority=3)
	public void remove()
	{
		driver.findElement(By.cssSelector(".MuiButton-textSizeSmall")).click();
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		String count=driver.findElement(By.xpath("//a[@id='cart']/span")).getText();
		System.out.println("Count after removing:"+count);
	}
	
	@Test(priority=4)
	public void Logout()
	{
		driver.findElement(By.xpath("(//div[contains(@class,'MuiAvatar-circular')])[1]")).click();
		driver.findElement(By.xpath("(//li[contains(@class,'MuiMenuItem-root')])[7]")).click();
	}
}
