package vtiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustry {
	
	public static void main(String args[]) {
		
		Random r=new Random();
		int random = r.nextInt(1000);
				
		
		//1.launch the browser
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//2.load the url
		driver.get("http://localhost:8888/");
		
		//3.login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//4.click on organization link
		
		driver.findElement(By.linkText("Organizations")).click();

		//5.create organization lookup image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//create organization
		String orgname="L&T"+random;
		driver.findElement(By.name("accountname")).sendKeys(orgname);

		
		//6.choose chemicals in industry drop down
		
		WebElement industryDropDown=driver.findElement(By.name("industry"));
		Select s=new Select(industryDropDown);
		s.selectByValue("Chemicals");

		
		//7.save
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//8 validate
	String orgheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (orgheader.contains(orgname))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	
		//8.logout application
	WebElement adminimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		
		act.moveToElement(adminimg).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("logout sucessfully");
		
		
		
		
		
	}

}
