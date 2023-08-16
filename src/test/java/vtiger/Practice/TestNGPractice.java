package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test()
	public void createCustomer()
	{
		//Assert.fail();//perpousefully fail
		System.out.println("customer created");
	}
	
	@Test(dependsOnMethods="createCustomer")
	public void modifyCustomer()
	{
		System.out.println("customer modified");
	}
	
	@Test
	public void deleteCustomer()
	{
		System.out.println("customer deleted");
	}

}
