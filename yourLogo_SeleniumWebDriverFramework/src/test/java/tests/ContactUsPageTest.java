package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseClass;
import pageFactory.ContactUsPage;
import pageFactory.DashboardPage;

public class ContactUsPageTest extends BaseClass	{

	DashboardPage dashboardPageObj;
	ContactUsPage contactUsPageObj;

	@Test(enabled = true)
	public void sendingCompletedMessageToCustomerServices() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"contact-link\"]/a")).click();
		//dashboardPageObj.clickContactUsLink();
		contactUsPageObj.sendCompletedMessageToCustServ();
	}	
}
