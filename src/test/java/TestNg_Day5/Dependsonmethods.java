package TestNg_Day5;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;

	public class  Dependsonmethods {
		WebDriver driver;
		@Test(priority=1)
		void launch() {
			driver=new ChromeDriver();
	driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
			driver.manage().window().maximize();
			Assert.assertTrue(false);//fail the method by using hard assert
		}
		@Test(priority=2,dependsOnMethods="launch")// dependsOnMethods="launch"
		void login() throws InterruptedException {
			WebElement mail=driver.findElement(By.xpath("//input[@id='Email']"));
			mail.clear();
			mail.sendKeys("admin@yourstore.com");
			WebElement pwd=driver.findElement(By.xpath("//input[@class='password']"));
			pwd.clear();
			pwd.sendKeys("admin");	driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(5000);
			String Expres="Dashboard";
			String actres=driver.findElement(By.xpath("//div[@class='content-header']/h1")).getText();
			System.out.println(actres);
			//validation
			SoftAssert sa=new SoftAssert();
			sa.assertEquals(Expres, actres);
			sa.assertAll();	
		}
		@Test(priority=3)
		void close() {
			driver.quit();
		}
}
