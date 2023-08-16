package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of generic methods of propertyFile
 * @author girix
 *
 */


public class PropertyFileUtility {
	
	/**
	 * This method read data from property file based on given key
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
	String value = p.getProperty(key);
		return value;
	}

}
