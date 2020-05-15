package sign_inPage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class sign_in_page {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Lib\\Drivers\\Newchromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
	}

	@Test
	public void verify_logo() throws InterruptedException {
		
		if( driver.findElement(By.xpath("//img[@class='logo img-responsive']")).isDisplayed()){
			System.out.println("Logo is Visible");
			}else{
			System.out.println("Logo is InVisible");
			}
		}
	

	@Test
	public void verify_dealAdd() {
		if( driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed()){
			System.out.println("Deal add is Visible");
			}else{
			System.out.println("Deal add is InVisible");
			}
		
	}

	@Test
	public void verify_SignInLink() {
		if( driver.findElement(By.xpath("//a[@class='login']")).isDisplayed()){
			System.out.println("Login Button is Visible");
			}else{
			System.out.println("Login Button is InVisible");
			}
	}
	
	@Test
	public void verify_title() {
		String my_title = driver.getTitle();
		System.out.println("Home page Title is " + my_title);
		String Expected_title = "My Store";
		Assert.assertEquals(my_title, Expected_title);
	}
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
