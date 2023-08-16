package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;

	//initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}

//utilization
	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	
	//business logic
	/**
	 * This method will capture the headertext and return to the caller
	 * @return
	 */
	public String getContactHeader()
	{
		return ContactHeaderText.getText();
	}
	
	
	
}
