package TestNg_Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task_Amazon {
	WebDriver driver;
	@Test
	void launch() {
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		String Expres=".in";
		String actres=driver.findElement(By.id("nav-logo-sprites")).getText();
		System.out.println(actres);
		//validation
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(Expres, actres);
		sa.assertAll();	
	}
}
