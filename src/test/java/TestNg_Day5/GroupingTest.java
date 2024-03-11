package TestNg_Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GroupingTest {
	WebDriver driver;
	@Test(priority=1,groups="smoke")
	void oragehrm() {
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@Test(priority=2,groups="regression")
	void amazon() {
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
	}
	@Test(priority=3,groups={"smoke","regression"})
	void flipkart() {
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}

}
