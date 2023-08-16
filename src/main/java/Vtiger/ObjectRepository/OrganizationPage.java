package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	//Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	
	//Initialization
	public OrganizationPage(WebDriver driver) {
		
		PageFactory.initElements( driver,this);
	}

	//Utilization
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}
	

	//Business logic
	public void clickonCreateOrgLookUpImg() {
	CreateOrgLookUpImg.click();
	}
	
	

}
