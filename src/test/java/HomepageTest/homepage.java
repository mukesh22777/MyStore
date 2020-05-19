package HomepageTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class homepage {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Lib\\Drivers\\Newchromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//a[@class='login']")).click();
		// click on email
		driver.findElement(By.xpath("//form[@id=\"login_form\"]//input[@id='email']"))
				.sendKeys("shriramtechno@gmail.com");
		// click on password
		driver.findElement(By.id("passwd")).sendKeys("Mukesh@1977");
		// click on Sign in button
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		Thread.sleep(4000);
	}

	@Test
	public void verify_My_wish_list() {
		driver.findElement(By.xpath("//a[@title='My wishlists']")).click();

		if (driver.findElement(By.xpath("//*[@class='page-heading']")).isDisplayed()) {
			System.out.println("My wish lable is Visible");
		} else {
			System.out.println("My wish lable is InVisible");
		}
	}

	@Test
	public void verify_T_shirt_link() {
		if (driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).isDisplayed()) {
			System.out.println("T_shirt Manu is Visible");
		} else {
			System.out.println("T_shirt Manu is InVisible");
		}

		if (driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).isEnabled()) {
			System.out.println("T_shirt Manu is Enabled");
		} else {
			System.out.println("T_shirt Manu is UnEnabled");
		}
		if (driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).isSelected()) {
			System.out.println("T_shirt Manu is Selected");
		} else {
			System.out.println("T_shirt Manu is UnSelected");
		}
	}

	//@Test
	public void verift_My_cart_link() {
	}

	//@Test
	public void My_wish_list() {
	}

	//@Test
	public void verift_searsh_box() {
	}

	//@Test
	public void verift_backto_home_link() {
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
