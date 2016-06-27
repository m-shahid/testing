package tests;

import harness.TestInfinity;
import logger.FrameworkLogger;
import logger.FrameworkLogger.LEVEL;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GWC_Login_002 extends TestInfinity{

	@Test
	private void gwc_Login_002(){
		
		FrameworkLogger.log("Starting GWC_Login_002", LEVEL.info, GWC_Login_002.class);
		Assert.assertEquals(true, false);
	}
}
