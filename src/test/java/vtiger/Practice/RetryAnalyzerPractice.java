package vtiger.Practice;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	
	@Test(retryAnalyzer= vtiger.Practice.RetryAnalyzerImplimentation.class)
	public void sample()
	{
		//Assert.fail();
		System.out.println("Hi");
	}

}
