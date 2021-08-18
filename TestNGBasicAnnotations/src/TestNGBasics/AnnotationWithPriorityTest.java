package TestNGBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationWithPriorityTest {
  
	
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
	//@Test are executed based on priority, 1 then 2 etc.
	
	
	//Get google title and print
	@Test(priority = 1)
	public void googleTitleTest() {
		
		String title = driver.getTitle();
		System.out.print(title);
		
	}
	
	//Verify google logo displayed
	@Test(priority = 2)
	public void googleLogoTest() {
		
		boolean isDisplayed = driver.findElement(By.xpath("//*[@alt='Google']")).isDisplayed();
		if(isDisplayed == true) {
			System.out.print("Logo Displayed");
		}else {
			System.out.print("No Logo");
		}
	}
	
	//Verify gmail link NOT displayed
	@Test(priority = 3)
	public void gmailLinkTest() {
		
		boolean isDisplayed = driver.findElement(By.linkText("mail")).isDisplayed();
		if(isDisplayed == true) {
			System.out.print("Gmail Link Displayed");
		}else {
			System.out.print("No Link");
		}
		
	}
	
	//quit driver
	@AfterMethod
	public void driverQuit() {
		
		driver.quit();
		
	}
	
	
	
}
