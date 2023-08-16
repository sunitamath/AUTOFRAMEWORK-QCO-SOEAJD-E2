package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustryUsingDDT_GU {
public static void main(String args[]) throws Throwable {
		
	//create object for required utilities
	
	JavaUtility jUtil=new JavaUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	
	
		WebDriver driver=null;
		
		
		
		//1.Read all the necessary data	
		/*Read data from property File=common Data*/

	String BROWSER = pUtil.getDataFromPropertyFile("browser");
	String URL = pUtil.getDataFromPropertyFile("url");
	String USERNAME = pUtil.getDataFromPropertyFile("username");
	String PASSWORD = pUtil.getDataFromPropertyFile("password");
	
	
	//2.read data from excelsheet
	String ORGNAME = eUtil.getDataFromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
	String INDUSTRY = eUtil.getDataFromExcel("Organization", 4, 3);
	
	//2.Launch the Browser-driver is acting based run time data
	if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				System.out.println(BROWSER+"---browser launched");
			}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		System.out.println(BROWSER+"---browser launched");
	
	}	
	else
	{
		System.out.println("invalid BROWSER name");

	}
	
	wUtil.maximizeWindow(driver);
	wUtil.waitForElementToLoad(driver);
	//3Load the URL
	driver.get(URL);
	//4.Login to the application
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	//5.Click on organization link
	
	driver.findElement(By.linkText("Organizations")).click();
	
	//6.create organization lookup image
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	//7create organization
	
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	

	//8.choose chemicals in industry drop down
	
	WebElement industryDropDown=driver.findElement(By.name("industry"));
	wUtil.handleDropDown( industryDropDown,INDUSTRY);
	//9.save
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//8 validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if (OrgHeader.contains(ORGNAME))
			{
				System.out.println("pass");
				System.out.println("OrgHeader");
			}
			else
			{
				System.out.println("fail");
			}
			
	//9.logout application
			
			WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.mouseHoverAction(driver, adminImg);
				
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("logout sucessfully");
				
				
}
}
			


	
			

	
	
			
			
			

		
	
		





