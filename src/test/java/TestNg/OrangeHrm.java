package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class OrangeHrm {
	public WebDriver driver;
	@Test(priority=1)
	void openApp() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	}
	@Test(priority=2)
	void logIn() throws InterruptedException {
	    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
   }
	@Test(priority=3)
	 void logOut() {
		   driver.findElement(By.className("oxd-userdropdown-name")).click();
		   driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();   
	   }
	@Test(priority=4)
	void close() {
		driver.close();
	}
}