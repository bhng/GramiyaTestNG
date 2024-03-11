package TestNg_Day6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTestng {
	WebDriver driver;
	@BeforeMethod
	void launch() {
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(dataProvider="TD")
	void login(String uname,String pwd) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@AfterMethod
	void close() {
		driver.quit();
	}
	@DataProvider(name="TD")
	String[][] loginData(){ // two dimensional array
		String data[][]= { // stored data in array
				{"Maha","maha231"},
				{"Admin","admin123"}
				
		};
		
	return data;	
	}

}
