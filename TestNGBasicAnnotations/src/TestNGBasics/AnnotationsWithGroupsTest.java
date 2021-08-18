package TestNGBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsWithGroupsTest {
  
	
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
		//driver.get("https://www.google.com/");
		
	}
	//Group Tests
	
	
	//Test 1
	@Test(groups =  "Group 1")
	public void googleTitleTest() {
		
		
		System.out.print("Test 1");
	}
	
	//Test 2
	@Test(groups = "Group 1")
	public void googleLogoTest() {
		
		
			System.out.print("Test 2");
	}
	
	//Test 3
	@Test(groups = "Group 2")
	public void gmailLinkTest() {
		
		
			System.out.print("Test 3");	
	}
	
	//quit driver
	@AfterMethod
	public void driverQuit() {
		
		driver.quit();
		
	}
	
}
