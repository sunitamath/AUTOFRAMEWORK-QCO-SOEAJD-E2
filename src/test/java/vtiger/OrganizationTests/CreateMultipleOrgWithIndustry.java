package vtiger.OrganizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import Vtiger.GenericUtilities.BaseClass;
import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;


public class CreateMultipleOrgWithIndustry extends BaseClass{
	
	/*JavaUtility jUtil=new JavaUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();*/
	
	
	
	@Test(dataProvider="getData")
	public void createMultipleOrg(String ORG,String INDUSTRY) throws Throwable
	{
		/*WebDriver driver=null;
		//1Read data from property file
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");*/
		
		
		//2.read data from excelsheet
		String ORGNAME = ORG+jUtil.getRandomNumber();


		//2.Launch the Browser-driver is acting based run time data
		//polymorphism
	/*	if(BROWSER.equalsIgnoreCase("chrome"))
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
		
		/*driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();*/
		
		//LoginPage lp=new LoginPage(driver);
		//lp.getUserNameEdt().sendKeys(USERNAME);
		//lp.getPasswordEdt().sendKeys(PASSWORD);
		//lp.getLoginbtn().click();
		
		// lp.loginToApp( USERNAME, PASSWORD);
		
				
		
		
		
		//5.Click on organization link
		 HomePage hp=new HomePage(driver);
		 hp.clickOnOrgLink();
		
		//driver.findElement(By.linkText("Organizations")).click();
		
		//6.create organization lookup image
		 OrganizationPage op=new OrganizationPage(driver);
		 op.clickonCreateOrgLookUpImg();
		 
		 
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//7create organization
		 CreateNewOrganizationPage conp=new CreateNewOrganizationPage(driver);
		 conp.createOrganization(ORGNAME, INDUSTRY);
		
		//driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//8.choose chemicals in industry drop down
		
		//WebElement industryDropDown=driver.findElement(By.name("industry"));
		//wUtil.handleDropDown( industryDropDown,INDUSTRY);	
		//9.save
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//8 validate
		 OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				String OrgHeader = oip.getHeaderText();
				Assert.assertTrue( OrgHeader.contains(ORGNAME));
				System.out.println(OrgHeader);
		 
			/*String orgheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if (OrgHeader.contains(ORGNAME))
				{
					System.out.println("pass");
					System.out.println("OrgHeader");
				}
				else
				{
					System.out.println("fail");
				}*/
		
		
		//8.logout application
				
				//hp.logoutOfApp(driver);
			//	System.out.println("logout sucessfully");
				
		//WebElement adminimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//	Actions act=new Actions(driver);
			
			//act.moveToElement(adminimg).perform();
			
			//driver.findElement(By.linkText("Sign Out")).click();
			
	}	
		
			

	@DataProvider
	public Object[][] getData() throws Throwable, IOException
	{
		return eUtil.readMultipleData("MultipleOrg");
	}
}
