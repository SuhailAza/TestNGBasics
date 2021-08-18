# TestNGBasics
Basic TestNG with Selenium. Contains TestNG Annotations, Dependencies, Grouping, Priority, InvocationCount and Parameters

Annotations-------------

Precondition========
@BeforeSuite: A method which is marked with this annotation will run only once before all tests in the suite have run
@BeforeTest: A method which is marked with this annotation will be executed before first @Test annotated method.
@BeforeClass: A method which is marked with this annotation will be executed before first @Test method execution. It runs only once per class.
@BeforeMethod: A method which is marked with this annotation will be executed before every @test annotated method.

Test Annotations======
@Test: Marks a class or a method as a part of the test.

Postcondition=====
@AfterMethod: A method which is marked with this annotation will be executed after every @test annotated method.
@AfterClass: A method which is marked with this annotation will be executed after all the test methods in the current class have been run
@AfterTest: A method which is marked with this annotation will be executed when all @Test annotated methods complete the execution of those classes which are inside <test> tag in testng.xml file.

@AfterSuite: A method which is marked with this annotation will run once after execution of all tests in the suite have run
@BeforeGroups: This annotated method will run before the first test run of that specific group.
@AfterGroups: This annotated method will run after all test methods of that group completes its execution.
Some other TestNG Annotations, we need to discuss here are mentioned below:
@Parameters: This annotation is used to pass parameters to test methods.
  
  
  
The @Test will not execute in any order, it executes @Test randomly with pairing with methods

@BeforeSuite -- Given priority always
@BeforeTest -- Executes Second
@BeforeClass -- Executes Third

@BeforeMethod
@Test
@AfterMethod

@BeforeMethod
@Test
@AfterMethod

@BeforeMethod
@Test
@AfterMethod

@AfterClass
@AfterTest
  
  
  
  
---- Group TC's ----
@Test(groups = { "functest", "checkintest" })
 <groups>
      
         <define name = "all">
            <include name = "functest"/>
            <include name = "checkintest"/>
         </define>
         
         <run>
            <include name = "all"/>
         </run>
         
      </groups>
      
      <classes>
         <class name = "GroupTestExample" />
      </classes>
	  
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


--- Priority -----
Executes based on priority. Ex. priority=1, then next priority=2

@Test (priority=1)
public void googleLogoTest() {
			System.out.print("Test 1");
			}
@Test (priority=2)
public void googleTest() {
			System.out.print("Test 2");
			}


--- InvocationCount ----
Execute same test multiple times
@Test (invocationCount=5)

--- expectedException ---
if there is an exception that we know will come and test will fail, we can use "expectedExceptio=<exceptionName>.class" to execute test even with the exception

//This should fail because it throws an exception but with "expectedException" it will pass
@Test(expectedException=NumberFormatException.class)
public void test(){
	String x = "100A";
	Integer.parseInt(x);
}


--- Executing Test Cases ---

Create XML template file
src -> new -> file -> name=testng.xml

======================================================================
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
  
<suite name="TestNGBasics Suite" verbose="1" >


  <test name="Test Execution (Any Name of execution)" >
    <classes>
       <class name="TestNGBasics.InvocationCountTest (<packagename>.<classname>)" />
    </classes>
  </test>
 
  <test name="Regression1">
    <classes>
      <class name="test.sample.ParameterSample"/>
      <class name="test.sample.ParameterTest"/>
    </classes>
  </test>
  
  
  
</suite>
======================================================================

--- Parameters ---

*Can use as environment variables, example. Browser chrome,firefox etc or env ex. QA, DEV.

	@Test
	@Parameters({"browser","username","password"})
	public void loginTest(String browser, String username, String password){
	
	if(browser.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", chomedriverPath);
		driver = new ChromeDriver();
	}else if (browser.equals("firefox")){
		System.setProperty("webdriver.gecko.driver", geckodriverPath);
		driver = new FirefoxDriver();
	}
	
	}
	
testng.xml file

==================================================================
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
  
<suite name="TestNGBasics Suite" verbose="1" >


<!-- TestNG Parameters -->
<test name="Test Execution 1" >
	<parameter name="browser" value="chrome" />
	<parameter name="username" value="suhailaza" />
	<parameter name="password" value="password@123" />

    <classes>
       <class name="TestNGBasics.parametersTest" />
    </classes>
  </test>
  
  
</suite>  
