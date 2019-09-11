package pageFactory;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BasePageObject;

public class DashboardPage extends BasePageObject	{
	
	private By idContactUsLink = By.xpath("//*[@id=\"contact-link\"]/a");

	public DashboardPage(WebDriver driver, Logger log)	{
		super(driver, log);
	}

	/*
	public void waitForElement(String item) {
	WebElement idContactUsLink = (new WebDriverWait(driver, 10))
			.until(ExpectedConditions.presenceOfElementLocated(By.id("contact-link")));
	}
	 */

	/*
	public void waitForElement2(String idContactUsLink) {
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contact-link")));
	}
	 */

	public ContactUsPage clickContactUsLink()	{
		log.info("clicking 'Contact us'");
		//click(idContactUsLink);
		driver.findElement(By.xpath("//*[@id=\"contact-link\"]/a")).click();
		return new ContactUsPage(driver, log);
	}

	public void waitForElement() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement idContactUsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='contact-link']/a")));
		idContactUsLink.click();
	}

	public void waitForVisibilityOf(By locator, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			Assert.fail("Element '"+locator+"' is not visible in "+time+" seconds");
		}
	}
}
