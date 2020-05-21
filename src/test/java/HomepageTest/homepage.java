package HomepageTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public void verify_T_shirt_link() throws IOException {
		if (driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a"))
				.isDisplayed()) {
			System.out.println("T_shirt Manu is Visible");
		} else {
			System.out.println("T_shirt Manu is InVisible");
		}

		if (driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a")).isEnabled()) {
			System.out.println("T_shirt Manu is Enabled");
		} else {
			System.out.println("T_shirt Manu is UnEnabled");
		}
		if (driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a"))
				.isSelected()) {
			System.out.println("T_shirt Manu is Selected");
		} else {
			System.out.println("T_shirt Manu is UnSelected");

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(src, new File("F:\\Selenium\\Screenshort\\screenshot1.png"));

			File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src1, new File("F:\\Selenium\\Workspace\\My_Store\\screenshot@.png"));

			WebElement logo = driver
					.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a"));
			File file = logo.getScreenshotAs(OutputType.FILE);

			File destifile = new File("logo.png");
			FileUtils.copyFile(file, destifile);
		}

	}

	@Test
	public void verift_My_cart_link() {
		if (driver.findElement(By.xpath("//a[@title='View my shopping cart']")).isDisplayed()) {
			System.out.println("T_shirt Manu is Selected");
		} else {
			System.out.println("T_shirt Manu is UnSelected");
		}
		driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
		if (driver.findElement(By.xpath("//a[@title='View my shopping cart']")).isEnabled()) {
			System.out.println("cart page Dispayed verify");
		} else {
			System.out.println("cart page UnDispayed not verify");
		}
	}

	@Test
	public void My_wish_list() {
		if (driver.findElement(By.xpath("//span[text()='My wishlists']")).isDisplayed()) {
			System.out.println("My_wish_list is Displayed");
		} else {
			System.out.println("My_wish_list is UnDisplayed");
		}

		if (driver.findElement(By.xpath("//span[text()='My wishlists']")).isEnabled()) {
			System.out.println("My_wish_list is Enabled and verify");
		} else {
			System.out.println("My_wish_list is UnEnabled");

		}
	}

	@Test
	public void verift_searsh_box() {

		driver.findElement(By.xpath("//input[@class='search_query form-control ac_input']")).sendKeys("woman");
		driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();
		// click on lowest first
		driver.findElement(By.xpath("//*[@id=\"selectProductSort\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"selectProductSort\"]/option[2]")).click();

		// click on one product add to cart button
		driver.findElement(By.xpath("//*[@id=\"best-sellers_block_right\"]/div/ul/li[1]/a/img")).click();
		driver.findElement(By.xpath("//*[@id='add_to_cart']")).click();
		// click on process to checkout.
		// please manage popup windows for this part

		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				// <!--Perform your operation here for new window-->
				driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")).click();
				driver.close(); // closing child window
				driver.switchTo().window(parentWindow); // control to parent window
			}
		}

		// click on cart link and open the cart page
		driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
		// verify the order in the cart page
		if (driver.findElement(By.xpath("//a[@title='Delete']")).isDisplayed()) {
			System.out.println("Verify the cart page");
		} else {
			System.out.println("Cart page not verify");

		}
	}

	@Test
	public void verift_backto_home_link() {
		driver.findElement(By.xpath("//a[@title='Home']")).click();

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
