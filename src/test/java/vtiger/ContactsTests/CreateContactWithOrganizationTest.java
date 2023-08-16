package vtiger.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;
import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import Vtiger.ObjectRepository.ContactInfoPage;

import Vtiger.ObjectRepository.ContactsPage;
import Vtiger.ObjectRepository.ContactsPage;
import Vtiger.ObjectRepository.CreateNewContactPage;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(Vtiger.GenericUtilities.ListnerImplementationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass {

		
		@Test(groups="SmokeSuite")
		public void createContactWithOrgTest()throws Throwable {
			
			//create object for required utilities
			
			/*JavaUtility jUtil=new JavaUtility();
			ExcelFileUtility eUtil=new ExcelFileUtility();
			PropertyFileUtility pUtil=new PropertyFileUtility();
			WebDriverUtility wUtil=new WebDriverUtility();
			
			
				WebDriver driver=null;*/
				
				
				
				//1.Read all the necessary data	
				/*Read data from property File=common Data*/

			/*String BROWSER = pUtil.getDataFromPropertyFile("browser");
			String URL = pUtil.getDataFromPropertyFile("url");
			String USERNAME = pUtil.getDataFromPropertyFile("username");
			String PASSWORD = pUtil.getDataFromPropertyFile("password");*/
			
			
			//2.read data from excelsheet
			String ORGNAME = eUtil.getDataFromExcel("Organization", 4, 3)+jUtil.getRandomNumber();
			String LASTNAME = eUtil.getDataFromExcel("Organization", 4, 2);
			
			//2.Launch the Browser-driver is acting based run time data
			//polymorphism
			/*					if(BROWSER.equalsIgnoreCase("chrome"))
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
			
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME,PASSWORD);
			
			/*driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();*/
			
			//5.Click on organization link
			HomePage hp=new HomePage(driver);
			hp.clickOnOrgLink();
			Reporter.log("Org Link Clicked");
			
			
			//driver.findElement(By.linkText("Organizations")).click();
			
			//6.create organization lookup image
			OrganizationPage op=new OrganizationPage(driver);
					op.clickonCreateOrgLookUpImg();
					Reporter.log("create org look up image clicked");
			
			//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			//7create organization
			CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
					cnop.createOrganization(ORGNAME);
					Reporter.log("organization  created");
			
			//driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			
		/*	//8.choose chemicals in industry drop down
			
			WebElement industryDropDown=driver.findElement(By.name("industry"));
			wUtil.handleDropDown( industryDropDown,INDUSTRY);*/
			//9.save
			
			// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//8 validation for organization
			OrganizationInfoPage oip =new OrganizationInfoPage(driver);
			String OrgHeader = oip.getHeaderText();
			
			Assert.assertTrue(OrgHeader.contains(ORGNAME));
			System.out.println(OrgHeader);
			
				//String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
					
						
						/*create contact using organization*/
						
						//10.click on contact link
					hp.clickOnContactsLink();
					Reporter.log("Contact link clicked");
						
						//driver.findElement(By.linkText("Contacts")).click();
						
					
						//11.navigate to create contact look up image
					//Assert.fail();
					ContactsPage cp=new ContactsPage(driver);
					cp.clickonCreateContactLookUpImg();
					Reporter.log("Create contact look up image clicked");
					
					//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
						
						
						//12.create contact mandatory information
					CreateNewContactPage cncp=new CreateNewContactPage(driver);
					cncp.CreateContact(driver,LASTNAME,ORGNAME);
					Reporter.log("Contact is created");
						//driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
						//driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']"));
						
						//13.switch to child window
						
						//wUtil.switchToWindow(driver,"Accounts");
						
						//14.search for organization
						//driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
						//driver.findElement(By.name("search")).click();
						//driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click();//dynamic xpath
						
						//15.switch to control back to parent window 
						//wUtil.switchToWindow(driver," Contacts");
						
						//16.save
						//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
						
						//17.validate
						//String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
					ContactInfoPage cip=new ContactInfoPage(driver);
					String ContactHeader = cip.getContactHeader();
						Assert.assertTrue(ContactHeader.contains(LASTNAME));
						System.out.println(ContactHeader);
		}
						//18.logout
						//hp.logoutOfApp(driver);
						
						//WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
							//wUtil.mouseHoverAction(driver, AdminImg);
							
							//driver.findElement(By.linkText("Sign Out")).click();
							//System.out.println("logout sucessfully");
					
							
			@Test
			public void demotest()
			{
				//Assert.fail();
				System.out.println("demo");
			}
}
			
						
						
		
		
		
		
					
			

		
		
		
	


