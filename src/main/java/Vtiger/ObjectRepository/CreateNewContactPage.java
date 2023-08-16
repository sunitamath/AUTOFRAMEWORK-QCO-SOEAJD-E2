package Vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::Img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name="search")
	private WebElement SearchBtn;
	
	
	//initialization
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

//utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}


	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}


	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}


	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	
	//business logic
	/**
	 * thos method will create contact  with mandatory information
	 * @param LASTNAME
	 */
	
	public  void CreateContact(String LASTNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will create contact with relevant organization
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	public void CreateContact(WebDriver driver ,String LASTNAME,String ORGNAME )
	{
		LastNameEdt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchToWindow(driver,"Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver,"Contacts");
		SaveBtn.click();
	}
	
	
	
	

}
