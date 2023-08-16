package Vtiger.GenericUtilities;


import java.util.Date;
import java.util.Random;

/**
 * *This class consist of all related generic methods of java
 * @author sunita
 *
 */




public class JavaUtility {
	/**
	 * this method will returns random numbers for every execution
	 * @return
	 */

	public int getRandomNumber()
	{
		Random r=new Random();
	int ran = r.nextInt(1000);
	return ran;

	}
	
	/**
	 * This method will generate Systemdate
	 * @return
	 */

public  String getSystemDate()
{
	Date d=new Date();
	String date = d.toString();
	return date;
	
}


/**
 * This method will generate Systemdate in format
 * @return
 */

public String getSystemDateInFormat()
{

	Date d=new Date();
	String[] date = d.toString().split(" ");
String currentdate = date[2];
String month = date[1];
String year = date[5];
String time = date[3].replace(":", "-");

String dateInFormat=currentdate+" "+month+" "+year+" "+time;
return dateInFormat;
	
}








}