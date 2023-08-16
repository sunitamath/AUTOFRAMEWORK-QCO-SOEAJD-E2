package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//1.create a seperate pom class for every webpage
	//2.identify the web element using @FindBy,@FindBy,@FindAll
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	//3 create constructor to initialise WebElements
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	//4 provide getters to access these webElements

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//Bussiness Library-project specific generic method
	/**
	 * this method will perform login operation
	 * @param USERNAME
	 * @param PASSWORD
	 */
	
	
	public void loginToApp(String USERNAME,String PASSWORD)
			{
				userNameEdt.sendKeys(USERNAME);
				passwordEdt.sendKeys(PASSWORD);
				loginbtn.click();
		
			}
	
	
	

}
