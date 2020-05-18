package LoginpageTest;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class loginpage {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Lib\\Drivers\\Newchromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//a[@class='login']")).click();
		Thread.sleep(2000);
	}

	@Test
	
	public void title() throws InterruptedException {
		String my_title = driver.getTitle();
		System.out.println("Home page Title is " + my_title);
		String Expected_title = "Login - My Store";
		Assert.assertEquals(my_title, Expected_title);
		Thread.sleep(5000);
	}

	

	@Test
	public void verify_signin() throws InterruptedException {
		
		// click on email
		driver.findElement(By.xpath("//form[@id=\"login_form\"]//input[@id='email']")).sendKeys("shriramtechno@gmail.com");
		// click on password
		driver.findElement(By.id("passwd")).sendKeys("Mukesh@1977");
		// click on Sign in button
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		
		Thread.sleep(4000);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
