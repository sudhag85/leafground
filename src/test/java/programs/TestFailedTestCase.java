package programs;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFailedTestCase {

	@Test//(retryAnalyzer=RerunFailedTCUsingIRetryAnalyzer.class)
	public void successTest() {
		System.out.println("Hi I am Passed");
		Assert.assertEquals(true, true);
	}
	
	@Test//(retryAnalyzer=RerunFailedTCUsingIRetryAnalyzer.class)
	public void failureTest() {
		System.out.println("Hi I am failed");
		Assert.assertEquals(true, false);
	}
	
}
