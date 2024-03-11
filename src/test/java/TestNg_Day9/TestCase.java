package TestNg_Day9;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase {
	WebDriver driver;
	@BeforeClass
	void setup() {
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	@Test
	void login() throws IOException {
		String file=System.getProperty("user.dir")+"/Data/Test Data R W.xlsx";
		//get num of rows
		int rows=Utils.getRowCount(file, "Sheet1");
		for(int r=0;r<=rows;r++) {
			//read from excel
			String username=Utils.getCellData(file, "Sheet1", r, 0);
			String pwd=Utils.getCellData(file, "Sheet1", r, 1);
			//pass to website
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			//validation
			String expres="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
			String actres=driver.getCurrentUrl();
			if(actres.equals(expres)) {
				System.out.println("Test is passed");
				Utils.setCellData(file, "Sheet1", r, 2, "pass");//write pass into xl
				Utils.fillGreenColour(file, "Sheet1", r, 2);
				
				//logout
				driver.findElement(By.className("oxd-userdropdown-name")).click();
				driver.findElement(By.xpath("//a[text()='Logout']")).click();
			}else {
				System.out.println("failed");
				Utils.setCellData(file, "Sheet1", r, 2, "fail");
				Utils.fillRedColour(file, "Sheet1", r, 2);
			}
		}
	}
	@AfterClass
	void close() {
		driver.close();
	}
}