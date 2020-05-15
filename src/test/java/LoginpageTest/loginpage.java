package LoginpageTest;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class loginpage {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Lib\\Drivers\\Newchromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.phptravels.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
	}

	@Test
	public void title() throws InterruptedException {
		String my_title = driver.getTitle();
		System.out.println("Home page Title is " + my_title);
		String Expected_title = "PHPTRAVELS booking script and system for hotels airline flights tours cars online application - PHPTRAVELS";
		Assert.assertEquals(my_title, Expected_title);
	}

	@Test
	public void logoImageTEst() {
		WebElement ImageFile = driver.findElement(By.xpath("//img[@class='brand']"));

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				ImageFile);
		if (!ImagePresent) {
			System.out.println("Logo is not displayed.");
		} else {
			System.out.println("Logo is displayed.");
		}
	}

	@Test
	public void companyTab_contect_us() throws InterruptedException {
		// click on company tab
		driver.findElement(By.xpath("//*[@class='has-drop']//span[text()='Company']")).click();
		// click on contect us link
		driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[5]/div/ul/li[5]/a")).click();
		// Display Addressh
		Boolean Display = driver.findElement(By.xpath("//*[@class='panel-heading']")).isDisplayed();
		// To print the value true or falls
		System.out.println("Element displayed is :" + Display);
		Thread.sleep(4000);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
