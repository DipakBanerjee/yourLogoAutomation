package base;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

	protected static WebDriver driver;
	protected static Logger log;

	@Parameters({ "browser" })
	@BeforeTest(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser, ITestContext ctx) throws Exception {

		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);

		driver = utilities.DriverFactory.createDriver(browser, log);
		driver.manage().deleteAllCookies(); // delete all cookies
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() throws Exception {
		log.info("Shutting down");
		//driver.quit();
	}
}
