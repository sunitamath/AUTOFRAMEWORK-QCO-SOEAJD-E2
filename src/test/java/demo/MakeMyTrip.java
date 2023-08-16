package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MakeMyTrip {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.easemytrip.co.uk/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
		
		WebElement date = driver.findElement(By.xpath("//div[text()='Jul 2023']/ancestor::div[@class='box']/descendant::li[text()='25']"));

		date.click();
	}

}
