package tests;

import harness.TestInfinity;
import logger.FrameworkLogger;
import logger.FrameworkLogger.LEVEL;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GWC_Ordering_001 extends TestInfinity{

	@Test
	private void gwc_Ordering_001(){
		
		FrameworkLogger.log("Starting GWC_Ordering_001", LEVEL.info, GWC_Ordering_001.class);
		System.out.println("Running GWC_Ordering_001");
		Assert.assertEquals(true, true);
	}
}
