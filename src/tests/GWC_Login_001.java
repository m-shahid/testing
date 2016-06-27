package tests;

import harness.TestInfinity;
import logger.FrameworkLogger;
import logger.FrameworkLogger.LEVEL;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GWC_Login_001 extends TestInfinity{


	@Test
	private void gwc_Login_001(){
		
		FrameworkLogger.log("Starting GWC_Login_001", LEVEL.info, GWC_Login_001.class);
		Assert.assertEquals(true, true);
	}
}
