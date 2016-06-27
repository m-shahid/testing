package tests;

import harness.TestInfinity;
import logger.FrameworkLogger;
import logger.FrameworkLogger.LEVEL;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GWC_Ordering_001 extends TestInfinity{

	private WebDriver driver;
	
	GWC_Ordering_001(){
		System.out.println("Constructor in Ordering_001");
	}
	
	@Test
	private void gwc_Ordering_001(){
		
		driver = super.driver;
		FrameworkLogger.log("Starting GWC_Ordering_001", LEVEL.info, GWC_Ordering_001.class);
		driver.get("http://www.google.com");
		Assert.assertEquals(true, true);
	}
}
