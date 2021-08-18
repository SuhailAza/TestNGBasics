package TestNGBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Pause;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

public class parametersTest {
	
	WebDriver driver;
	public String driverPath = "C:\\browserdrivers\\Chrome92\\chromedriver.exe";
	
	
	/*Paramterized values are taken from testng.xml file, can be used to parameterize environment variables 
	like browser, env or url.
	*/
	@Test
	@Parameters({"url","username","password"})
	public void loginTest(String url, String username, String password) {
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver= new ChromeDriver();
		
		driver.get(url);
		
		//Get page elements
		WebElement txt_Username = driver.findElement(By.xpath("//input[@name='login']"));
		WebElement txt_Password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement btn_SignIn = driver.findElement(By.xpath("//input[@value='Sign in']"));
		
		txt_Username.sendKeys(username);
		txt_Password.sendKeys(password);
		btn_SignIn.click();
		
		
		
		
		
	}

}
