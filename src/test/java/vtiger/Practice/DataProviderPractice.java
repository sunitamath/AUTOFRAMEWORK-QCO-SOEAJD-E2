package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@Test(dataProvider="getData")
	public void addToCartTest(String name,int price,String model)
	{
		System.out.println("phone name is "+name+" price is "+price+" model is "+model);
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][3];
		
		data[0][0]="Iphone";//1st set of data
		data[0][1]=20000;
		data[0][2]="S14";
		
		data[1][0]="Samsung";//2st set of data
		data[1][1]=15000;
		data[1][2]="A80";
		
		

		data[2][0]="Vivo";//3rd set of data
		data[2][1]=10000;
		data[2][2]="V10";
		
		return data;
		
		
	}
	
	

}
