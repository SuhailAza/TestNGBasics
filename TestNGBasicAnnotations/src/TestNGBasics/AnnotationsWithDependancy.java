package TestNGBasics;

import org.testng.annotations.Test;

public class AnnotationsWithDependancy {
	
	/*dependsOnMethods allows tests to be dependant on a previous test, if first test fails then the
	dependant test wont execute and will skip
	*/
	
  //Login
  @Test
  public void login() {
	  
	  System.out.println("Login to app");
  }
  
  //Navigate to messages
  @Test(dependsOnMethods = "login")
  public void navigateToMessage() {
	  
	  System.out.println("Send message");
  }
  
  @Test
  public void openBrowser() {
	  
	  int i = 9/0;
	  System.out.println("Open Browser");
  }
  
  @Test(dependsOnMethods = "openBrowser")
  public void search() {
	  
	  System.out.println("Search");
  }
  
  
  
}
