package TestNg_Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Task_DemoBlaze {
	WebDriver driver;
	@BeforeMethod
	void launch() {
		driver=new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
	}
	@Test
	void login() {
		driver.findElement(By.id("login2")).click();
		driver.findElement(By.id("loginusername")).sendKeys("demo");
		driver.findElement(By.id("loginpassword")).sendKeys("demo");
		driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
		
		String Expres="";
		String actres=driver.findElement(By.xpath("//a[text()='Log out']")).getText();
		System.out.println(actres);
		//validation
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(Expres, actres);
		sa.assertAll();	
	}

}
