package base;

import java.util.Set;
import java.util.Iterator;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject	{

	protected WebDriver driver;
	protected Logger log;

	public BasePageObject(WebDriver driver, Logger log)	{
		this.driver = driver;
		this.log = log;
	}

	protected WebElement find(By locator)	{
		return driver.findElement(locator);
	}

	protected void type(String text, By locator)	{
		find(locator).sendKeys(text);
	}

	protected void click(By locator)	{
		find(locator).click();
	}

	public String getCurrentUrl()	{
		return driver.getCurrentUrl();
	}
	
	protected Alert switchToAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}
	
	public void handlingWindows()	{
        String MainWindow=driver.getWindowHandle();		
		
        // To handle all new opened window.				
        Set<String> allWindows = driver.getWindowHandles();		
        Iterator<String> windowsIterator = allWindows.iterator();		
        		
        while(windowsIterator.hasNext())			
        {		
            String ChildWindow=windowsIterator.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);    			
            
			// Closing the Child Window.
                        driver.close();
            }
        }
	}

	public static DesiredCapabilities DesCapMethod()	{
		DesiredCapabilities desCap = new DesiredCapabilities();
		desCap.setCapability("ignoreZoomSetting", true);
		desCap.setCapability("ignoreProtectedModeSettings", true);
		return desCap;
		}
}
