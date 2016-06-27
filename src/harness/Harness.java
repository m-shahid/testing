package harness;

import static utils.ExcelReader.executionDetailsMap;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import logger.FrameworkLogger;
import logger.FrameworkLogger.LEVEL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ExcelReader;

public class Harness {

	private WebDriver webDriver;
	private LinkedHashMap<String, String> executionBatchMap;
	
	private static final String RUN_MODE_YES = "Yes";
	public static final String BROWSER_NAME = "Browser";
	public static final String VERSION = null;
	
	ExcelReader excelUtility;
	
	public Harness(){
		
		excelUtility = new ExcelReader();
	}
	
	public WebDriver initializeWebDriver(){
		
		try{
			
			
			String browser = getExecutionDetail(BROWSER_NAME);
			
			switch(browser.toLowerCase()){
			
				case "firefox":
					
					webDriver = new FirefoxDriver(); 
					break;
					
				case "chrome":
					
					break;
				
				case "internetexplorer":
					
					break;
					
				default:
					FrameworkLogger.log("Please select valid browser name", LEVEL.error, Harness.class);
			}
			
			return webDriver;
			
		}catch(Exception msg){
			
			return null;
			
		}
	}
	
	public void closeBrowser(){
		webDriver.quit();
	}
	
	public String getExecutionDetail(String property){
		
		try{
			
			return executionDetailsMap.get(property);
			
		}catch(Exception msg){
			
			return null;
		}
	}
	
	public ArrayList<String> getClasses(){

		ArrayList<String> testScript = null;

		try{

			testScript = new ArrayList<String>();
			executionBatchMap = excelUtility.readExecutionBatch();

			for(String key : executionBatchMap.keySet()){

				//System.out.println("Test Script Name : "+key+" And Run Mode : "+executionBatchMap.get(key));

				String strRunMode = executionBatchMap.get(key);

				if(strRunMode.equalsIgnoreCase(RUN_MODE_YES)){

					testScript.add(key);
				}
			}

			return testScript;

		}catch(Exception msg){

			FrameworkLogger.log("Exception while getting test scripts to be executed. See getClasses() for more details", LEVEL.fatal, TestInfinity.class);
			return null;
		}

	}
}
