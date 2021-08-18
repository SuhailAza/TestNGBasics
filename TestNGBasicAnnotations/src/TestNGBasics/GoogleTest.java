package TestNGBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;


public class GoogleTest {
	
	
	WebDriver driver;
	public String driverPath = "C:\\browserdrivers\\Chrome92\\chromedriver.exe";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		
		//keep window maximize
		driver.manage().window().maximize();
		//set wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Open browser and search for google
		driver.get("https://www.google.com/");
		
	}
	//@Test are selected randomly
	
	
	//Get google title and print
	@Test
	public void googleTitleTest() {
		
		String title = driver.getTitle();
		System.out.print(title);
		
		Assert.assertEquals(title, "Google","Title not displayed");
		
	}
	
	//Verify google logo displayed
	@Test
	public void googleLogoTest() {
		
		boolean isDisplayed = driver.findElement(By.xpath("//*[@alt='Google']")).isDisplayed();
		Assert.assertEquals(isDisplayed, true,"No Logo");
	}
	
	//Verify gmail link NOT displayed
	@Test
	public void gmailLinkTest() {
		
		boolean isDisplayed = driver.findElement(By.linkText("mail")).isDisplayed();
		Assert.assertTrue(isDisplayed);
		
	}
	
	//quit driver
	@AfterMethod
	public void driverQuit() {
		
		driver.quit();
		
	}
	
	
	
	
	
  
}
