package pageFactory;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePageObject;

public class TShirtsPage extends BasePageObject	{

	private By idContact = By.id("id_contact");
	private By emailIdField = By.id("email");
	private By orderIdField = By.id("id_order");
	private By messageBox = By.id("message");
	private By sendMessage = By.id("submitMessage");

	public TShirtsPage(WebDriver driver, Logger log)	{
		super(driver, log);
	}

	public void chooseFromSubjectHeadingDropList()	{

	}

	public void enterEmailAddress()	{
		log.info("entering email address");
		type("test@test.com", emailIdField);
	}
	
	public void enterOrderRef()	{
		log.info("entering order reference");
		type("ON0911191247", orderIdField);
	}
	
	public void enterMessage()	{
		log.info("entering message");
		type("Please send me a catalogue", messageBox);
	}
	
	public void sendMessage()	{
		log.info("clicking 'Send' button");
		click(sendMessage);
	}
	
	public void sendCompletedMessageToCustServ()	{
		log.info("clicking 'Send' button");
		enterEmailAddress();
		enterOrderRef();
		enterMessage();
		sendMessage();
	}
}
