package tests;

import harness.TestInfinity;
import logger.FrameworkLogger;
import logger.FrameworkLogger.LEVEL;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GWC_RestLocator_001 extends TestInfinity{

	@Test
	private void gwc_RestLocator_001(){
		
		FrameworkLogger.log("Starting GWC_RestLocator_001", LEVEL.info, GWC_RestLocator_001.class);
		Assert.assertEquals(true, true);
	}
}
