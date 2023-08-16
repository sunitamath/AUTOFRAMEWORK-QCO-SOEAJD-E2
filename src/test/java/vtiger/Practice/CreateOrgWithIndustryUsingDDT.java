package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustryUsingDDT {
public static void main(String args[]) throws IOException, EncryptedDocumentException, InvalidFormatException {
		
		WebDriver driver=null;
		
		Random r=new Random();
		int random = r.nextInt(1000);
				
		
		//1.Read all the necessary data
		/*Read data from property File=common Data*/

		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj=new Properties();
		pObj.load(fisp);
	String BROWSER = pObj.getProperty("browser");
	String URL = pObj.getProperty("url");
	String USERNAME=pObj.getProperty("username");
	String PASSWORD=pObj.getProperty("password");
	
	/*Read data from excel sheet =Test data*/
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\VtidataExcel.xlsx");
	Workbook wb=WorkbookFactory.create(fise);
	Sheet sh = wb.getSheet("Organization");
	String ORGNAME = sh.getRow(4).getCell(2).getStringCellValue()+random;
	String INDUSTRY = sh.getRow(4).getCell(3).getStringCellValue();
	
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
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
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
	Select s=new Select(industryDropDown);
	s.selectByValue("Chemicals");
	
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
				Actions act=new Actions(driver);
				
				act.moveToElement(adminImg).perform();
				
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("logout sucessfully");
				
				
}
}
			


	
			

	
	
			
			
			

		
	
		


