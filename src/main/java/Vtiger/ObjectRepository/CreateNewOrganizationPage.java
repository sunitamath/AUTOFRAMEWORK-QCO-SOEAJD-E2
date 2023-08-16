package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	
	//declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDwn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}

	
	//Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDwn() {
		return IndustryDropDwn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Businness logic
	/**
	 * tHIS METHOD WILL CREATEorganization with mandatory fields
	 * @param ORGNAME
	 */
	
	public void createOrganization(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	/**
	 * this method will create organization with industry dropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	
	public void createOrganization(String ORGNAME,String INDUSTRY)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDwn,INDUSTRY);
		saveBtn.click();
	}

}
