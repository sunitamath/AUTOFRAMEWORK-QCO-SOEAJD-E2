package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//declatration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	//utilization
	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}


	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	//Business Library
	public void clickOnOrgLink()
	{
		OrganizationsLink.click();
	}
	public void clickOnContactsLink()
	{
		ContactsLink.click();
	}
	
	public void logoutOfApp(WebDriver driver) throws Throwable
	{
		mouseHoverAction(driver,AdministratorImg);
		Thread.sleep(1000);
		SignOutLink.click();
	}
	
	
	
	

}
