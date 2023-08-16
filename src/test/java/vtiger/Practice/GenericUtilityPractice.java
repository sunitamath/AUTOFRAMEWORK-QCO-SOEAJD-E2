package vtiger.Practice;

import java.io.IOException;

import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable {

		JavaUtility jutil=new JavaUtility();
		int value = jutil.getRandomNumber();
		System.out.println(value);
		System.out.println(jutil.getSystemDate());
		System.out.println(jutil.getSystemDateInFormat());
		
		PropertyFileUtility putil=new PropertyFileUtility();
		 String value1 = putil.getDataFromPropertyFile("url");
		System.out.println(value1);
		
		ExcelFileUtility eutil=new ExcelFileUtility();
		String data = eutil.getDataFromExcel("Organization",1,2);
		System.out.println(data);
		
		eutil.writeDataIntoExcel("sample", 3, 4, "Batman");
		System.out.println("data added");
	}

}
