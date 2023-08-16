package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		
		//1.Load the document in java readable  format
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//2.create object of  properties class from java.util
				Properties pObj=new Properties();
				
					
		//3.load the file into properties class
			pObj.load(fis);	
			
		//4.provide the key and get the value
			String value = pObj.getProperty("password");
			System.out.println(value);
						
	}

}


