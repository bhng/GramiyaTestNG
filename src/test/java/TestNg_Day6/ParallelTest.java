package TestNg_Day6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {
	
	WebDriver driver;
	@BeforeClass
	@Parameters("browser")
	void setup(String br) {
		if(br.equals("chrome")) {
		driver=new ChromeDriver();
		}else{
			driver=new EdgeDriver();
		}
	}
	@Test(priority=1)
	@Parameters("url")
	void launch(String appurl) {
		
		driver.get(appurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(priority=2)
	@Parameters({"username","password"})
	void login(String uname,String pwd) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@AfterClass
	void close() {
		driver.quit();
	}

}
