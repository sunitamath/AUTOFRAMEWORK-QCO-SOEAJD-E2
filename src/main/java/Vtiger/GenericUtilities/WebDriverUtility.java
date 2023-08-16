package Vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will  wait for the all findElement and findElements
	 * @param driver
	 */
	
	public void waitForElementToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait until the specified element is visible in DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	
	/**
	 * This method will handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * 	 * This method will handle dropdown using value

	 * @param element
	 * @param value
	 */
	
	
	
	public void handleDropDown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
		
	}
	/**
	 * This method will handle dropdown using text
	 * @param text
	 * @param element
	 */
	
	public void handleDropDown(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	
	/**
	 * This method willperform mouse hover action on perticular element
	 * @param driver
	 * @param element
	 */

	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
				
	}
	/**
	 * This method will perform double click anywhere on webpage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * this method will perform double click on web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element);
		
	}
	/**
	 * This method will perform right click anywhere on the webpage
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method will perform right click on web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element);
	}
	/**
	 * This method will perform drag and drop performance on webelements
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 */
	
	public void dragAndDropAction(WebDriver driver,WebElement srcElement,WebElement targetElement)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcElement, targetElement).perform();
	}
	/**
	 * This method is used move cursor anywhere on the web page
	 * @param driver
	 * @param xOffset
	 * @param yOffset
	 */
	
	public void moveAcrossWebpage(WebDriver driver,int xOffset,int yOffset)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(xOffset, yOffset).click().perform();
	}
	/**
	 * This method will scroll vertically for 500pixels
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);","");
	}
	/**
	 * This method will scroll vertically until the element reference
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("Window.scrollBy(0,"+y+");", element);
		
		//js.executeScript("argument[0].scrollIntoView();",element);
	}
	/**
	 * This alert will accept the pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
/**
 *  This alert will cancel the confirmation pop up
 * @param driver
 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will enter the text in prompt popup
	 * @param driver
	 * @param text
	 */
	public void sendTextToAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	/**
	 * This method will captutre the alert message and return the caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method will handle frame based on value of name or ID attribute
	 * @param driver
	 * @param nameorID
	 */
	public void handleFrame(WebDriver driver, String nameorID)
	{
		driver.switchTo().frame(nameorID);
	}
	/**
	 * This method will handle frame based on frame text
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method will handle frame based on webelement
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method will help to switch the controlback to immdiate parent
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will help to switch the control to default(current) page
	 * @param driver
	 */
	public void switchToDefaultPage(WebDriver driver, String partialWinTitle)
	{
		driver.switchTo().defaultContent();
	}
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//step1:capture all windows id's
		Set<String> allWindowsIDs = driver.getWindowHandles();
		//step 2:iterate through all windows id
		for(String winIDs:allWindowsIDs)
		{
			//step3:switch to each id and capture the title
			String currentTitle = driver.switchTo().window(winIDs).getTitle();
			//step4:compare the title with required reference
			if(currentTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	/**
	 * 
	 * @param driver
	 * @param screenShotName
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+screenShotName+".png");
		Files.copy(src, dst);//this class is from commons IO tool
		return dst.getAbsolutePath();//attach the screenshot to extent reports
	}
}



