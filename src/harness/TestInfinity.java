package harness;

import java.util.ArrayList;
import java.util.List;

import logger.FrameworkLogger;
import logger.FrameworkLogger.LEVEL;

import org.openqa.selenium.WebDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestInfinity {

	public WebDriver driver;
	Harness frameworkHarness;
	
	public TestInfinity(){
		
		frameworkHarness = new Harness();
	}
	
	@BeforeSuite
	public void initialiseEnvironment(){
		 
	}
	
	@BeforeClass
	public void setUP(){
		driver = frameworkHarness.initializeWebDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void quiteDriver(){
		frameworkHarness.closeBrowser();
	}
	
	public void startExecution(){
		
		//Create an instance on TestNG
				TestNG testNG = new TestNG();

				//Create an instance of XML Suite and assign a name for it.
				XmlSuite suite = getXmlSuite();

				//Create an instance of XmlTest and assign a name for it.
				FrameworkLogger.log("Creating instance of XMLTest", LEVEL.debug, TestInfinity.class);
				XmlTest test = getXmlTest(suite);
				
				//Create a list which can contain the classes that you want to run.
				FrameworkLogger.log("Getting instances of Test Scripts Classes", LEVEL.debug, TestInfinity.class);
				List<XmlClass> classes = getXmlClasses();

				//Assign that to the XmlTest Object created earlier.
				test.setXmlClasses(classes);

				//Create a list of XmlTests and add the Xmltest you created earlier to it.
				List<XmlTest> tests = new ArrayList<XmlTest>();
				tests.add(test);

				//add the list of tests to your Suite.
				suite.setTests(tests);

				//Add the suite to the list of suites.
				List<XmlSuite> suites = new ArrayList<XmlSuite>();
				suites.add(suite);

				//Set the list of Suites to the testNG object you created earlier.
				testNG.setXmlSuites(suites);

				//invoke run() - this will run your class.
				FrameworkLogger.log("Running TestNG run method", LEVEL.debug, TestInfinity.class);
				testNG.run();
		
	}
	
	private XmlSuite getXmlSuite() {
		XmlSuite suite = new XmlSuite();
		suite.setName("Regression Test Suite");
		return suite;
	}

	private XmlTest getXmlTest(XmlSuite suite) {
		XmlTest test = new XmlTest(suite);
		test.setName("regression tests");
		return test;
	}

	private List<XmlClass> getXmlClasses() {
		List<XmlClass> classes = new ArrayList<XmlClass>();
		
		ArrayList<String> testScripts = frameworkHarness.getClasses();
		
		for(int i=0; i<testScripts.size(); i++){
			
			classes.add(new XmlClass("tests."+testScripts.get(i)));
		}
		
		return classes;
	}
	
	
}
