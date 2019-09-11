package utilities;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	//this method returns a WebDriver object
	@SuppressWarnings("deprecation")
	public static WebDriver createDriver(String browserType, Logger log)	{
		
		DesiredCapabilities IEdesCap = new DesiredCapabilities();
		IEdesCap.setCapability("ignoreZoomSetting", true);
		IEdesCap.setCapability("ignoreProtectedModeSettings", true);
		//IEdesCap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		log.info("Create Driver: " +  browserType);

		if (browserType.equalsIgnoreCase("firefox"))	{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Selenium-WebDriver\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("IE"))	{
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\Selenium-WebDriver\\iedriverserver.exe");
			return new InternetExplorerDriver(IEdesCap);
		}
		else	{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium-WebDriver\\chromedriver.exe");
			return new ChromeDriver();
		}
	}
}
