package tests;

import logger.FrameworkLogger;
import logger.FrameworkLogger.LEVEL;
import harness.TestInfinity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GWC_Ordering_003  extends TestInfinity{

	@Test
	private void gwc_Ordering_003(){
		
		FrameworkLogger.log("Starting GWC_Ordering_003", LEVEL.info, GWC_Ordering_003.class);
		Assert.assertEquals(true, true);
	}
}
