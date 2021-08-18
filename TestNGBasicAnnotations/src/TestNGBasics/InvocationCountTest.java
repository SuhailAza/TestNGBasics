package TestNGBasics;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	//Execute same test multiple times with InvocationCount
  @Test(invocationCount = 5)
  public void repeat() {
	  
	  System.out.println("Execution");
	  int sum = 5+10;
	  System.out.println("sum=="+sum);
  }
}
