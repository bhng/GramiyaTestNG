package TestNg_Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SauceDemoTask {
	WebDriver driver;
	@BeforeClass
	@Parameters("browser")
	void setup(String br) {
		if(br.equals("chrome")) {
		driver=new ChromeDriver();
		}else
			driver=new EdgeDriver();
	}
	@Test(priority=1)
	@Parameters("url")
	void launch(String appurl) {
		
		driver.get(appurl);
		driver.manage().window().maximize();
	}
	@Test(priority=2)
	@Parameters({"username","password"})
	void login(String uname,String pwd)  {
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(uname);
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
	    driver.findElement(By.xpath("//input[@id='login-button']")).click();	    
	}
	 @Test(priority = 3)
	     void selectPriceLowToHigh() throws InterruptedException {
		 // Select price (low to high) from dropdown
		 Select dropdown =new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		    Thread.sleep(3000);
		    dropdown.selectByIndex(3);
	    }
	  @Test(priority = 4)
	    public void addProductToCart() {
	        // Add product to cart
	       driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
	    }
	    @Test(priority = 5)
	    public void goToShoppingCart() {
	        // Go to shopping cart
	       driver.findElement(By.className("shopping_cart_link")).click();
	    }
	    @Test(priority = 6)
	    public void continueCheckout() {
	        // Continue checkout
	       driver.findElement(By.xpath("//button[@id='checkout']")).click();
	    }
	    @Test(priority = 7)
	    @Parameters({"first-name","last-name","postal-code"})
	     void enterInformationAndContinue(String firstname,String lastname,String postalcode) {
	        // Enter information and continue
	       driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("firstname");
	       driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("lastname");
	       driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys("postalcod");
	       driver.findElement(By.xpath("//input[@id='continue']")).click();
	    }
	    @Test(priority = 8)
	    public void clickOnFinish() {
	        // Click on finish
	        driver.findElement(By.xpath("//button[@id='finish']")).click();
	    }
	@AfterClass
	void close() {
		driver.quit();
	}
}