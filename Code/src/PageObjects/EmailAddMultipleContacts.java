package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.Initializations;

public class EmailAddMultipleContacts implements Initializations {
    private WebDriver driver;

    public EmailAddMultipleContacts(WebDriver driver) {
	this.driver = driver;
    }

    // Goto administration --> suggested posts
    public boolean composeEmailAddMultipleContacts() throws InterruptedException {

	WebElement clickSocialHeaderLink = driver.findElement(mailHeaderLink);
	clickSocialHeaderLink.click();
	Thread.sleep(SLEEP_WAIT_2000);

	// Click load more button to get complete count of contacts
	WebElement getComposeEmailButton = driver.findElement(composeEmailButton);
	getComposeEmailButton.click();
	
	Thread.sleep(SLEEP_WAIT_4000);
	WebElement clickWriteOwnEmailPanel = driver.findElement(writeExistingEmailPanel);
	clickWriteOwnEmailPanel.click();

	// Enter a contact in the new email popover
	WebElement recipientField = driver.findElement(By.cssSelector(".recipients-search > form input"));

	// enter contact name into form field
	recipientField.sendKeys(emailContactTestNames);

	// select multiple contacts
	for (int i = 0; i <= NUMBER_OF_CONTACTS;) 
	{
	    recipientField.sendKeys(Keys.TAB);
	    Thread.sleep(SLEEP_WAIT_2000);

	    // get the element for the selected contact & choose the contact
	    WebElement getContact = driver.findElement(selectContact);
	    getContact.sendKeys("\n");
	    Thread.sleep(SLEEP_WAIT_2000);
	}

	return true;

    }
}
